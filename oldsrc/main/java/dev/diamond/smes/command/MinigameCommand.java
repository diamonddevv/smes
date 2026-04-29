package dev.diamond.smes.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.diamond.smes.command.argument.MinigameArgType;
import dev.diamond.smes.minigame.Minigame;
import dev.diamond.smes.minigame.MinigameManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class MinigameCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(
                literal("minigame").requires(src -> src.hasPermissionLevel(4))
                        .then(literal("load")
                                .then(argument("minigame", MinigameArgType.minigame())
                                        .executes(MinigameCommand::executeLoadMinigame)
                                )
                        )
                        .then(literal("start")
                                .executes(MinigameCommand::executeStart)
                        )
                        .then(literal("stop")
                                .executes(MinigameCommand::executeStop)
                        )
        );
    }

    private static int executeLoadMinigame(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        Minigame minigame = MinigameArgType.getMinigame(ctx, "minigame");
        ctx.getSource().sendFeedback(
                () -> Text.translatable("smes.cmd.feedback.load").append(Text.translatable(minigame.getTranslationKey())),
                true
        );
        MinigameManager.getInstance().load(minigame);
        return 1;
    }

    private static int executeStart(CommandContext<ServerCommandSource> ctx) {
        MinigameManager.getInstance().start();
        ctx.getSource().sendFeedback(
                () -> Text.translatable("smes.cmd.feedback.start"),
                true
        );
        return 1;
    }

    private static int executeStop(CommandContext<ServerCommandSource> ctx) {
        MinigameManager.getInstance().stop();
        ctx.getSource().sendFeedback(
                () -> Text.translatable("smes.cmd.feedback.stop"),
                true
        );
        return 1;
    }

}
