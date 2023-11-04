package awesome.de.de.awesome.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

import java.util.HashMap;

public class Commands implements CommandExecutor, Listener {
    private static HashMap<Player, Boolean> sit = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        if (sit.containsKey(player)) {
            player.sendMessage("§cYou are already seated!");
            return true;
        }

        ArmorStand as = (ArmorStand) player.getWorld().spawnEntity(player.getLocation().add(0, -0.9, 0), EntityType.ARMOR_STAND);
        as.setInvulnerable(true);
        as.setInvisible(true);
        as.setGravity(false);
        as.setVisible(false);
        as.setSmall(true);
        as.addPassenger(player);
        sit.put(player,true);
        return false;
    }

    @EventHandler
    public void onDismount(EntityDismountEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getDismounted() instanceof ArmorStand) {
                ArmorStand as = (ArmorStand) event.getDismounted();
                as.setHealth(0);
                sit.remove(player);
            }
        }
    }
}
