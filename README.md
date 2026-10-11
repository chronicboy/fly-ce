# Fly CE

Survival flight toggle for **Better Than Wolves CE 3.0.0+** (Minecraft 1.6.4).

## Features

- **✈️ Toggle Flight**: Press `F` (customizable in Controls) to enable/disable creative-style flight in survival mode.
- **💬 Chat Feedback**: Color-coded on-screen message confirms when Fly Mode is enabled or disabled.
- **🛬 Clean Disable**: Turning off flight immediately stops mid-air flying and revokes the flight capability.
- **💀 Proper Fall Damage**: Fall distance is tracked independently — disabling flight mid-air correctly applies fall damage, preventing the no-fall-damage exploit.
- **🔒 Server Enforced**: Must be installed on both client and server (`isRequiredClientAndServer = true`). Cannot be used to cheat on servers that don't allow it.
- **⌨️ Customizable Keybind**: Uses Minecraft's `KeyBinding` system — rebind in Options > Controls.

## Installation

1. Ensure you have **Better Than Wolves CE 3.0.0+** installed with Fabric Loader.
2. Drop `fly-ce-1.0.0.jar` into your `mods` folder.
3. This mod is **Server-Enforced**. It must be installed on the server to function.

## Usage

- Press **F** in-game to toggle flight on/off (won't trigger while typing in chat or signs).
- While enabled, double-tap jump to start flying (standard Minecraft creative flight).
- Press **F** again to disable — you will stop flying and take fall damage if airborne.

## Building from Source

```bash
./gradlew build
```

The built jar will be in `build/libs/`.

## Author
- **chronicboy31**

## License
MIT
