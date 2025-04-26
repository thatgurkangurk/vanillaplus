package me.gurkz.vanillaplus.config;

import blue.endless.jankson.Jankson;
import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.util.Observable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class VanillaPlusConfig extends ConfigWrapper<me.gurkz.vanillaplus.config.VanillaPlusConfigModel> {

    public final Keys keys = new Keys();

    private final Option<java.lang.Boolean> disableHeightmapSizeMismatchLog = this.optionForKey(this.keys.disableHeightmapSizeMismatchLog);

    private VanillaPlusConfig() {
        super(me.gurkz.vanillaplus.config.VanillaPlusConfigModel.class);
    }

    private VanillaPlusConfig(Consumer<Jankson.Builder> janksonBuilder) {
        super(me.gurkz.vanillaplus.config.VanillaPlusConfigModel.class, janksonBuilder);
    }

    public static VanillaPlusConfig createAndLoad() {
        var wrapper = new VanillaPlusConfig();
        wrapper.load();
        return wrapper;
    }

    public static VanillaPlusConfig createAndLoad(Consumer<Jankson.Builder> janksonBuilder) {
        var wrapper = new VanillaPlusConfig(janksonBuilder);
        wrapper.load();
        return wrapper;
    }

    public boolean disableHeightmapSizeMismatchLog() {
        return disableHeightmapSizeMismatchLog.value();
    }

    public void disableHeightmapSizeMismatchLog(boolean value) {
        disableHeightmapSizeMismatchLog.set(value);
    }


    public static class Keys {
        public final Option.Key disableHeightmapSizeMismatchLog = new Option.Key("disableHeightmapSizeMismatchLog");
    }
}

