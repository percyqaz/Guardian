package me.Percyqaz.Guardian;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.entity.*;
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

    boolean allowBedExplosionBlockDamage;
    boolean allowRespawnAnchorExplosionBlockDamage;

    Location lastInteractedBed;
    Location lastInteractedRespawnAnchor;

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

        allowBedExplosionBlockDamage = config.getBoolean("allowBedExplosionBlockDamage", true);
        allowRespawnAnchorExplosionBlockDamage = config.getBoolean("allowRespawnAnchorExplosionBlockDamage", true);
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
    public void PlayerInteract(PlayerInteractEvent e)
    {
        Block block = e.getClickedBlock();
        Action action = e.getAction();
        if (action == Action.PHYSICAL && !allowFarmlandTrampling && block.getType() == Material.FARMLAND)
        {
            e.setCancelled(true);
        }
        else if (action == Action.RIGHT_CLICK_BLOCK)
        {
            switch (block.getType())
            {
                case WHITE_BED:
                case ORANGE_BED:
                case MAGENTA_BED:
                case LIGHT_BLUE_BED:
                case YELLOW_BED:
                case LIME_BED:
                case PINK_BED:
                case GRAY_BED:
                case LIGHT_GRAY_BED:
                case CYAN_BED:
                case PURPLE_BED:
                case BLUE_BED:
                case BROWN_BED:
                case GREEN_BED:
                case RED_BED:
                case BLACK_BED:
                    if (!allowBedExplosionBlockDamage)
                    {
                        lastInteractedBed = block.getLocation();
                    }
                    break;
                case RESPAWN_ANCHOR:
                    if (!allowRespawnAnchorExplosionBlockDamage)
                    {
                       lastInteractedRespawnAnchor = block.getLocation();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    boolean IsLocationPartOfBed(Location location)
    {
        if (location == null || lastInteractedBed == null)
        {
            return false;
        }

        int distance = Math.abs(location.getBlockX() - lastInteractedBed.getBlockX()) + Math.abs(location.getBlockZ() - lastInteractedBed.getBlockZ());
        return distance <= 1 && (location.getBlockY() == lastInteractedBed.getBlockY()) && (location.getWorld().equals(location.getWorld()));
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void BlockExplode(BlockExplodeEvent e)
    {
        // when right clicking on a bed or respawn anchor, it will break the block(s) and then trigger the explosion event
        // therefore e.getBlock().getMaterial() will return AIR at the time of writing this plugin
        // we store the location when interacting with a bed/respawn anchor and see if it's the same place

        // please also laugh at timtower's awful handling of a thread discussing this issue on bukkit forums https://bukkit.org/threads/blockexplodeevent.475806/
        // truly a discredit to the community

        Location explodingBlockLocation = e.getBlock().getLocation();
        if (!allowBedExplosionBlockDamage && IsLocationPartOfBed(explodingBlockLocation))
        {
            e.blockList().clear();
            lastInteractedBed = null;
        }
        if (!allowRespawnAnchorExplosionBlockDamage && explodingBlockLocation.equals(lastInteractedRespawnAnchor))
        {
            e.blockList().clear();
            lastInteractedRespawnAnchor = null;
        }
    }
}
