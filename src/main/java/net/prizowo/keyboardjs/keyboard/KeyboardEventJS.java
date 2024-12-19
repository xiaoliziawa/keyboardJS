package net.prizowo.keyboardjs.keyboard;

import dev.latvian.mods.kubejs.event.EventJS;

public class KeyboardEventJS extends EventJS {
    private final String key;
    private final int keyValue;
    private final boolean pressed;

    public KeyboardEventJS(String key, int keyValue, boolean pressed) {
        this.key = key;
        this.keyValue = keyValue;
        this.pressed = pressed;
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

    /**
     * 可用的按键枚举
     */
    public enum Keys {
        A, B, C, D, E, F, G, H, I, J, K, L, M,
        N, O, P, Q, R, S, T, U, V, W, X, Y, Z,
        
        NUM_0, NUM_1, NUM_2, NUM_3, NUM_4,
        NUM_5, NUM_6, NUM_7, NUM_8, NUM_9,
        
        F1, F2, F3, F4, F5, F6, F7, F8, F9, F10, F11, F12,

        ESCAPE, ENTER, TAB, BACKSPACE, INSERT, DELETE,
        RIGHT, LEFT, DOWN, UP, PAGE_UP, PAGE_DOWN,
        HOME, END, CAPS_LOCK, SCROLL_LOCK, NUM_LOCK,
        PRINT_SCREEN, PAUSE, MENU,
        
        L_SHIFT, R_SHIFT, L_CONTROL, R_CONTROL,
        L_ALT, R_ALT, L_SUPER, R_SUPER, L_WIN, R_WIN,
        
        KP_0, KP_1, KP_2, KP_3, KP_4, KP_5, KP_6, KP_7, KP_8, KP_9,
        KP_DECIMAL, KP_DIVIDE, KP_MULTIPLY, KP_SUBTRACT,
        KP_ADD, KP_ENTER, KP_EQUAL,
        
        SPACE, APOSTROPHE, COMMA, MINUS, PERIOD, SLASH,
        SEMICOLON, EQUAL, LEFT_BRACKET, BACKSLASH,
        RIGHT_BRACKET, GRAVE_ACCENT,
        
        MOUSE_LEFT, MOUSE_RIGHT, MOUSE_MIDDLE,
        MOUSE_4, MOUSE_5, MOUSE_6, MOUSE_7, MOUSE_8;

        @Override
        public String toString() {
            return name();
        }
    }
} 