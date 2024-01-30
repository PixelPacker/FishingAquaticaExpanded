package net.pixelpacker.registers;

import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.pixelpacker.items.fishingrods.LootCrateFishingRod;

public class PredicateRegister extends ModelPredicateProviderRegistry {

    public void registerPredicates(){
        ModelPredicateProviderRegistry.register(ItemReg.LOOT_CRATE_FISHING_ROD, new Identifier("cast"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                boolean bl = entity.getMainHandStack() == stack;
                boolean bl2 = entity.getOffHandStack() == stack;
                if (entity.getMainHandStack().getItem() instanceof LootCrateFishingRod) {
                    bl2 = false;
                }

                return (bl || bl2) && entity instanceof PlayerEntity && ((PlayerEntity)entity).fishHook != null ? 1.0F : 0.0F;
            }
        });
    }

}
