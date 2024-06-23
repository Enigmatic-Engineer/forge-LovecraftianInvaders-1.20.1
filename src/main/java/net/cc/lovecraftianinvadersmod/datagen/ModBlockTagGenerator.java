package net.cc.lovecraftianinvadersmod.datagen;

import net.cc.lovecraftianinvadersmod.LovecraftianInvadersMod;
import net.cc.lovecraftianinvadersmod.block.ModBlocks;
import net.cc.lovecraftianinvadersmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LovecraftianInvadersMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.FLESHY_BLOCK.get(),
                        ModBlocks.EYE_BLOCK.get()
                );

        this.tag(ModTags.Blocks.PORTAL_DETECTOR_PORTALS)
                .add(ModBlocks.FLESHY_BLOCK.get(),
                        ModBlocks.EYE_BLOCK.get()
                );

        /*this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.FLESHY_BLOCK.get());*/

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.EYE_BLOCK.get(),
                        ModBlocks.FLESHY_BLOCK.get()
                );
    }
}
