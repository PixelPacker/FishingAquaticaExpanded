package net.pixelpacker.mixin.fishing;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import net.pixelpacker.registers.TagReg;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FishingBobberEntity.class)
public class RemoveIfInvalidMixin {
    @Inject(method="removeIfInvalid", at = @At(value = "HEAD"), cancellable = true)
    private void removeIfInvalid(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        //This is probably exploitable due to not checking the distance so should probably get fixed in the future.
        ItemStack itemStack = player.getMainHandStack();
        ItemStack itemStack2 = player.getOffHandStack();
        boolean bl = itemStack.isIn(TagReg.FISHING_RODS);
        boolean bl2 = itemStack2.isIn(TagReg.FISHING_RODS);
        //Don't setup a return to true to allow for other mods to work with fishing bobbers
        if (!player.isRemoved() && player.isAlive() && (bl || bl2)) {
            cir.setReturnValue(false);
        }
    }
}
