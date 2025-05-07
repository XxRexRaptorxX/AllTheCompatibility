package xxrexraptorxx.allthecompatibility.utils;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {

    public static final String CATEGORY_GENERAL = "general";
    public static final String CATEGORY_CONTENT = "content";

    public static ModConfigSpec CLIENT_CONFIG;
    public static ModConfigSpec SERVER_CONFIG;

    public static ModConfigSpec.BooleanValue UPDATE_CHECKER;
    public static ModConfigSpec.BooleanValue PATREON_REWARDS;
    public static ModConfigSpec.BooleanValue MEKANISM_COMPATIBILTY_ITEMS;

    private static boolean mekanismCompatEnabled = true;

    public static boolean isMekanismCompatEnabled() {
        return mekanismCompatEnabled;
    }

    public static void init(ModContainer container) {
        initServer();
        initClient();

        container.registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
        container.registerConfig(ModConfig.Type.CLIENT, CLIENT_CONFIG);
    }


    public static void initClient() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        UPDATE_CHECKER = builder.comment("Activate the Update-Checker").define("update-checker", true);
        builder.pop();

        CLIENT_CONFIG = builder.build();
    }


    public static void initServer() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();

        builder.comment("General").push(CATEGORY_GENERAL);
        PATREON_REWARDS = builder.comment("Enables ingame rewards on first spawn for Patreons").define("patreon_rewards", true);
        builder.pop();

        builder.comment("Content").push(CATEGORY_CONTENT);
        MEKANISM_COMPATIBILTY_ITEMS = builder.comment("AllTheOres only generates shards, clumps & dirty dusts if Mekanism is installed, this makes many ATC recipes invalid, so ATC lets them generate even if Mekanism is not installed").define("mekanism_compatibility_items", true);
        builder.pop();

        SERVER_CONFIG = builder.build();
    }


    @SubscribeEvent
    public static void onConfigLoading(final ModConfigEvent.Loading event) {
        if (event.getConfig().getSpec() == SERVER_CONFIG) {
            mekanismCompatEnabled = MEKANISM_COMPATIBILTY_ITEMS.get();
        }
    }
}