package net.reformed.Qbit.block;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.reformed.Qbit.qbit;

public class ModBlocks {
    public static final DeferredRegister<Block> blocks =
            DeferredRegister.create(ForgeRegistries.BLOCKS, qbit.MOD_ID);

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {

    }


    public static void Register(IEventBus eventBus)
    {
        blocks.register(eventBus);
    }
}
