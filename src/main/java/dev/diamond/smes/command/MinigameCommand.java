package dev.diamond.smes.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import dev.diamond.smes.data.MinigameResourceLoader;
import dev.diamond.smes.minigame.MinigameEntry;
import dev.diamond.smes.net.ClientboundOpenMinigameMenuPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.permissions.Permissions;

import static net.minecraft.commands.Commands.literal;

public class MinigameCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext ctx, Commands.CommandSelection selection) {
        dispatcher.register(
                literal("minigame").requires(src -> src.permissions().hasPermission(Permissions.COMMANDS_MODERATOR))
                        .executes(MinigameCommand::minigame)
        );
    }

    private static int minigame(CommandContext<CommandSourceStack> ctx) {
        // open the screen
        if  (ctx.getSource().getPlayer() != null) {
            ServerPlayNetworking.send(ctx.getSource().getPlayer(), new ClientboundOpenMinigameMenuPacket(MinigameEntry.getDisplays()));
        }

        return 0;
    }
}
