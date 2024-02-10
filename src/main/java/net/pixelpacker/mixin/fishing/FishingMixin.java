package net.pixelpacker.mixin.fishing;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.pixelpacker.FishingAquaticaExpanded;
import net.pixelpacker.registers.ItemReg;
import net.pixelpacker.registers.LootTableReg;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;


@Mixin(FishingBobberEntity.class)
public abstract class FishingMixin extends ProjectileEntity{
    public FishingMixin(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow @Nullable public abstract PlayerEntity getPlayerOwner();
    @Inject(method = "use", at = @At(value = "RETURN", target = "Lnet/minecraft/entity/projectile/FishingBobberEntity;use(Lnet/minecraft/item/ItemStack;)I"))
    public void use(ItemStack usedItem, CallbackInfoReturnable<Integer> cir){
        //IMPORTANT
        //Should stop the player from getting crates from entities they shouldn't be
        if(cir.getReturnValue() != 1){
            if(FishingAquaticaExpanded.DebugMode){
                FishingAquaticaExpanded.LOGGER.info("Player has wrong kind of entity hooked.");
            }
            return;
        }
        PlayerEntity player = getPlayerOwner();
        MinecraftServer server = this.getServer();
        int randomChance = FishingAquaticaExpanded.rand.nextInt(101);
        int luckOfTheSeaLevel = EnchantmentHelper.getLuckOfTheSea(usedItem);
        if(FishingAquaticaExpanded.DebugMode){
            FishingAquaticaExpanded.LOGGER.info("Rolled: " + randomChance);
        }
        if(usedItem.getItem() == ItemReg.LOOT_CRATE_FISHING_ROD){
            int chanceToGetLootCrate = FishingAquaticaExpanded.CONFIG.crateChance();
            if(player != null && server != null && randomChance <= chanceToGetLootCrate + luckOfTheSeaLevel){
                LootContextParameterSet lootContextParameterSet = (new LootContextParameterSet.Builder((ServerWorld)player.getWorld())).add(LootContextParameters.TOOL, usedItem).add(LootContextParameters.ORIGIN, player.getPos()).build(LootContextTypes.FISHING);
                LootTable lootTable = server.getLootManager().getLootTable(LootTableReg.TIER_ONE_CRATES);
                List<ItemStack> crateList = lootTable.generateLoot(lootContextParameterSet);
                for (ItemStack crate : crateList) {
                    ItemEntity itemEntity = new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), crate);
                    double d = player.getX() - this.getX();
                    double e = player.getY() - this.getY();
                    double f = player.getZ() - this.getZ();
                    itemEntity.setVelocity(d * 0.1, e * 0.1 + Math.sqrt(Math.sqrt(d * d + e * e + f * f)) * 0.08, f * 0.1);
                    this.getWorld().spawnEntity(itemEntity);
                }
            }
        }
    }
}
