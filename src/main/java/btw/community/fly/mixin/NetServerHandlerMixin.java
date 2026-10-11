package btw.community.fly.mixin;

import btw.community.fly.FlyMod;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.NetServerHandler;
import net.minecraft.src.Packet10Flying;
import net.minecraft.src.Packet202PlayerAbilities;
import net.minecraft.src.Packet250CustomPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetServerHandler.class)
public class NetServerHandlerMixin {
    @Shadow
    public EntityPlayerMP playerEntity;

    @Shadow
    private int ticksForFloatKick;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void sendFlyAuthOnJoin(CallbackInfo ci) {
        Packet250CustomPayload packet = new Packet250CustomPayload();
        packet.channel = "FLY|ACK";
        packet.data = new byte[]{1};
        packet.length = packet.data.length;

        this.playerEntity.playerNetServerHandler.sendPacketToPlayer(packet);
        FlyMod.LOGGER.info("Sent Fly authorization to " + this.playerEntity.username);
    }

    @Inject(method = "handleFlying", at = @At("HEAD"))
    private void resetFloatKick(Packet10Flying packet, CallbackInfo ci) {
        if (this.playerEntity != null && this.playerEntity.capabilities.isFlying) {
            this.ticksForFloatKick = 0;
        }
    }

    @Inject(method = "handlePlayerAbilities", at = @At("HEAD"))
    private void onHandlePlayerAbilities(Packet202PlayerAbilities packet, CallbackInfo ci) {
        if (this.playerEntity != null && packet.getFlying()) {
            this.playerEntity.capabilities.allowFlying = true;
        }
    }
}
