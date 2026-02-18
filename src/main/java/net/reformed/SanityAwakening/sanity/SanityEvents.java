package net.reformed.SanityAwakening.sanity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.reformed.SanityAwakening.sanityawakening;

@Mod.EventBusSubscriber(modid = sanityawakening.MOD_ID)
public class SanityEvents {

    @SubscribeEvent
    public static void attachCapabilities(AttachCapabilitiesEvent<?> event) {
        if(event.getObject() instanceof Player) {
            event.addCapability(SanityProvider.ID, new SanityProvider());
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        event.getOriginal().getCapability(SanityProvider.SANITY).ifPresent(oldStore -> {
            event.getEntity().getCapability(SanityProvider.SANITY).ifPresent(newStore -> {
                newStore.setSanity(oldStore.getSanity());
            });
        });
    }
}
