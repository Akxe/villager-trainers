# Villager Trainers

[![Build Status](https://github.com/Akxe/villager-trainers/actions/workflows/build.yml/badge.svg)](https://github.com/Akxe/villager-trainers/actions/workflows/build.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Minecraft Version](https://img.shields.io/badge/Minecraft-1.21.1-green.svg)](https://minecraft.net)

Adds Pokémon-style trainer battles featuring villagers who become dedicated battle trainers. Challenge thematic villager trainers, assemble a team, and engage in turn-based strategic encounters.

> Work in progress: current version lays groundwork and project scaffolding.

## ✨ Planned Core Features

- 🧑‍🏫 Villager Trainers with roles (Farmer, Librarian, Blacksmith archetypes) each using themed battle teams
- ⚔️ Turn-based battle system (speed priority, status, type-like interactions)
- 🧠 Simple AI that chooses context-aware moves
- � Progression & rewards (emeralds, items, reputation)
- 🌐 Fabric & NeoForge support from one universal jar
- � Config toggles for spawn rates & difficulty

## 🎯 Supported Versions

- **Minecraft:** 1.21.1 and above (until the bug is officially fixed)
- **Fabric:** Requires Fabric Loader 0.17.0+
- **NeoForge:** Requires NeoForge 21.1.187+
- **Java:** Requires Java 21 or newer

## 📦 Installation (Early Stage)

1. Download the latest development build from GitHub Actions (when available)
2. Drop the universal jar into your `mods` folder
3. Launch the game (Fabric or NeoForge)
4. Future versions will auto-generate trainers in villages

## 🔧 Building from Source

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

## 🐛 Bug Reports

Found an issue or want to suggest mechanics? Open an issue on [GitHub](https://github.com/Akxe/villager-trainers/issues).

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
