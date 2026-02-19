package net.reformed.SanityAwakening.sanity;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.reformed.SanityAwakening.sanityawakening;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;

@Mod.EventBusSubscriber(modid = sanityawakening.MOD_ID)
public class SanityDebugTick {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            Player player = event.player;
        }
    }
}
