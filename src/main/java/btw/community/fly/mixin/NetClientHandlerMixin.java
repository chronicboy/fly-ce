package btw.community.fly.mixin;

import btw.community.fly.FlyMod;
import net.minecraft.src.NetClientHandler;
import net.minecraft.src.Packet250CustomPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetClientHandler.class)
public class NetClientHandlerMixin {

    @Inject(method = "<init>", at = @At("RETURN"))
    private void resetAuthOnConnect(CallbackInfo ci) {
        FlyMod.isAuthorized = false;
        FlyMod.enabled = false;
    }

    @Inject(method = "handleCustomPayload", at = @At("HEAD"), cancellable = true)
    private void handleFlyAuth(Packet250CustomPayload packet, CallbackInfo ci) {
        if ("FLY|ACK".equals(packet.channel)) {
            if (packet.data != null && packet.data.length > 0 && packet.data[0] == 1) {
                FlyMod.isAuthorized = true;
                FlyMod.LOGGER.info("Fly authorized by server.");
            }
            ci.cancel();
        }
    }
}
