package awesome.de.de.awesome;

import awesome.de.de.awesome.commands.CommandHead;
import awesome.de.de.awesome.commands.Commands;
import awesome.de.de.awesome.commands.HealCommand;
import awesome.de.de.awesome.listnerer.JoinQuitListener;
import awesome.de.de.awesome.listnerer.NoDamage;
import awesome.de.de.awesome.listnerer.ProtectWorld;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        Bukkit.getPluginManager().registerEvents(new JoinQuitListener(), this);
        Bukkit.getPluginManager().registerEvents(new Commands(), this);
        Bukkit.getPluginCommand("sit").setExecutor(new Commands());
        Bukkit.getPluginCommand("head").setExecutor(new CommandHead() );
        Bukkit.getPluginCommand("heal").setExecutor(new HealCommand());
        Bukkit.getPluginManager().registerEvents(new NoDamage(), this);
        Bukkit.getPluginManager().registerEvents(new ProtectWorld(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }


}
