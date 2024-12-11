package me.laysar.f3rebinder.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import me.laysar.f3rebinder.F3ReBinder;
import net.minecraft.client.options.GameOptions;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GameOptions.class)
public abstract class GameOptionsMixin<T> {
	@ModifyExpressionValue(method = "<init>(Lnet/minecraft/client/MinecraftClient;Ljava/io/File;)V",
			at = @At(value = "INVOKE",
					target = "Lorg/apache/commons/lang3/ArrayUtils;addAll([Ljava/lang/Object;[Ljava/lang/Object;)[Ljava/lang/Object;",
					ordinal = 0))
	T[] test(T[] original) {
		//noinspection unchecked
		return (T[]) ArrayUtils.add(original, F3ReBinder.F3_KEY_BINDING);
	}
}
