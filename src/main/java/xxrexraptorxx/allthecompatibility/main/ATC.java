package xxrexraptorxx.allthecompatibility.main;

import net.allthemods.alltheores.content.blocks.sets.ato_sets.ATOIngotSet;
import net.allthemods.alltheores.content.items.mekanism.Clump;
import net.allthemods.alltheores.content.items.mekanism.Crystal;
import net.allthemods.alltheores.content.items.mekanism.DirtyDust;
import net.allthemods.alltheores.content.items.mekanism.Shard;
import net.allthemods.alltheores.registry.ATORegistry;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.allthecompatibility.utils.Config;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage <a href="https://www.curseforge.com/minecraft/mc-mods/all-the-compatibility">...</a>
 **/
@Mod(References.MODID)
public class ATC {

    public static final Logger LOGGER = LogManager.getLogger();

    public ATC(IEventBus bus, ModContainer container) {
        Config.init(container);

        bus.addListener(ATC::onItemRegister);
    }



    /**
     * Registers the missing ATO compatibility items if Mekanism is not loaded
     */
    @SubscribeEvent
    public static void onItemRegister(final NewRegistryEvent event) {
        if (ModList.get().isLoaded("mekanism") || !Config.isMekanismCompatEnabled()) return;

        for (ATOIngotSet set : ATOIngotSet.getIngotSets()) {
            String name = set.name;

            ATORegistry.ITEMS.register(name + "_crystal", () -> new Crystal(new Item.Properties()));
            ATORegistry.ITEMS.register(name + "_shard",   () -> new Shard(new Item.Properties()));
            ATORegistry.ITEMS.register(name + "_clump",   () -> new Clump(new Item.Properties()));
            ATORegistry.ITEMS.register("dirty_" + name + "_dust", () -> new DirtyDust(new Item.Properties()));
        }
    }
}