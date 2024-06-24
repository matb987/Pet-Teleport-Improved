package events;


import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sittable;
import org.bukkit.entity.Tameable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class chunk_unload implements Listener{
	//event to listen for chunk unload
	public class UnloadListener implements Listener {

		////REMAPPED THE WAY THE EVENT IS CALLED HENCE OLD FILENAME
		  @EventHandler
		  public void PlayerTeleportEvent(PlayerTeleportEvent event) {
		  //check if player is teleporting to same world
			if (event.getFrom().getWorld().equals(event.getTo().getWorld())) {
			
			// get all entities in the chunk
			Entity[] ents = event.getFrom().getChunk().getEntities();
		    for (int i = 0; i < ents.length; i++) {
		      Entity ent = ents[i];
		      if (ent.getType() == EntityType.WOLF || ent.getType() == EntityType.CAT || ent.getType() == EntityType.PARROT) {
		        Sittable sit = (Sittable)ent;
		        if (!sit.isSitting()) {
		          Tameable tame = (Tameable)ent;
		          if (tame.getOwner() instanceof Player) {
		            ent.teleport(event.getTo());
					
		          } 

		          
		          
		        } 
		      } 
		    } 
		  }
			
		  }
		//end of check world
	}

}
