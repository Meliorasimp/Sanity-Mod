package net.reformed.Qbit.item;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.reformed.Qbit.qbit;

public class ModItems {
    public static final DeferredRegister<Item> items =
            DeferredRegister.create(ForgeRegistries.ITEMS, qbit.MOD_ID);

    public static final RegistryObject<Item> ULTRABRIGHT_TORCH = items.register("ultrabright_torch",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_SHARD = items.register("crystal_shard",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        items.register(eventBus);
    }
}
