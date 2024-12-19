package net.prizowo.keyboardjs.keyboard;

import org.lwjgl.glfw.GLFW;
import java.util.HashMap;
import java.util.Map;

public class KeyMapping {
    public static final Map<String, Integer> KEY_CODES = new HashMap<>();
    public static final Map<Integer, String> CODE_NAMES = new HashMap<>();

    static {
        // 字母键 (A-Z)
        for (char c = 'A'; c <= 'Z'; c++) {
            try {
                addKey(String.valueOf(c), GLFW.class.getField("GLFW_KEY_" + c).getInt(null));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }

        // 数字键 (0-9)
        for (int i = 0; i <= 9; i++) {
            try {
                addKey(String.valueOf(i), GLFW.class.getField("GLFW_KEY_" + i).getInt(null));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }

        // 功能键 (F1-F25)
        for (int i = 1; i <= 25; i++) {
            try {
                addKey("F" + i, GLFW.class.getField("GLFW_KEY_F" + i).getInt(null));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }

        // 特殊键
        addKey("ESCAPE", GLFW.GLFW_KEY_ESCAPE);
        addKey("ENTER", GLFW.GLFW_KEY_ENTER);
        addKey("TAB", GLFW.GLFW_KEY_TAB);
        addKey("BACKSPACE", GLFW.GLFW_KEY_BACKSPACE);
        addKey("INSERT", GLFW.GLFW_KEY_INSERT);
        addKey("DELETE", GLFW.GLFW_KEY_DELETE);
        addKey("RIGHT", GLFW.GLFW_KEY_RIGHT);
        addKey("LEFT", GLFW.GLFW_KEY_LEFT);
        addKey("DOWN", GLFW.GLFW_KEY_DOWN);
        addKey("UP", GLFW.GLFW_KEY_UP);
        addKey("PAGE_UP", GLFW.GLFW_KEY_PAGE_UP);
        addKey("PAGE_DOWN", GLFW.GLFW_KEY_PAGE_DOWN);
        addKey("HOME", GLFW.GLFW_KEY_HOME);
        addKey("END", GLFW.GLFW_KEY_END);
        addKey("CAPS_LOCK", GLFW.GLFW_KEY_CAPS_LOCK);
        addKey("SCROLL_LOCK", GLFW.GLFW_KEY_SCROLL_LOCK);
        addKey("NUM_LOCK", GLFW.GLFW_KEY_NUM_LOCK);
        addKey("PRINT_SCREEN", GLFW.GLFW_KEY_PRINT_SCREEN);
        addKey("PAUSE", GLFW.GLFW_KEY_PAUSE);

        // 修饰键
        addKey("L_SHIFT", GLFW.GLFW_KEY_LEFT_SHIFT);
        addKey("R_SHIFT", GLFW.GLFW_KEY_RIGHT_SHIFT);
        addKey("L_CONTROL", GLFW.GLFW_KEY_LEFT_CONTROL);
        addKey("R_CONTROL", GLFW.GLFW_KEY_RIGHT_CONTROL);
        addKey("L_ALT", GLFW.GLFW_KEY_LEFT_ALT);
        addKey("R_ALT", GLFW.GLFW_KEY_RIGHT_ALT);
        addKey("L_SUPER", GLFW.GLFW_KEY_LEFT_SUPER);
        addKey("R_SUPER", GLFW.GLFW_KEY_RIGHT_SUPER);

        // 小键盘
        addKey("KP_0", GLFW.GLFW_KEY_KP_0);
        addKey("KP_1", GLFW.GLFW_KEY_KP_1);
        addKey("KP_2", GLFW.GLFW_KEY_KP_2);
        addKey("KP_3", GLFW.GLFW_KEY_KP_3);
        addKey("KP_4", GLFW.GLFW_KEY_KP_4);
        addKey("KP_5", GLFW.GLFW_KEY_KP_5);
        addKey("KP_6", GLFW.GLFW_KEY_KP_6);
        addKey("KP_7", GLFW.GLFW_KEY_KP_7);
        addKey("KP_8", GLFW.GLFW_KEY_KP_8);
        addKey("KP_9", GLFW.GLFW_KEY_KP_9);
        addKey("KP_DECIMAL", GLFW.GLFW_KEY_KP_DECIMAL);
        addKey("KP_DIVIDE", GLFW.GLFW_KEY_KP_DIVIDE);
        addKey("KP_MULTIPLY", GLFW.GLFW_KEY_KP_MULTIPLY);
        addKey("KP_SUBTRACT", GLFW.GLFW_KEY_KP_SUBTRACT);
        addKey("KP_ADD", GLFW.GLFW_KEY_KP_ADD);
        addKey("KP_ENTER", GLFW.GLFW_KEY_KP_ENTER);
        addKey("KP_EQUAL", GLFW.GLFW_KEY_KP_EQUAL);

        // 其他符号键
        addKey("SPACE", GLFW.GLFW_KEY_SPACE);
        addKey("APOSTROPHE", GLFW.GLFW_KEY_APOSTROPHE);
        addKey("COMMA", GLFW.GLFW_KEY_COMMA);
        addKey("MINUS", GLFW.GLFW_KEY_MINUS);
        addKey("PERIOD", GLFW.GLFW_KEY_PERIOD);
        addKey("SLASH", GLFW.GLFW_KEY_SLASH);
        addKey("SEMICOLON", GLFW.GLFW_KEY_SEMICOLON);
        addKey("EQUAL", GLFW.GLFW_KEY_EQUAL);
        addKey("LEFT_BRACKET", GLFW.GLFW_KEY_LEFT_BRACKET);
        addKey("BACKSLASH", GLFW.GLFW_KEY_BACKSLASH);
        addKey("RIGHT_BRACKET", GLFW.GLFW_KEY_RIGHT_BRACKET);
        addKey("GRAVE_ACCENT", GLFW.GLFW_KEY_GRAVE_ACCENT);
    }

    private static void addKey(String name, int code) {
        KEY_CODES.put(name, code);
        CODE_NAMES.put(code, name);
    }

    public static int getKeyCode(String name) {
        return KEY_CODES.getOrDefault(name, GLFW.GLFW_KEY_UNKNOWN);
    }

    public static String getKeyName(int code) {
        return CODE_NAMES.getOrDefault(code, "UNKNOWN");
    }
} 