package net.reformed.SanityAwakening.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.DeltaTracker;

import net.reformed.SanityAwakening.sanity.SanityData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Gui.class)
public class GuiMixin {

    @Inject(method = "render", at = @At("TAIL"))
    private void sanityawakening$renderSanity(GuiGraphics gg, DeltaTracker delta, CallbackInfo ci) {

        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.options.hideGui) return;

        int sanity = net.reformed.SanityAwakening.sanity.SanitySyncedData.get(mc.player);
        int maxSanity = 100;

        int screenW = mc.getWindow().getGuiScaledWidth();
        int screenH = mc.getWindow().getGuiScaledHeight();

        int x = 10;
        int y = screenH - 40;
        int barW = 90;
        int barH = 10;

        // Background
        gg.fill(x, y, x + barW, y + barH, 0xAA000000);

        // Fill
        int filled = (int)((sanity / (float)maxSanity) * barW);
        gg.fill(x, y, x + filled, y + barH, 0xAA8A2BE2);

        // Text
        gg.drawString(mc.font, "Sanity: " + sanity, x, y - 10, 0xFFFFFF, true);
    }
}