package net.prizowo.keyboardjs;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(KeyboardJS.MOD_ID)
public class KeyboardJS {
    public static final String MOD_ID = "keyboardjs";
    public static final Logger LOGGER = LogManager.getLogger();

    public KeyboardJS() {
        LOGGER.info("KeyboardJS initialized!");
    }
}
