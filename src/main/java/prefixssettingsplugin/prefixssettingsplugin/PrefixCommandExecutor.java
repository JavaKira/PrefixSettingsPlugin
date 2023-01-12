package prefixssettingsplugin.prefixssettingsplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.metadata.FixedMetadataValue;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PrefixCommandExecutor implements org.bukkit.command.CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length != 2) return false;

        executePrefix(sender, args[0], args[1]);
        return true;
    }

    public void executePrefix(CommandSender sender, String name, String prefix) {
        Objects.requireNonNull(Bukkit.getPlayer(name))
                .setMetadata("prefix", new FixedMetadataValue(PrefixsSettingsPlugin.getInstance(), prefix));
        sender.sendMessage("successful set prefix " + prefix + " to player " + name);
    }
}
