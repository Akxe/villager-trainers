# Villager Trainers

[![Build Status](https://github.com/Akxe/villager-trainers/actions/workflows/build.yml/badge.svg)](https://github.com/Akxe/villager-trainers/actions/workflows/build.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Minecraft Version](https://img.shields.io/badge/Minecraft-1.21.1-green.svg)](https://minecraft.net)

Villager are now also trainers with their team and level being dependant on their current traiding level mergin the world of Cobblemon and Minecraft together. Villagers will have different type of Pokémon based on the village origin, giving player insensitive to create Jungle and Swamp villages!

> Work in progress: early groundwork; battle mechanics & content will expand. Behavior specification here is authoritative for upcoming implementation.

## Planned Core Features

- Villagers will fight using classic Cobblemon mechanic
- Villagers have predetermined teams right when they spawn, adjusting their team size and level to their current trading level
- Villagers use the max evolution they can when the level pf the pokemon allows for it
- Pokemon types are determined by the village origin (Desert, Jungle, Plains, Savanna, Snow, Swamp, Taiga)
- Villagers will try to go to battle arenas (often player made), while other villagers will go watch the fight.
- Master level villagers will be able to use items. They will have items based on a budget system
- Wining battles with villagers will provide player with a reward
- Conquering a mater villager for the first time grants reputation bonus to the player, lowering his prices in the entire village
- Fleeing from villager fight will lower player's reputation
- Fabric & NeoForge support
- A lot of config options, to tune the mod
- Wandering villagers will be fight-able too; his Pokémon will be rarer and might have shiny too. More to be planed with them

Details for each point: [MECHANICS.md](MECHANICS.md).


## Village Type Pools (Reference)

| Type    | Desert | Jungle | Plains | Savanna | Snow | Swamp | Taiga |
|---------|:------:|:------:|:------:|:-------:|:----:|:-----:|:-----:|
| Normal  | ❌ | ❌ | ✅ | ❌ | ❌ | ❌ | ❌ |
| Fire    | ❌ | ❌ | ❌ | ❌ | ❌ | ❌ | ✅ |
| Water   | ❌ | ❌ | ❌ | ❌ | ❌ | ✅ | ❌ |
| Grass   | ❌ | ✅ | ❌ | ❌ | ❌ | ❌ | ❌ |
| Electric| ❌ | ❌ | ✅ | ❌ | ❌ | ❌ | ❌ |
| Ice     | ❌ | ❌ | ❌ | ❌ | ✅ | ❌ | ❌ |
| Fight   | ❌ | ❌ | ❌ | ✅ | ❌ | ❌ | ❌ |
| Poison  | ❌ | ✅ | ❌ | ❌ | ❌ | ❌ | ❌ |
| Ground  | ✅ | ❌ | ❌ | ❌ | ❌ | ❌ | ❌ |
| Flying  | ❌ | ❌ | ❌ | ✅ | ❌ | ❌ | ❌ |
| Psychic | ✅ | ❌ | ❌ | ❌ | ❌ | ❌ | ❌ |
| Bug     | ❌ | ✅ | ❌ | ❌ | ❌ | ❌ | ❌ |
| Rock    | ❌ | ❌ | ❌ | ❌ | ❌ | ❌ | ✅ |
| Ghost   | ❌ | ❌ | ❌ | ❌ | ❌ | ✅ | ❌ |
| Dragon  | ❌ | ❌ | ❌ | ❌ | ✅ | ❌ | ✅ |
| Dark    | ❌ | ❌ | ❌ | ❌ | ✅ | ❌ | ❌ |
| Steel   | ❌ | ❌ | ❌ | ❌ | ✅ | ❌ | ❌ |
| Fiery   | ❌ | ❌ | ✅ | ❌ | ❌ | ❌ | ❌ |

## Installation (Early Stage)

1. Download the latest development build from GitHub Actions (when available)
2. Drop the universal jar into your `mods` folder
3. Launch the game (Fabric or NeoForge)
4. Future versions will auto-generate trainers in villages

## Building from Source

Requirements:
- Java 21 or newer
- Git

```bash
git clone https://github.com/Akxe/villager-trainers.git
cd villager-trainers
./gradlew build
```

The built files will be available in:
- `fabric/build/libs/` - Fabric version
- `neoforge/build/libs/` - NeoForge version

## Bug Reports

Found an issue or want to suggest mechanics? Open an issue on [GitHub](https://github.com/Akxe/villager-trainers/issues).

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
