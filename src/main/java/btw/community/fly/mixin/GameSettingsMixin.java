package btw.community.fly.mixin;

import btw.community.fly.FlyMod;
import net.minecraft.src.GameSettings;
import net.minecraft.src.KeyBinding;
import net.minecraft.src.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.util.Arrays;

@Mixin(GameSettings.class)
public class GameSettingsMixin {
    @Shadow
    public KeyBinding[] keyBindings;

    @Inject(method = "<init>(Lnet/minecraft/src/Minecraft;Ljava/io/File;)V", at = @At("RETURN"))
    private void addFlyKeyBinding(Minecraft mc, File file, CallbackInfo ci) {
        KeyBinding[] newKeyBindings = Arrays.copyOf(this.keyBindings, this.keyBindings.length + 1);
        newKeyBindings[this.keyBindings.length] = FlyMod.flyKey;
        this.keyBindings = newKeyBindings;
    }
}
