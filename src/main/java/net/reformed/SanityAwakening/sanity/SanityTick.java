package net.reformed.SanityAwakening.sanity;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.reformed.SanityAwakening.sanityawakening;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;


@Mod.EventBusSubscriber(modid = sanityawakening.MOD_ID)
public class SanityTick {

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent event) {
        if(event.phase != TickEvent.Phase.END) return;
        Player player = event.player;

        if(player.level().isClientSide) return;

        //every 2 seconds
        if(player.tickCount % 40 != 0) return;

        int light = player.level().getMaxLocalRawBrightness(player.blockPosition());

        player.getCapability(SanityProvider.SANITY).ifPresent(sanity -> {
            if(light <= 4) sanity.removeSanity(1);
            else sanity.addSanity(1);
        });
    }
}
