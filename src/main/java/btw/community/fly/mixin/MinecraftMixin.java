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
        Minecraft mc = Minecraft.getMinecraft();

        // Don't process keybinds when a screen is open (chat, signs, inventories, etc.)
        if (mc.currentScreen != null || mc.thePlayer == null) {
            return;
        }

        if (FlyMod.flyKey.isPressed()) {
            FlyMod.enabled = !FlyMod.enabled;
            mc.thePlayer.addChatMessage("Fly Mode: " + (FlyMod.enabled ? "\u00a7aEnabled" : "\u00a7cDisabled"));

            if (!FlyMod.enabled) {
                // Disable flight immediately
                mc.thePlayer.capabilities.isFlying = false;
                mc.thePlayer.capabilities.allowFlying = false;

                // Restore tracked fall distance so the player takes proper fall damage
                mc.thePlayer.fallDistance = FlyMod.trackedFallDistance;
                FlyMod.trackedFallDistance = 0.0f;
                FlyMod.wasFlying = false;
            }
        }
    }
}
