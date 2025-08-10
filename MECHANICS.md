# Villager Trainers Mechanics

Expanded reference for each README core feature. Use this for implementation details and validation.

## 1. Classic Cobblemon Combat Integration
- Leverages Cobblemon's base battle engine (turn order, move resolution, status logic).
- Mod hooks add villager-specific AI decisions, arena targeting, reward payout.
- All custom logic must remain data-driven so future Cobblemon updates don't break compatibility.

## 2. Predetermined Teams at Spawn
- Event: villager becomes a trainer (spawn/convert) -> roll exactly 6 UNIQUE final-evolution species.
- Selection source: biome (village type) -> weighted pools -> species list.
- Persist only species identity + evolution chain branch + RNG seed (no level stats yet).
- Never rerolled. Disallow exploitation via save reload by persisting immediately.

## 3. Battle-Time Team & Level Scaling
- On battle start: read current trading level -> locate config bracket.
- Active team size: chosen within bracket `team_size` range (if range >1, deterministic policy or RNG per config).
- After evolution stage resolution (see Section 4), order the 6 stored species by CURRENT FORM total base stat sum ascending; pick the first N for this battle. (Reason: lower-power mons lead early; stronger ones appear only when higher team sizes unlock.)
- Instantiate those N species at bracket level.
- If bracket level < evolution threshold, instantiate lower form (reverse chain). If >= threshold, use highest allowable form.

## 4. Max Evolution Preference
- Stored species always recorded at max evolution to preserve identity.
- De-evolution for display only occurs if bracket level cannot logically sustain the final form.
- Prevents weird mid-life roll differences between villagers of same biome.

## 5. Biome / Village Origin Type Mapping
- Village categories: Desert, Jungle, Plains, Savanna, Snow, Swamp, Taiga (extendable).
- Each origin -> weighted type set -> species candidates.
- Adds incentive for players to establish varied villages.
- Fallback cascade: origin tag -> biome group -> global default.

## 6. Arena Behavior & Spectators
- Trainers attempt pathfinding to nearest valid arena anchor block (configurable list) within search radius.
- Nearby non-participating villagers:
  - Move to safe spectator positions, villagers will try to find a block defined in the config as the preferred spectator spot
  - Optionally cheer (emote events).
- Safety rules: prevent mob interference inside arena bounds. Not needed as we plan to play without mobs

## 7. Item Usage (Master Villagers)
- Only master-tier villagers receive items (policy configurable per tier).
- Budget: numeric value spent allocating item stacks from weighted pool until budget or slot cap reached.
- Example config entry: `{ "item": "cobblemon:full_restore", "maxCount": 3, "cost": 50 }`.
- AI triggers: If Cobblemons has proper AI use theirs, if not, implement one

## 8. Rewards & Reputation
- Win rewards: emerald base + bonus for average opposing level
- First-time defeat of a master-level trainer: reputation bonus for entire village (discount percentage).
- Fleeing or force-ending battle: reputation penalty; cannot drop below configured floor to avoid golems from attacking players

## 9. Wandering Villager (Trader) Battles
- Treated as a special trainer archetype with independent shiny / rare roll rates.
- Can include species not normally found in local biome pools (global exotic pool).
- Additional planned hooks: rotating daily roster, limited-time challenge rewards.

## 10. Shiny / Rare Handling
- Base shiny rate override in wandering archetype section.
- Rare species injection: probabilistic replacement of lowest-weight species on initial preregistered list.

## 11. Trainer Items Allocation Algorithm
- Steps: sort candidate items by priority (revive > heal > utility) -> iterate while budget & caps remain.
- Maintain deterministic ordering using stored seed for reproducibility.
- Record allocated items in battle session only; not persisted.

## 12. Turn-Based Engine Notes
DEFERRED. Rely entirely on upstream Cobblemon battle engine. No custom ordering or status modifications unless later required.

## 13. Contextual AI Heuristics
DEFERRED. If Cobblemon AI suffices, do not override. Only extend minimally for item usage triggers.

## 14. Player Progression & Economy
- Reward formula baseline: `emeralds = base + avg_level * per_level + master_bonus(if first defeat)`.
- Optional loot table injection for rare items.
- Reputation thresholds unlock vendor price reductions & cosmetic villager trainer skins.

## 15. Multi-Loader Architecture
- Shared core under `common/` with platform shims under `fabric/` and `neoforge/`.
- Service interfaces abstract scheduler, networking hooks, command registration.

## 16. Modular JSON5 Config Layout
- Top-level sections: `levels`, `arena`, `biome_pools`, `trainer_items`, `wandering_trader`, `reputation`, `ai`, `rewards`.
- Hot reload the config with command: `/villagertrainers reload` (planned).
- Validation: on load verify team_size max ≤ 6, brackets non-overlapping.
- Example config: see [`config.example.json`](config.example.json)

## 17. Pokémon Selection & Battle Flow
1. Spawn/conversion -> roll & persist 6 final-evo species (store chain + seed).
2. Combat start -> read trading level -> bracket lookup.
3. Resolve evolution stage per species for bracket level (may de-evolve).
4. Sort species by current-form total base stats ascending.
5. Choose active team size from sorted list head & instantiate at scaled level.
4. Allocate items (if tier permits) within budget.
6. Run turn loop until win/lose/flee (delegated to Cobblemon engine).
7. Apply rewards, reputation changes.

---

Future expansions: cooperative tournaments.
