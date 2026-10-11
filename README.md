# Fly CE

Survival flight toggle for **Better Than Wolves CE 3.0.0+** (Minecraft 1.6.4).

## Features

- **✈️ Toggle Flight**: Press `F` (customizable in Controls) to enable/disable creative-style flight in survival mode.
- **💬 Chat Feedback**: Color-coded on-screen message confirms when Fly Mode is enabled or disabled.
- **🛬 Clean Disable**: Turning off flight immediately stops mid-air flying and revokes the flight capability.
- **💀 Proper Fall Damage**: Fully respects Minecraft survival fall mechanics. Disabling flight mid-air drops you and accurately deals impact damage upon hitting the ground.
- **🔒 Server-Side Protection**: Uses a `FLY|ACK` handshake packet. Flight is automatically authorized in Singleplayer, and protected on multiplayer servers so clients cannot cheat without server consent.
- **⌨️ Customizable Keybind**: Integrated directly into Minecraft's native Options > Controls menu.
- **🛡️ Chat Typing Guard**: Won't accidentally toggle flight while chatting, editing signs, or browsing inventories.

## Installation

1. Ensure you have **Better Than Wolves CE 3.0.0+** installed with Fabric Loader.
2. Drop `fly-ce-1.0.0.jar` into your `mods` folder.

## Usage

- Press **F** in-game to toggle flight on/off.
- While enabled, you can freely fly around in survival.
- Press **F** again to disable — flight stops and fall damage applies if falling.

## Building from Source

```bash
./gradlew build --no-daemon
```

The built jar will be located in `build/libs/fly-ce-1.0.0.jar`.

## Author
- **chronicboy31**

## License
MIT
