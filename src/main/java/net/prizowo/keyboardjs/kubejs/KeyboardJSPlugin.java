package net.prizowo.keyboardjs.kubejs;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import net.prizowo.keyboardjs.keyboard.Keyboard;
import net.prizowo.keyboardjs.keyboard.KeyboardEventJS;

public class KeyboardJSPlugin extends KubeJSPlugin {
    @Override
    public void registerBindings(BindingsEvent event) {
        event.add("Keyboard", new Keyboard());
        event.add("Keys", KeyboardEventJS.Keys.class);
    }
}

