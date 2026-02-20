package net.reformed.SanityAwakening.sanity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.player.Player;

public class SanityData implements ISanity {
    private int sanity = 100;
    private final int maxSanity = 100;

    @Override
    public int get() {
        return sanity;
    }

    @Override
    public int getSanity() {
        return sanity;
    }

    @Override
    public void setSanity(int value) {
        sanity = clamp(value, 0, maxSanity);
    }

    @Override
    public void addSanity(int value) {
        setSanity(sanity + value);
    }

    @Override
    public void removeSanity(int amount) {
        setSanity(sanity - amount);
    }

    @Override
    public int getMaxSanity() {
        return maxSanity;
    }

    private static int clamp(int v, int min, int max) {
        return Math.max(min, Math.min(max, v));
    }
}