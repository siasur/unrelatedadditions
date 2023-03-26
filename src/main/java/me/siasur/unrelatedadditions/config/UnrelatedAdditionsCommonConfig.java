package me.siasur.unrelatedadditions.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class UnrelatedAdditionsCommonConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    // Magnet Configuration
//    public static ForgeConfigSpec.BooleanValue FEATURE_MAGNET_ENABLED;
    public static ForgeConfigSpec.IntValue MAGNET_RANGE;

    // Hammer Configuration
//    public static ForgeConfigSpec.BooleanValue FEATURE_HAMMERS_ENABLED;

    // Spade Configuration
//    public static ForgeConfigSpec.BooleanValue FEATURE_SPADES_ENABLED;

    // Tiny Coal Configuration
//    public static ForgeConfigSpec.BooleanValue FEATURE_TINY_COAL_ENABLED;

    // Compressed Blocks Configuration
//    public static ForgeConfigSpec.BooleanValue FEATURE_COMPRESSED_BLOCKS_ENABLED;

    // Angel Block Configuration
//    public static ForgeConfigSpec.BooleanValue FEATURE_ANGEL_BLOCK_ENABLED;

    // Flag Configuration
//    public static ForgeConfigSpec.BooleanValue FEATURE_FLAGS_ENABLED;

    // Rope Ladder Configuration
//    public static ForgeConfigSpec.BooleanValue FEATURE_ROPE_LADDER_ENABLED;
    public static ForgeConfigSpec.IntValue ROPE_LADDER_LENGTH;

    // Liquid XP Configuration
//    public static ForgeConfigSpec.BooleanValue FEATURE_LIQUID_XP_ENABLED;
    public static ForgeConfigSpec.IntValue LIQUID_XP_CONVERSION_RATE;
    public static ForgeConfigSpec.IntValue LIQUID_XP_LIQUEFACTION_SPEED;
    public static ForgeConfigSpec.IntValue LIQUID_XP_SOLIDIFICATION_SPEED;

    // Drying Rack Configuration
//    public static ForgeConfigSpec.BooleanValue FEATURE_DRYING_RACK_ENABLED;

    static {
        BUILDER.comment("Unrelated Additions Common Configuration");

        BUILDER.push("Magnet");
        {
//            FEATURE_MAGNET_ENABLED = BUILDER.comment("Enable the Magnet feature").define("featureEnabled", true);
            MAGNET_RANGE = BUILDER.comment("The range of the Magnet").defineInRange("range", 5, 1, 16);
        }
        BUILDER.pop();

        BUILDER.push("Hammers");
        {
//            FEATURE_HAMMERS_ENABLED = BUILDER.comment("Enable the Hammers feature").define("featureEnabled", true);
        }
        BUILDER.pop();

        BUILDER.push("Spades");
        {
//            FEATURE_SPADES_ENABLED = BUILDER.comment("Enable the Spades feature").define("featureEnabled", true);
        }
        BUILDER.pop();

        BUILDER.push("Tiny Coal");
        {
//            FEATURE_TINY_COAL_ENABLED = BUILDER.comment("Enable the Tiny Coal feature").define("featureEnabled", true);
        }
        BUILDER.pop();

        BUILDER.push("Compressed Blocks");
        {
//            FEATURE_COMPRESSED_BLOCKS_ENABLED = BUILDER.comment("Enable the Compressed Blocks feature").define("featureEnabled", true);
        }
        BUILDER.pop();

        BUILDER.push("Angel Block");
        {
//            FEATURE_ANGEL_BLOCK_ENABLED = BUILDER.comment("Enable the Angel Block feature").define("featureEnabled", true);
        }
        BUILDER.pop();

        BUILDER.push("Flags");
        {
//            FEATURE_FLAGS_ENABLED = BUILDER.comment("Enable the Flags feature").define("featureEnabled", true);
        }
        BUILDER.pop();

        BUILDER.push("Rope Ladder");
        {
//            FEATURE_ROPE_LADDER_ENABLED = BUILDER.comment("Enable the Rope Ladder feature").define("featureEnabled", true);
            ROPE_LADDER_LENGTH = BUILDER.comment("The length of the Rope Ladder").defineInRange("length", 64, 4, 64);
        }
        BUILDER.pop();

        BUILDER.push("Liquid XP");
        {
//            FEATURE_LIQUID_XP_ENABLED = BUILDER.comment("Enable the Liquid XP feature").define("featureEnabled", true);
            LIQUID_XP_CONVERSION_RATE = BUILDER.comment("The conversion rate of Liquid XP (mb per xp point)").defineInRange("conversionRate", 16, 1, 1000);
            LIQUID_XP_LIQUEFACTION_SPEED = BUILDER.comment("The liquefaction speed of Liquid XP (xp points per tick)").defineInRange("liquefactionSpeed", 2, 1, 100);
            LIQUID_XP_SOLIDIFICATION_SPEED = BUILDER.comment("The solidification speed of Liquid XP (mb per tick)").defineInRange("solidificationSpeed", 10, 1, 1000);
        }
        BUILDER.pop();
        BUILDER.push("Drying Rack");
        {
//            FEATURE_DRYING_RACK_ENABLED = BUILDER.comment("Enable the Drying Rack feature").define("featureEnabled", true);
        }

        SPEC = BUILDER.build();
    }
}
