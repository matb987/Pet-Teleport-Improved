import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import Bukkit.Metrics;
import commands.call_pet;
import commands.reload;
import events.chunk_unload;
import events.tp_world_changed;

public class main extends JavaPlugin {
	@Override
	public void onEnable() {
		
		int pluginId = 22331; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);
        
		//define config file
		FileConfiguration config = this.getConfig();
		//add settings to config file
		config.addDefault("teleport-same-world", true);
    	config.addDefault("teleport-different-world", true);
    	config.addDefault("callpet", true);
    	config.options().copyDefaults(true);
    	saveConfig();
		
		//if teleport-same-world is enabled
		if (this.getConfig().getBoolean("teleport-same-world")) {
			// register event listener
			getServer().getPluginManager().registerEvents(new chunk_unload(), this);
			// print message to console
			getServer().getLogger().info("Teleporting pets to owner when chunk unloads");
		}
		//if teleport-different-world is enabled
		if (this.getConfig().getBoolean("teleport-different-world")) {
			// register event listener
			getServer().getPluginManager().registerEvents(new tp_world_changed(), this);
		}
		//if callpet is enabled
		if (this.getConfig().getBoolean("callpet")) {
			// register event listener
			getServer().getPluginManager().registerEvents(new call_pet(), this);
		}

	}
	
	
	
	@Override
	public void onDisable() {
	}

}
