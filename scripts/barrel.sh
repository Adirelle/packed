#!/bin/bash

BASE="$(dirname "$(readlink -fn "$0")")"

BLOCK_STATES="${ASSETS}/blockstates"
MODELS_BLOCK="${ASSETS}/models/block"
MODELS_ITEM="${ASSETS}/models/item"

[[ ! -d "${BLOCK_STATES}" ]] && mkdir -p "${BLOCK_STATES}"
[[ ! -d "${MODELS_BLOCK}" ]] && mkdir -p "${MODELS_BLOCK}"
[[ ! -d "${MODELS_ITEM}" ]] && mkdir -p "${MODELS_ITEM}"

RECIPES="${DATA}/recipes"
RECIPE_ADVANCEMENTS="${DATA}/advancements/recipes"

[[ ! -d "${RECIPES}" ]] && mkdir -p "${RECIPES}"
[[ ! -d "${RECIPE_ADVANCEMENTS}" ]] && mkdir -p "${RECIPE_ADVANCEMENTS}"

VARIANTS=('acacia' 'birch' 'dark_oak' 'jungle' 'oak' 'spruce' 'crimson' 'warped')
TIERS=('default' 'tier1' 'tier2' 'tier3')

for VARIANT in "${VARIANTS[@]}"; do
  export VARIANT
  for TIER in "${TIERS[@]}"; do
    export TIER
    export PREVIOUS_TIER
    file="${VARIANT}_barrel_${TIER}"
    envsubst <"${BASE}/presets/barrel/blockstate.json" >"${BLOCK_STATES}/${file}.json"

    envsubst <"${BASE}/presets/barrel/model_block.json" >"${MODELS_BLOCK}/${file}.json"
    envsubst <"${BASE}/presets/barrel/model_block_open.json" >"${MODELS_BLOCK}/${file}_open.json"
    envsubst <"${BASE}/presets/barrel/model_item.json" >"${MODELS_ITEM}/${file}.json"

    #envsubst <"${BASE}/presets/barrel/recipe_${TIER}.json" >"${RECIPES}/${file}.json"

    envsubst < "${BASE}/presets/barrel/advancement_${TIER}.json" > "${RECIPE_ADVANCEMENTS}/${file}.json"

    PREVIOUS_TIER="${TIER}"
  done
done
