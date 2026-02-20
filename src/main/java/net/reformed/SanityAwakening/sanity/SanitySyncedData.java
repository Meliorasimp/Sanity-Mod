package net.reformed.SanityAwakening.sanity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.player.Player;

public class SanitySyncedData {

    public static final EntityDataAccessor<Integer> SANITY =
            SynchedEntityData.defineId(Player.class, EntityDataSerializers.INT);

    public static int get(Player player) {
        return player.getEntityData().get(SANITY);
    }

    public static void set(Player player, int value) {
        player.getEntityData().set(SANITY, value);
    }
}