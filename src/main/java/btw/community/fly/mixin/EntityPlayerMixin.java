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

        if (FlyMod.enabled) {
            // Track fall distance ourselves before allowFlying zeroes it
            if (!player.capabilities.isFlying && !player.onGround) {
                // Player is falling (not flying, not on ground) — accumulate fall distance
                if (player.motionY < 0) {
                    FlyMod.trackedFallDistance += (float) (-player.motionY);
                }
            } else if (player.onGround) {
                // Landed safely while flying is enabled — reset tracker
                FlyMod.trackedFallDistance = 0.0f;
            }

            // If player started flying, they chose to fly — reset fall tracking
            if (player.capabilities.isFlying && !FlyMod.wasFlying) {
                FlyMod.trackedFallDistance = 0.0f;
            }
            FlyMod.wasFlying = player.capabilities.isFlying;

            player.capabilities.allowFlying = true;
        }
    }
}
