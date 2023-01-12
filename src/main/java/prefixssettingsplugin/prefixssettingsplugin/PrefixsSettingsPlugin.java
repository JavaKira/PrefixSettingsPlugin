package prefixssettingsplugin.prefixssettingsplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class PrefixsSettingsPlugin extends JavaPlugin {

    private static PrefixsSettingsPlugin instance;

    public static PrefixsSettingsPlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);

        Objects.requireNonNull(getCommand("prefix")).setExecutor(new PrefixCommandExecutor());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
