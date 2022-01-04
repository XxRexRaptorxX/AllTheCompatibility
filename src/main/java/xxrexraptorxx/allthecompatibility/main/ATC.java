package xxrexraptorxx.allthecompatibility.main;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xxrexraptorxx.allthecompatibility.utils.Config;

/**
 * @author XxRexRaptorxX (RexRaptor)
 * @projectPage https://www.curseforge.com/minecraft/mc-mods/all-the-compatibility
 **/
@Mod(References.MODID)
public class ATC {

    public static final Logger LOGGER = LogManager.getLogger();

    public ATC() {
        Config.init();

        MinecraftForge.EVENT_BUS.register(this);
    }
}