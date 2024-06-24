package commands;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

public class reload implements Listener {
	//reload plugin command
	public void onCommand(PlayerCommandPreprocessEvent e) {
		//if command is /pti reload
		if (Bukkit.getServer().getPluginCommand("reloadpti").getName().equalsIgnoreCase("reloadpti")) {
			// reload plugin
		
		Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("PetTeleport_Improved");
	    plugin.getPluginLoader().disablePlugin(plugin);
	    plugin.getPluginLoader().enablePlugin(plugin);
	    //get message to console
	    Bukkit.getServer().getLogger().info("PetTweleport_Improved has been reloaded");
	    e.getPlayer().sendMessage("PetTeleport_Improved has been reloaded");
	    e.setCancelled(true);
	   
		}
	}
}
