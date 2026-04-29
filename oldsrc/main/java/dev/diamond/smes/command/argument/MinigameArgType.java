package dev.diamond.smes.command.argument;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import dev.diamond.smes.command.argument.abstraction.RegistryArgType;
import dev.diamond.smes.minigame.Minigame;
import dev.diamond.smes.registry.InitRegistries;
import net.minecraft.registry.Registry;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MinigameArgType extends RegistryArgType {
    private static final DynamicCommandExceptionType INVALID_EXCEPTION =
            new DynamicCommandExceptionType((id) -> Text.translatable("smes.cmd.arg.invalid_game", id));

    private MinigameArgType() {}

    public static MinigameArgType minigame() {
        return new MinigameArgType();
    }

    public static Minigame getMinigame(CommandContext<ServerCommandSource> context, String argumentName) throws CommandSyntaxException {
        Identifier identifier = getIdentifier(context, argumentName);
        Minigame minigame = InitRegistries.MINIGAMES.get(identifier);
        if (minigame == null) {
            throw INVALID_EXCEPTION.create(identifier);
        } else {
            return minigame;
        }
    }


    @Override
    public Registry<?> getRegistry() {
        return InitRegistries.MINIGAMES;
    }
}
