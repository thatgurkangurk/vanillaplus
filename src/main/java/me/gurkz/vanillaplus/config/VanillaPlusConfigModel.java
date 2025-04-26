package me.gurkz.vanillaplus.config;

import io.wispforest.owo.config.Option;
import io.wispforest.owo.config.annotation.*;

import java.util.List;

@Sync(Option.SyncMode.NONE)
@Modmenu(modId = "vanillaplus")
@Config(name = "vanillaplus", wrapperName = "VanillaPlusConfig")
public class VanillaPlusConfigModel {
    public boolean disableHeightmapSizeMismatchLog = true;
  
    @Nest
    @Expanded
    public SilenceMobs silenceMobs = new SilenceMobs();

    public static class SilenceMobs {
        @Expanded
        public List<String> validNames = List.of("silence me");
    }
}