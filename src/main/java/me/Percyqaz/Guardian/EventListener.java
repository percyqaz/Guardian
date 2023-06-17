package me.Percyqaz.Guardian;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityBreakDoorEvent;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventListener implements Listener
{
    Guardian plugin;
    FileConfiguration config;

    boolean allowCreeperBlockDamage;
    boolean allowGhastBlockDamage;
    boolean allowWitherBlockDamage;
    boolean allowWitherSkullBlockDamage;
    boolean allowTntBlockDamage;
    boolean allowMinecartTntBlockDamage;
    boolean allowEndCrystalBlockDamage;
    boolean allowEnderDragonBlockDamage;

    boolean allowEndermanBlockEdits;
    boolean allowVillagerBlockEdits;
    boolean allowSheepBlockEdits;
    boolean allowRavagerBlockEdits;
    boolean allowSilverfishBlockEdits;
    boolean allowBoatBlockEdits;
    boolean allowWitherBlockEdits;
    boolean allowSnowGolemBlockEdits;
    boolean allowRabbitBlockEdits;

    boolean allowZombieBreakDoors;
    boolean allowFarmlandTrampling;

    public EventListener(Guardian plugin, FileConfiguration config)
    {
        this.config = config;
        this.plugin = plugin;

        allowCreeperBlockDamage = config.getBoolean("allowCreeperBlockDamage", true);
        allowGhastBlockDamage = config.getBoolean("allowGhastBlockDamage", true);
        allowWitherBlockDamage = config.getBoolean("allowWitherBlockDamage", true);
        allowWitherSkullBlockDamage = config.getBoolean("allowWitherSkullBlockDamage", true);
        allowTntBlockDamage = config.getBoolean("allowTntBlockDamage", true);
        allowMinecartTntBlockDamage = config.getBoolean("allowMinecartTntBlockDamage", true);
        allowEndCrystalBlockDamage = config.getBoolean("allowEndCrystalBlockDamage", true);
        allowEnderDragonBlockDamage = config.getBoolean("allowEnderDragonBlockDamage", true);

        allowEndermanBlockEdits = config.getBoolean("allowEndermanBlockEdits", true);
        allowVillagerBlockEdits = config.getBoolean("allowVillagerBlockEdits", true);
        allowSheepBlockEdits = config.getBoolean("allowSheepBlockEdits", true);
        allowRavagerBlockEdits = config.getBoolean("allowRavagerBlockEdits", true);
        allowSilverfishBlockEdits = config.getBoolean("allowSilverfishBlockEdits", true);
        allowBoatBlockEdits = config.getBoolean("allowBoatBlockEdits", true);
        allowWitherBlockEdits = config.getBoolean("allowWitherBlockEdits", true);
        allowSnowGolemBlockEdits = config.getBoolean("allowSnowGolemBlockEdits", true);
        allowRabbitBlockEdits = config.getBoolean("allowRabbitBlockEdits", true);

        allowZombieBreakDoors = config.getBoolean("allowZombieBreakDoors", true);
        allowFarmlandTrampling = config.getBoolean("allowFarmlandTrampling", true);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void EntityExplode(EntityExplodeEvent e)
    {
        EntityType type = e.getEntity().getType();

        if (
                (type == EntityType.CREEPER && !allowCreeperBlockDamage)
                || (type == EntityType.FIREBALL && !allowGhastBlockDamage)
                || (type == EntityType.WITHER && !allowWitherBlockDamage)
                || (type == EntityType.WITHER_SKULL && !allowWitherSkullBlockDamage)
                || (type == EntityType.PRIMED_TNT && !allowTntBlockDamage)
                || (type == EntityType.MINECART_TNT && !allowMinecartTntBlockDamage)
                || (type == EntityType.ENDER_CRYSTAL && !allowEndCrystalBlockDamage)
                || (type == EntityType.ENDER_DRAGON && !allowEnderDragonBlockDamage)
            )
        {
            e.blockList().clear();
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void EntityBreakDoor(EntityBreakDoorEvent e)
    {
        if (!allowZombieBreakDoors)
        {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void EntityChangeBlock(EntityChangeBlockEvent e)
    {
        EntityType type = e.getEntity().getType();

        if (
                (type == EntityType.ENDERMAN && !allowEndermanBlockEdits)
                || (type == EntityType.VILLAGER && !allowVillagerBlockEdits)
                || (type == EntityType.SHEEP && !allowSheepBlockEdits)
                || (type == EntityType.RAVAGER && !allowRavagerBlockEdits)
                || (type == EntityType.SILVERFISH && !allowSilverfishBlockEdits)
                || (type == EntityType.BOAT && !allowBoatBlockEdits)
                || (type == EntityType.WITHER && !allowWitherBlockEdits)
                || (type == EntityType.SNOWMAN && !allowSnowGolemBlockEdits)
                || (type == EntityType.RABBIT && !allowRabbitBlockEdits)
            )
        {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void EntityTrampleFarmland(EntityInteractEvent e)
    {
        Block block = e.getBlock();
        if (!allowFarmlandTrampling && block.getType() == Material.FARMLAND)
        {
            e.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void PlayerTrampleFarmland(PlayerInteractEvent e)
    {
        Block block = e.getClickedBlock();
        if (e.getAction() == Action.PHYSICAL && !allowFarmlandTrampling && block.getType() == Material.FARMLAND)
        {
            e.setCancelled(true);
        }
    }

}
