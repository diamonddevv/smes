package dev.diamond.smes.minigame;

import dev.diamond.smes.registry.InitRegistries;
import net.minecraft.util.Identifier;

import java.util.List;

public abstract class Minigame {
    public Minigame() {

    }

    public abstract void initialise();
    public abstract void deinitialise();

    public abstract void tick(float delta);

    public abstract List<MinigameRole> getRoles();


    public boolean canStart() {
        return true;
    }

    public String getTranslationKey() {
        Identifier id = InitRegistries.MINIGAMES.getId(this);
        return "smes.game." + id.getNamespace() + "." + id.getPath();
    }
}
