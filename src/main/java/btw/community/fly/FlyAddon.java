package btw.community.fly;

import api.AddonHandler;
import api.BTWAddon;

public class FlyAddon extends BTWAddon {
    private static FlyAddon instance;

    public FlyAddon() {
        // Server-enforced: the server must also have this mod installed
        // This prevents cheating on servers that don't allow flight
        this.isRequiredClientAndServer = true;
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