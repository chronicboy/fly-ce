package btw.community.fly;

import net.fabricmc.api.ModInitializer;
import net.minecraft.src.KeyBinding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

public class FlyMod implements ModInitializer {
    public static final String MOD_ID = "fly-ce";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static boolean enabled = false;
    public static boolean isAuthorized = false;

    // Customizable keybind — registered in Minecraft's options
    public static KeyBinding flyKey = new KeyBinding("Fly Toggle", Keyboard.KEY_F);

    @Override
    public void onInitialize() {
        LOGGER.info("Fly CE Initialized");
    }
}
