package dev.diamond.smes.minigame;

import net.minecraft.server.network.ServerPlayerEntity;

import java.util.HashMap;


public class MinigameManager {
    public static final MinigameManager INSTANCE = new MinigameManager();

    private Minigame loaded;
    private boolean gameRunning;
    private HashMap<ServerPlayerEntity, MinigameRole> playerRoles;

    private MinigameManager() {
        this.loaded = null;
        this.gameRunning = false;
        this.playerRoles = new HashMap<>();
    }
    public static MinigameManager getInstance() { return INSTANCE; }


    // Minigame Management
    public Minigame getLoaded() {
        return loaded;
    }
    public boolean hasLoaded() { return loaded != null; }
    public void load(Minigame minigame) {
        loaded = minigame;
    }

    // Running
    public void start() {
        if (hasLoaded() && !isRunning()) {
            if (getLoaded().canStart()) {
                getLoaded().initialise();
                gameRunning = true;
            }
        }
    }
    public void stop() {
        if (hasLoaded() && isRunning()) {
            getLoaded().deinitialise();
            gameRunning = false;
        }
    }

    public void tick(float tickDelta) {
        if (isRunning()) getLoaded().tick(tickDelta);
    }

    public boolean isRunning() {
        return gameRunning;
    }


    // Roles
    public HashMap<ServerPlayerEntity, MinigameRole> getPlayerRoleHash() {
        return playerRoles;
    }

}
