package btw.community.fly;

import net.fabricmc.api.ModInitializer;
import net.minecraft.src.KeyBinding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FlyMod implements ModInitializer {
    public static final String MOD_ID = "fly-ce";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static boolean enabled = false;

    // Customizable keybind — registered in Minecraft's options
    public static KeyBinding flyKey = new KeyBinding("Fly Toggle", org.lwjgl.input.Keyboard.KEY_F);

    // Track fall distance ourselves since allowFlying zeroes it
    public static float trackedFallDistance = 0.0f;
    public static boolean wasFlying = false;

    @Override
    public void onInitialize() {
        LOGGER.info("Fly CE Initialized");
    }
}
