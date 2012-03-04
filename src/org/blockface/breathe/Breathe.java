package org.blockface.breathe;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;

public class Breathe extends JavaPlugin implements Listener{
    public void onDisable() {
        System.out.println(this + " is now disabled!");
    }

    public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
        System.out.println(this + " is now enabled!");
    }

	@EventHandler
    public void onEntityDamage(EntityDamageEvent event)
    {
        if(!(event.getEntity() instanceof Player)) return;
        Player player = (Player)event.getEntity();
        if(!player.hasPermission("breathe.use")) return;
        if(event.getCause() == EntityDamageEvent.DamageCause.DROWNING) event.setCancelled(true);

    }
}
