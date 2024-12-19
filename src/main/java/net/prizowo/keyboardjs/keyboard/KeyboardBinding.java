package net.prizowo.keyboardjs.keyboard;

public class KeyboardBinding {
    private final int key;
    private final boolean pressed;

    public KeyboardBinding(int key, boolean pressed) {
        this.key = key;
        this.pressed = pressed;
    }

    public int getKey() {
        return key;
    }

    public boolean isPressed() {
        return pressed;
    }
} 