#!/bin/bash

if [[ ! -d './src' ]]
then
  echo "Please make sure the current working directory is the root of the project"
  exit 1
fi

PATH_BLOCK_STATES='./src/main/resources/assets/packed/blockstates'
PATH_MODELS_BLOCK='./src/main/resources/assets/packed/models/block'
PATH_MODELS_ITEM='./src/main/resources/assets/packed/models/item'

FROM_TIER='default'
MAKE_TIER='tier3'

variants=('acacia_chest_' 'birch_chest_' 'dark_oak_chest_' 'jungle_chest_' 'oak_chest_' 'spruce_chest_')
for variant in "${variants[@]}"
do
  # block state default
  cp "${PATH_BLOCK_STATES}/${variant}${FROM_TIER}.json" "${PATH_BLOCK_STATES}/${variant}${MAKE_TIER}.json"
  # model block
  cp "${PATH_MODELS_BLOCK}/${variant}${FROM_TIER}.json" "${PATH_MODELS_BLOCK}/${variant}${MAKE_TIER}.json"
  # model item
  cp "${PATH_MODELS_ITEM}/${variant}${FROM_TIER}.json" "${PATH_MODELS_ITEM}/${variant}${MAKE_TIER}.json"
done