# Guardian

Minecraft/Spigot plugin to toggle various individual protections, much more fine-grained than /gamerule mobGriefing

Here is the full list of config options and what setting them to `false` does:

- `allowCreeperBlockDamage` - When false, Creeper explosions do not destroy blocks. Explosion still deals damage
- `allowGhastBlockDamage` - Same as Creeper explosions but for Ghast fireballs
- `allowWitherBlockDamage` - Same as Creeper explosions but for Wither initial explosion when it spawns in
- `allowWitherSkullBlockDamage` - Same as Creeper explosions but for Wither blue skull projectiles
- `allowTntBlockDamage` - Same as Creeper explosions but for lit TNT
- `allowMinecartTntBlockDamage` - Same as Creeper explosions but for TNT minecarts
- `allowEndCrystalBlockDamage` - Same as Creeper explosions but for End crystals
- `allowEnderDragonBlockDamage` - When false, the Ender Dragon does not destroy blocks it flies through
- `allowEndermanBlockEdits` - When false, Enderman cannot pick up or place blocks
- `allowVillagerBlockEdits` - When false, Villagers cannot break or plant crops. They can still pick up items and food you drop
- `allowSheepBlockEdits` - When false, Sheep do not turn grass into dirt when they eat it. They still regrow their wool
- `allowRavagerBlockEdits` - When false, Ravagers do not destroy leaves or crops
- `allowSilverfishBlockEdits` - When false, Silverfish do not summon additional silverfish from nearby blocks, nor do they hide in blocks. They still spawn if a player mines an infested block 
- `allowBoatBlockEdits` - When false, Boats do not break lily pads when riding into them. The boat will be obstructed instead
- `allowWitherBlockEdits` - When false, Withers cannot mine blocks around them when obstructed
- `allowSnowGolemBlockEdits` - When false, Snow Golems do not place snow at their feet
- `allowRabbitBlockEdits` - When false, Rabbits cannot eat carrot crops
- `allowZombieBreakDoors` - When false, Zombies (or Zombified Piglins) cannot break doors 
- `allowFarmlandTrampling` - When false, no entities can trample farmland, including players

### ⚠️ ALL of these settings are true by default, which means by default when you install this plugin nothing about your game has changed.
To change these settings, edit `config.yml` in the Guardian folder found in your Plugins folder

It will only exist after the server has been started once.

To apply changes to these settings, save the file and then restart your server.
