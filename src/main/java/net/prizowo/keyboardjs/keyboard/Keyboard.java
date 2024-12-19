package net.prizowo.keyboardjs.keyboard;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;


public class Keyboard {
    public Keyboard() {} // 防止实例化

    public static boolean pressed(KeyboardEventJS.Keys key) {
        long window = Minecraft.getInstance().getWindow().getWindow();
        return InputConstants.isKeyDown(window, KeyMapping.getKeyCode(key.name()));
    }

    public static boolean released(KeyboardEventJS.Keys key) {
        return !pressed(key);
    }
} 