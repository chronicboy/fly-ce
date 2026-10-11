package btw.community.fly;

import api.AddonHandler;
import api.BTWAddon;

public class FlyAddon extends BTWAddon {
    private static FlyAddon instance;

    public FlyAddon() {
        // Optional client/server mod with handshake authentication
        this.isRequiredClientAndServer = false;
    }

    @Override
    public void initialize() {
        instance = this;
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initialized.");
    }

    public static FlyAddon getInstance() {
        if (instance == null)
            instance = new FlyAddon();
        return instance;
    }
}