package xxrexraptorxx.allthecompatibility.main;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
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

    public ATC(ModContainer container) {
        Config.init(container);


        //TODO Console filter
        //LoggerContext context = (LoggerContext) LogManager.getContext(false);
        //Configuration config = context.getConfiguration();
        //
        //// creating regex filter
        //RegexFilter filter = null;
        //try {
        //    String regex = ".*Unknown registry key in ResourceKey\\[minecraft:root / minecraft:recipe_serializer\\]:.*";
        //    filter = RegexFilter.createFilter(regex, null, true, Filter.Result.DENY, Filter.Result.ACCEPT);
        //} catch (IllegalAccessException e) {
        //    throw new RuntimeException(e);
        //}
        //
        //// attach filter to regex
        //LoggerConfig loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
        //loggerConfig.addFilter(filter);
        //
        //context.updateLoggers(config);
    }
}