package net.reformed.SanityAwakening.mixin;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.reformed.SanityAwakening.sanity.SanityData;

@Mixin(Player.class)
public class PlayerSynchedDataMixin {
    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    private void sanityawakening$defineSanity(SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(net.reformed.SanityAwakening.sanity.SanitySyncedData.SANITY, 100);
    }
}
