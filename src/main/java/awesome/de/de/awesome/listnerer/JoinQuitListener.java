package awesome.de.de.awesome.listnerer;

import com.destroystokyo.paper.Title;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener implements Listener {


    @EventHandler
    public void oneJoin(PlayerJoinEvent event) {

        event.setJoinMessage(ChatColor.GREEN + event.getPlayer().getName() + " has appeared on the class server! ");
        event.getPlayer().sendTitle("§6[§4a§7v§6a§1j§6]", event.getPlayer().getName(), 20, 100, 20);
        event.getPlayer().sendMessage(event.getPlayer().getPlayerTime() + " = this is your Play Time on this Server.");
        event.getPlayer().sendMessage(event.getPlayer().getPing() + " = this is your ping to this Server.");
        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_AXOLOTL_ATTACK, 100, 1000);

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

        event.setQuitMessage(ChatColor.AQUA + event.getPlayer().getName() +  " has disappeared from the server! ");

    }

@EventHandler
    public void onMove(PlayerMoveEvent event){

        Player player = event.getPlayer();

        if(player.getInventory().contains(Material.COMMAND_BLOCK)){

            player.getLocation().getBlock().getRelative(0,-1,1);


        }


    }



}




