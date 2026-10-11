## 1.0.0

### Features
* Survival flight toggle — press `F` (customizable in Controls) to enable/disable creative-style flight in survival mode.
* Server-side authorization protection — uses `FLY|ACK` custom payload handshake; automatically authorized in Singleplayer, prevents cheating on unauthorized multiplayer servers.
* Customizable keybind registered in Minecraft's built-in Controls menu.
* Color-coded chat feedback: green "Enabled" / red "Disabled" messages.
* Clean flight transitions with zero float kicks on authorized servers.

### Bug Fixes
* Fixed survival fall damage bug: disabling flight mode previously left `allowFlying` enabled on the server player entity, causing the player to never take fall damage again in survival.
* Fixed fall damage bypass when walking/falling off ledges in survival without actively flying.
* Fixed `F` key triggering while typing in chat, signs, or inventory screens.
* Fixed keybind not being rebindable or saved in `options.txt`.

### Technical
* `GameSettingsMixin`: Injects into `GameSettings.<init>` to register `flyKey` into `keyBindings`.
* `NetClientHandlerMixin`: Handles `FLY|ACK` packet payload to authorize client flight and clears authorization on disconnect.
* `NetServerHandlerMixin`: Sends `FLY|ACK` to joining clients, updates abilities on server, and prevents floating kicks during active flight.
* `EntityPlayerMixin`: Updates player abilities per tick, resets `fallDistance` while actively flying, and restores fall damage in `fall()` when not flying.
* Split mixins into common and client-only in `fly-ce.mixins.json` with `JAVA_17` compatibility.
