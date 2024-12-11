package me.laysar.f3rebinder.mixin;

import me.laysar.f3rebinder.F3ReBinder;
import net.minecraft.client.Keyboard;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Keyboard.class)
public abstract class KeyboardMixin {
	@ModifyVariable(method = "onKey(JIIII)V", at = @At("HEAD"), argsOnly = true, ordinal = 0)
	int modifyKeyCode(int oldCode) {
		if (oldCode == GLFW.GLFW_KEY_UNKNOWN)
			return oldCode;

		KeyBindingAccessor customF3KeyBindingAccessor = (KeyBindingAccessor) F3ReBinder.F3_KEY_BINDING;
		if (oldCode == customF3KeyBindingAccessor.getBoundKey().getCode())
			return GLFW.GLFW_KEY_F3;

		return oldCode;
	}
}
