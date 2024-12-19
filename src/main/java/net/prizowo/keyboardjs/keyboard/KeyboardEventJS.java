package net.prizowo.keyboardjs.keyboard;

import dev.latvian.mods.kubejs.event.EventJS;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.server.ServerLifecycleHooks;

public class KeyboardEventJS extends EventJS {
    private final String key;
    private final int keyValue;
    private final boolean pressed;
    private final LocalPlayer clientPlayer;
    private final ServerPlayer serverPlayer;
    private final Level clientLevel;
    private final ServerLevel serverLevel;
    private final MinecraftServer server;

    public KeyboardEventJS(String key, int keyValue, boolean pressed, LocalPlayer clientPlayer, Level clientLevel, ServerPlayer serverPlayer) {
        this.key = key;
        this.keyValue = keyValue;
        this.pressed = pressed;
        this.clientPlayer = clientPlayer;
        this.clientLevel = clientLevel;
        
        if (serverPlayer != null) {
            // 如果直接提供了服务器玩家，使用它
            this.server = serverPlayer.getServer();
            this.serverPlayer = serverPlayer;
            this.serverLevel = serverPlayer.serverLevel();
        } else if (clientPlayer != null) {
            // 否则尝试从客户端玩家获取
            this.server = ServerLifecycleHooks.getCurrentServer();
            if (server != null) {
                this.serverPlayer = server.getPlayerList().getPlayer(clientPlayer.getUUID());
                this.serverLevel = serverPlayer != null ? serverPlayer.serverLevel() : null;
            } else {
                this.serverPlayer = null;
                this.serverLevel = null;
            }
        } else {
            this.server = null;
            this.serverPlayer = null;
            this.serverLevel = null;
        }
    }

    public String getKey() {
        return key;
    }

    public int getKeyValue() {
        return keyValue;
    }

    public boolean isPressed() {
        return pressed;
    }

    public LocalPlayer getClientPlayer() {
        return clientPlayer;
    }

    public ServerPlayer getPlayer() {
        return serverPlayer;
    }

    public Level getClientLevel() {
        return clientLevel;
    }

    public ServerLevel getLevel() {
        return serverLevel;
    }

    public MinecraftServer getServer() {
        return server;
    }

    public boolean hasServerAccess() {
        return server != null && serverPlayer != null && serverLevel != null;
    }

    public enum Keys {
        A, B, C, D, E, F, G, H, I, J, K, L, M,
        N, O, P, Q, R, S, T, U, V, W, X, Y, Z,
        
        NUM_0, NUM_1, NUM_2, NUM_3, NUM_4,
        NUM_5, NUM_6, NUM_7, NUM_8, NUM_9,
        
        F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12,
        F13, F14, F15, F16, F17, F18, F19, F20, F21, F22, F23, F24, F25,
        
        ESCAPE, ENTER, TAB, BACKSPACE, INSERT, DELETE,
        RIGHT, LEFT, DOWN, UP, PAGE_UP, PAGE_DOWN,
        HOME, END, CAPS_LOCK, SCROLL_LOCK, NUM_LOCK,
        PRINT_SCREEN, PAUSE, MENU,
        
        L_SHIFT, R_SHIFT, L_CONTROL, R_CONTROL,
        L_ALT, R_ALT, L_SUPER, R_SUPER, L_WIN, R_WIN,
        
        KP_0, KP_1, KP_2, KP_3, KP_4, KP_5, KP_6, KP_7, KP_8, KP_9,
        KP_DECIMAL, KP_DIVIDE, KP_MULTIPLY, KP_SUBTRACT,
        KP_ADD, KP_ENTER, KP_EQUAL,
        
        VOLUME_MUTE, VOLUME_UP, VOLUME_DOWN,
        MEDIA_PLAY_PAUSE, MEDIA_STOP,
        MEDIA_PREV_TRACK, MEDIA_NEXT_TRACK,
        
        BROWSER_BACK, BROWSER_FORWARD, BROWSER_REFRESH,
        BROWSER_STOP, BROWSER_SEARCH, BROWSER_FAVORITES,
        BROWSER_HOME,
        
        MAIL, CALCULATOR, FILE_EXPLORER, MEDIA_SELECT,
        MY_COMPUTER, APP_1, APP_2,
        
        SPACE, APOSTROPHE, COMMA, MINUS, PERIOD, SLASH,
        SEMICOLON, EQUAL, LEFT_BRACKET, BACKSLASH,
        RIGHT_BRACKET, GRAVE_ACCENT, WORLD_1, WORLD_2,
        
        CONVERT, NON_CONVERT, YEN, KANJI,
        
        SECTION, MUTE,
        POWER, SLEEP, WAKE, HELP, UNDO, REDO, NEW,
        OPEN, CLOSE, REPLY, FORWARD, SEND, SPELL_CHECK,
        TOGGLE_DICTATE, MIC, BRIGHTNESS_DOWN, BRIGHTNESS_UP,
        
        MOUSE_LEFT, MOUSE_RIGHT, MOUSE_MIDDLE,
        MOUSE_4, MOUSE_5, MOUSE_6, MOUSE_7, MOUSE_8;

        @Override
        public String toString() {
            return name();
        }
    }

    public boolean is(String keyName) {
        // 确保转换为大写
        return this.keyValue == KeyMapping.getKeyCode(keyName.toUpperCase());
    }

    public boolean is(Keys key) {
        return this.is(key.name());
    }
} 