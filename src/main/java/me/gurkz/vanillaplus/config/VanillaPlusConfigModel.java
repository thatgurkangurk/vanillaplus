package me.gurkz.vanillaplus.config;

import io.wispforest.owo.config.Option;
import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;
import io.wispforest.owo.config.annotation.Sync;

@Sync(Option.SyncMode.NONE)
@Modmenu(modId = "vanillaplus")
@Config(name = "vanillaplus", wrapperName = "VanillaPlusConfig")
public class VanillaPlusConfigModel {
    public boolean disableHeightmapSizeMismatchLog = true;
}
