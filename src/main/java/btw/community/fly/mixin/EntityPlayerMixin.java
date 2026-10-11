package btw.community.fly.mixin;

import btw.community.fly.FlyMod;
import net.minecraft.src.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayer.class)
public class EntityPlayerMixin {
    @Inject(method = "onUpdate", at = @At("HEAD"))
    private void updateFlyStatus(CallbackInfo ci) {
        EntityPlayer player = (EntityPlayer) (Object) this;

        if (!player.capabilities.isCreativeMode) {
            if (FlyMod.enabled && FlyMod.isAuthorized) {
                player.capabilities.allowFlying = true;
            } else {
                player.capabilities.allowFlying = false;
                player.capabilities.isFlying = false;
            }
        }

        if (player.capabilities.isFlying) {
            player.fallDistance = 0.0F;
        }
    }

    @Inject(method = "fall", at = @At("HEAD"))
    private void handleFallDamage(float distance, CallbackInfo ci) {
        EntityPlayer player = (EntityPlayer) (Object) this;

        // In survival, if the player is not actively flying, ensure fall damage is dealt even if allowFlying is true
        if (!player.capabilities.isCreativeMode && !player.capabilities.isFlying) {
            player.capabilities.allowFlying = false;
        }
    }
}
