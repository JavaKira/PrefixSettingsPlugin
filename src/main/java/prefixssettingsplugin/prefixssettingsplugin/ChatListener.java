package prefixssettingsplugin.prefixssettingsplugin;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Objects;


public class ChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncChatEvent event) {
        event.renderer((source, sourceDisplayName, message, viewer) -> {
            TextComponent.Builder builder = Component.text();

            if (!source.hasMetadata("prefix"))
                builder.append(Component.text(Objects.requireNonNull(source.getMetadata("prefix").get(0).value()).toString()));

            return builder
                    .append(Component.text(" "))
                    .append(sourceDisplayName.color(TextColor.fromHexString("#a8a432")))
                    .append(Component.text(" : "))
                    .append(message)
                    .build();
        });
    }
}
