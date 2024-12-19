package net.prizowo.keyboardjs.keyboard;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

public record Keyboard() {
    /**
     * 检查按键是否被按下
     * @param key 要检查的按键
     * @return 如果按键被按下返回true
     */
    public static boolean pressed(KeyboardEventJS.Keys key) {
        long window = Minecraft.getInstance().getWindow().getWindow();
        
        if (key.name().startsWith("MOUSE_")) {
            int mouseButton = getMouseButton(key.name());
            if (mouseButton != -1) {
                return GLFW.glfwGetMouseButton(window, mouseButton) == GLFW.GLFW_PRESS;
            }
        }
        
        return InputConstants.isKeyDown(window, key.ordinal());
    }

    /**
     * 检查按键是否被释放
     * @param key 要检查的按键
     * @return 如果按键被释放返回true
     */
    public static boolean released(KeyboardEventJS.Keys key) {
        return !pressed(key);
    }

    private static int getMouseButton(String keyName) {
        return switch (keyName) {
            case "MOUSE_LEFT" -> GLFW.GLFW_MOUSE_BUTTON_LEFT;
            case "MOUSE_RIGHT" -> GLFW.GLFW_MOUSE_BUTTON_RIGHT;
            case "MOUSE_MIDDLE" -> GLFW.GLFW_MOUSE_BUTTON_MIDDLE;
            case "MOUSE_4" -> 3;
            case "MOUSE_5" -> 4;
            case "MOUSE_6" -> 5;
            case "MOUSE_7" -> 6;
            case "MOUSE_8" -> 7;
            default -> -1;
        };
    }
} 