package dev.diamond.smes.minigame.game;

import dev.diamond.smes.minigame.Minigame;
import dev.diamond.smes.minigame.MinigameRole;

import java.util.ArrayList;
import java.util.List;

public class TestMinigame extends Minigame {

    public float timer;

    @Override
    public void initialise() {
        timer = 0;
    }

    @Override
    public void deinitialise() {

    }

    @Override
    public void tick(float delta) {
        timer += delta / 100;

        System.out.println(timer);
    }

    @Override
    public List<MinigameRole> getRoles() {
        return new ArrayList<>();
    }
}
