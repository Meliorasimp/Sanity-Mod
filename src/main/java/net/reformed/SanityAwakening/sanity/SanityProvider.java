package net.reformed.SanityAwakening.sanity;

import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.reformed.SanityAwakening.sanityawakening;
import org.jetbrains.annotations.Nullable;

public class SanityProvider implements ICapabilitySerializable<CompoundTag> {

    public static final ResourceLocation ID =
            ResourceLocation.fromNamespaceAndPath(sanityawakening.MOD_ID, "sanity");

    public static final Capability<ISanity> SANITY =
            CapabilityManager.get(new CapabilityToken<>() {});

    private final SanityData sanity = new SanityData();
    private final LazyOptional<ISanity> optional = LazyOptional.of(() -> sanity);

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        return cap == SANITY ? optional.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag tag = new CompoundTag();
        tag.putInt("sanity", sanity.getSanity());
        return tag;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag nbt) {
        sanity.setSanity(nbt.getInt("sanity"));
    }
}
