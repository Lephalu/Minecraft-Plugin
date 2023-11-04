package awesome.de.de.awesome.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CommandHead implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        ItemStack item = player.getInventory().getItemInMainHand();

        if(item.getType() == Material.AIR) {
            player.sendMessage("§cYou can't draw air!");
            return true;
        }

        if(player.getInventory().getHelmet() != null) {
            player.sendMessage("§cYour helmet slot must be empty!");
            return true;
        }

        player.getInventory().setHelmet(item);
        item.setAmount(0);
        return false;
    }

    }

