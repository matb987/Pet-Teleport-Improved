package commands;

import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sittable;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class call_pet implements Listener{

	//if command is /callpet
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		if (e.getMessage().equalsIgnoreCase("/callpet")) {
			//get player
			Player p = e.getPlayer();
			//get all entities in the world
			List<Entity> entities = p.getWorld().getEntities();
			//loop through all entities and check if they are a pet
			for (Entity ent : entities) {
				if (ent.getType() == EntityType.WOLF || ent.getType() == EntityType.CAT
						|| ent.getType() == EntityType.PARROT) {
					// if pet is not sitting
					Sittable sit = (Sittable) ent;
					if (!sit.isSitting()) {
						// if pet is tamed
						Tameable tame = (Tameable) ent;
						if (tame.getOwner() instanceof Player) {
							// teleport pet to player
							ent.teleport(p.getLocation());
							// print message to player
							p.sendMessage("Your pet has been teleported to you");
							//set cancel event
							e.setCancelled(true);
							
						}
					}
				}

			}
			
			
			
		
		
		
	}
	}
}
