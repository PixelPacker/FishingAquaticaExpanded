package net.pixelpacker.mixin.fishing;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import net.pixelpacker.FishingAquaticaExpanded;
import net.pixelpacker.registers.ItemReg;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.pixelpacker.util.crates.DetermineLootCrate.chooseCrate;

@Mixin(FishingBobberEntity.class)
public abstract class FishingMixin {
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
        int randomChance = FishingAquaticaExpanded.rand.nextInt(101);
        int luckOfTheSeaLevel = EnchantmentHelper.getLuckOfTheSea(usedItem);
        if(FishingAquaticaExpanded.DebugMode){
            FishingAquaticaExpanded.LOGGER.info("Rolled: " + randomChance);
        }
        if(usedItem.getItem() == ItemReg.LOOT_CRATE_FISHING_ROD){
            int chanceToGetLootCrate = 100;
            if(getPlayerOwner() != null && randomChance <= chanceToGetLootCrate + luckOfTheSeaLevel){
                ItemStack chosenCrate = chooseCrate(usedItem);
                getPlayerOwner().giveItemStack(chosenCrate);
            }
        }
    }
}
