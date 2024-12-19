package net.prizowo.keyboardjs.keyboard;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class KeyboardEventHandler {
    private final List<Consumer<KeyboardBinding>> globalListeners = new ArrayList<>();

    public void addGlobalKeyListener(Consumer<KeyboardBinding> listener) {
        globalListeners.add(listener);
    }

    public static boolean isKeyPressed(String key) {
        long window = Minecraft.getInstance().getWindow().getWindow();
        int keyCode = InputConstants.getKey(key).getValue();
        return InputConstants.isKeyDown(window, keyCode);
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.Key event) {
        KeyboardBinding binding = new KeyboardBinding(
            event.getKey(),
            event.getAction() > 0  // GLFW_PRESS or GLFW_REPEAT
        );

        for (Consumer<KeyboardBinding> listener : globalListeners) {
            listener.accept(binding);
        }
    }
} 