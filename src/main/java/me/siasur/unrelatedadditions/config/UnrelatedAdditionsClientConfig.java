package me.siasur.unrelatedadditions.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class UnrelatedAdditionsClientConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.comment("Client configuration settings").push("client");
        BUILDER.pop();
        SPEC = BUILDER.build();
    }

}
