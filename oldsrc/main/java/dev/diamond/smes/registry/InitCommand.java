package dev.diamond.smes.registry;

import dev.diamond.smes.SmesMod;
import dev.diamond.smes.command.MinigameCommand;
import dev.diamond.smes.command.argument.MinigameArgType;
import net.diamonddev.libgenetics.common.api.v1.interfaces.RegistryInitializer;
import net.fabricmc.fabric.api.command.v2.ArgumentTypeRegistry;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.argument.serialize.ConstantArgumentSerializer;

public class InitCommand implements RegistryInitializer {
    @Override
    public void register() {
        ArgumentTypeRegistry.registerArgumentType(SmesMod.id("minigame_command_arg"),
                MinigameArgType.class, ConstantArgumentSerializer.of(MinigameArgType::minigame));

        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            // Register Commands Here
            MinigameCommand.register(dispatcher);
        });
    }
}
