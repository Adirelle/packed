package de.geekeey.packed.init;

import de.geekeey.packed.Packed;
import de.geekeey.packed.block.VariantBarrelBlock;
import de.geekeey.packed.block.VariantChestBlock;
import de.geekeey.packed.block.VariantCrateBlock;
import de.geekeey.packed.init.helpers.*;
import de.geekeey.packed.item.StorageUpgrader;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class PackedItems {

    public static final WoodItemVariants<StorageTier, VariantBarrelBlock> BARREL_DEFAULT_TIER;
    public static final WoodItemVariants<StorageTier, VariantBarrelBlock> BARREL_TIER_1;
    public static final WoodItemVariants<StorageTier, VariantBarrelBlock> BARREL_TIER_2;
    public static final WoodItemVariants<StorageTier, VariantBarrelBlock> BARREL_TIER_3;

    public static final WoodItemVariants<StorageTier, VariantChestBlock> CHEST_DEFAULT_TIER;
    public static final WoodItemVariants<StorageTier, VariantChestBlock> CHEST_TIER_1;
    public static final WoodItemVariants<StorageTier, VariantChestBlock> CHEST_TIER_2;
    public static final WoodItemVariants<StorageTier, VariantChestBlock> CHEST_TIER_3;

    public static final WoodItemVariants<StorageTier, VariantCrateBlock> CRATE_DEFAULT;
    public static final WoodItemVariants<StorageTier, VariantCrateBlock> CRATE_TIER_1;
    public static final WoodItemVariants<StorageTier, VariantCrateBlock> CRATE_TIER_2;
    public static final WoodItemVariants<StorageTier, VariantCrateBlock> CRATE_TIER_3;

    public static final StorageUpgrader STORAGE_UPGRADER_DEFAULT;
    public static final StorageUpgrader STORAGE_UPGRADER_TIER1;
    public static final StorageUpgrader STORAGE_UPGRADER_TIER2;

    static {
        BARREL_DEFAULT_TIER = new WoodItemVariants<>(PackedBlocks::barrel, PackedBlocks.BARREL_DEFAULT, Packed.ITEM_GROUP);
        BARREL_TIER_1 = new WoodItemVariants<>(PackedBlocks::barrel, PackedBlocks.BARREL_TIER_1, Packed.ITEM_GROUP);
        BARREL_TIER_2 = new WoodItemVariants<>(PackedBlocks::barrel, PackedBlocks.BARREL_TIER_2, Packed.ITEM_GROUP);
        BARREL_TIER_3 = new WoodItemVariants<>(PackedBlocks::barrel, PackedBlocks.BARREL_TIER_3, Packed.ITEM_GROUP);

        CHEST_DEFAULT_TIER = new WoodItemVariants<>(PackedBlocks::chest, PackedBlocks.CHEST_DEFAULT, Packed.ITEM_GROUP);
        CHEST_TIER_1 = new WoodItemVariants<>(PackedBlocks::chest, PackedBlocks.CHEST_TIER_1, Packed.ITEM_GROUP);
        CHEST_TIER_2 = new WoodItemVariants<>(PackedBlocks::chest, PackedBlocks.CHEST_TIER_2, Packed.ITEM_GROUP);
        CHEST_TIER_3 = new WoodItemVariants<>(PackedBlocks::chest, PackedBlocks.CHEST_TIER_3, Packed.ITEM_GROUP);

        CRATE_DEFAULT = new WoodItemVariants<>(PackedBlocks::crate, PackedBlocks.CRATE_DEFAULT, Packed.ITEM_GROUP);
        CRATE_TIER_1 = new WoodItemVariants<>(PackedBlocks::crate, PackedBlocks.CRATE_TIER_1, Packed.ITEM_GROUP);
        CRATE_TIER_2 = new WoodItemVariants<>(PackedBlocks::crate, PackedBlocks.CRATE_TIER_2, Packed.ITEM_GROUP);
        CRATE_TIER_3 = new WoodItemVariants<>(PackedBlocks::crate, PackedBlocks.CRATE_TIER_3, Packed.ITEM_GROUP);

        STORAGE_UPGRADER_DEFAULT = Registry.register(Registry.ITEM,Packed.id("storage_upgrader_default"),new StorageUpgrader(new Item.Settings().group(Packed.ITEM_GROUP), StorageTiers.DEFAULT, StorageTiers.TIER_1));
        STORAGE_UPGRADER_TIER1 = Registry.register(Registry.ITEM,Packed.id("storage_upgrader_tier1"),new StorageUpgrader(new Item.Settings().group(Packed.ITEM_GROUP), StorageTiers.TIER_1, StorageTiers.TIER_2));
        STORAGE_UPGRADER_TIER2 = Registry.register(Registry.ITEM,Packed.id("storage_upgrader_tier2"),new StorageUpgrader(new Item.Settings().group(Packed.ITEM_GROUP), StorageTiers.TIER_2, StorageTiers.TIER_3));
    }

    public static void register() {
        // keep so class will get called and initialized
    }

}
