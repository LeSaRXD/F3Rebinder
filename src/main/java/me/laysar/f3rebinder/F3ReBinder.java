package me.laysar.f3rebinder;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.options.KeyBinding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Unique;

public class F3ReBinder implements ClientModInitializer {

	public static final String MOD_ID = "f3rebinder";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Unique
	public static final KeyBinding F3_KEY_BINDING = new KeyBinding("key.debug_menu", GLFW.GLFW_KEY_F3, "key.categories.misc");

	@Override
	public void onInitializeClient() {
		LOGGER.info("F3 re-binder initialized");
	}
}
