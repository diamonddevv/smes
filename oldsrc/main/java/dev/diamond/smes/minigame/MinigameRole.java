package dev.diamond.smes.minigame;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

public class MinigameRole {
    private final Minigame minigame;
    private final Identifier id;

    public MinigameRole(Minigame minigame, Identifier id) {
        this.minigame = minigame;
        this.id = id;
    }

    public String getTranslationKey() {
        return "smes.role." + id.getNamespace() + "." + id.getPath();
    }

    public static void serialize(MinigameRole role, PacketByteBuf buf) {
        buf.writeIdentifier(role.id);
    }
    public static MinigameRole deserialize(Minigame minigame, PacketByteBuf buf) {
        Identifier id = buf.readIdentifier();

        for (MinigameRole role : minigame.getRoles()) {
            if (role.id == id) return role;
        }
        return null;
    }
}
