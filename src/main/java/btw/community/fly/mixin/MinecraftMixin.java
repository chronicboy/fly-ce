package btw.community.fly.mixin;

import btw.community.fly.FlyMod;
import net.minecraft.src.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(method = "runTick", at = @At("HEAD"))
    private void flyKeybind(CallbackInfo ci) {
        Minecraft mc = (Minecraft) (Object) this;

        // Auto-authorize in Singleplayer
        if (mc.isSingleplayer()) {
            FlyMod.isAuthorized = true;
        }

        // Don't process keybinds when a screen is open (chat, signs, inventories, etc.)
        if (mc.currentScreen != null || mc.thePlayer == null || mc.theWorld == null) {
            return;
        }

        if (FlyMod.flyKey.isPressed()) {
            if (!FlyMod.isAuthorized) {
                FlyMod.enabled = false;
                mc.thePlayer.addChatMessage("\u00a7cFlight is not enabled on this server.");
                return;
            }

            FlyMod.enabled = !FlyMod.enabled;
            mc.thePlayer.addChatMessage("Fly Mode: " + (FlyMod.enabled ? "\u00a7aEnabled" : "\u00a7cDisabled"));

            if (FlyMod.enabled) {
                mc.thePlayer.capabilities.allowFlying = true;
                mc.thePlayer.capabilities.isFlying = true;
                mc.thePlayer.fallDistance = 0.0F;
                mc.thePlayer.sendPlayerAbilities();
            } else {
                mc.thePlayer.capabilities.isFlying = false;
                if (!mc.thePlayer.capabilities.isCreativeMode) {
                    mc.thePlayer.capabilities.allowFlying = false;
                }
                mc.thePlayer.fallDistance = 0.0F;
                mc.thePlayer.sendPlayerAbilities();
            }
        }
    }
}
