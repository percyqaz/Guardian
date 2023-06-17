package me.Percyqaz.Guardian;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Guardian extends JavaPlugin
{
    @Override
    public void onEnable() {
        FileConfiguration config = getConfig();

        config.addDefault("allowCreeperBlockDamage", true);
        config.addDefault("allowGhastBlockDamage", true);
        config.addDefault("allowWitherBlockDamage", true);
        config.addDefault("allowWitherSkullBlockDamage", true);
        config.addDefault("allowTntBlockDamage", true);
        config.addDefault("allowMinecartTntBlockDamage", true);
        config.addDefault("allowEndCrystalBlockDamage", true);
        config.addDefault("allowEnderDragonBlockDamage", true);

        config.addDefault("allowEndermanBlockEdits", true);
        config.addDefault("allowVillagerBlockEdits", true);
        config.addDefault("allowSheepBlockEdits", true);
        config.addDefault("allowRavagerBlockEdits", true);
        config.addDefault("allowSilverfishBlockEdits", true);
        config.addDefault("allowBoatBlockEdits", true);
        config.addDefault("allowWitherBlockEdits", true);
        config.addDefault("allowSnowGolemBlockEdits", true);
        config.addDefault("allowRabbitBlockEdits", true);

        config.addDefault("allowZombieBreakDoors", true);
        config.addDefault("allowFarmlandTrampling", true);

        config.options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new EventListener(this, config), this);
    }
}