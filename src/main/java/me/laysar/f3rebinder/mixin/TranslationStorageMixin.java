package me.laysar.f3rebinder.mixin;

import net.minecraft.client.resource.language.TranslationStorage;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Map;

@Mixin(TranslationStorage.class)
public class TranslationStorageMixin {
	@Contract("_ -> param1")
	@ModifyVariable(method = "load(Lnet/minecraft/resource/ResourceManager;Ljava/util/List;)Lnet/minecraft/client/resource/language/TranslationStorage;",
			at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMap;copyOf(Ljava/util/Map;)Lcom/google/common/collect/ImmutableMap;"))
	private static @NotNull Map<String, String> test(@NotNull Map<String, String> map) {
		map.put("key.debug_menu", "F3");
		return map;
	}
}
