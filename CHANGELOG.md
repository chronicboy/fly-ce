## 1.0.0

### Features
* Survival flight toggle — press `F` (customizable in Controls) to enable/disable creative-style flight in survival mode.
* Color-coded chat feedback: green "Enabled" / red "Disabled" messages.
* Clean disable — turning off flight immediately stops mid-air flying and revokes the capability.
* Proper fall damage — fall distance is tracked independently so disabling flight mid-air correctly applies fall damage.
* Server enforced — `isRequiredClientAndServer = true` prevents cheating on servers without the mod.
* Customizable keybind via Minecraft's built-in Controls menu.

### Bug Fixes
* Fixed F key toggling flight while typing in chat, signs, or any GUI screen.
* Fixed no-fall-damage exploit — vanilla `allowFlying` zeroes `fallDistance`, so we track it independently and restore it on disable.

### Technical
* `EntityPlayerMixin`: Injects into `onUpdate` to set `allowFlying = true` while enabled and track fall distance.
* `MinecraftMixin`: Injects into `runTick` to handle the keybind toggle with `currentScreen` guard.
* Uses `KeyBinding` for proper customizable, edge-triggered keybind support.
