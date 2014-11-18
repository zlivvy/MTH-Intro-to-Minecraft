package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCompressed;
import net.minecraft.block.material.MapColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    // PreInit
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	// Ruby
    	Item ruby = new Item();
    	ruby.setUnlocalizedName("ruby");
    	ruby.setCreativeTab(CreativeTabs.tabMaterials);
    	GameRegistry.registerItem(ruby, "ruby");
    	ruby.setTextureName(MODID + ":ruby");
    	
    	// RubyOre
    	Block rubyOre = new RubyOre()
    		.setHardness(3.0F)
    		.setResistance(5.0F)
    		.setStepSound(Block.soundTypePiston)
    		.setBlockName("oreRuby")
    		.setBlockTextureName("examplemod:ruby_ore");
    	GameRegistry.registerBlock(rubyOre, "oreRuby");
    	
    	// Ruby Block
    	Block rubyBlock = new BlockCompressed(MapColor.redColor)
    		.setHardness(5.0F)
    		.setResistance(10.0F)
    		.setStepSound(Block.soundTypeMetal)
    		.setBlockName("blockRuby")
    		.setBlockTextureName("examplemod:ruby_block");
    	GameRegistry.registerBlock(rubyBlock, "blockRuby");
    	
    	// Recipe for solid Ruby Block
    	GameRegistry.addShapedRecipe(new ItemStack(rubyBlock),
    			// Recipe: 9 rubies per Ruby Block
    			"###", 
    			"###", 
    			"###", 
    			// ruby
    			'#', ruby);
    	GameRegistry.addShapedRecipe(new ItemStack(ruby, 9),
    			"#", 
    			'#', rubyBlock);
    	ToolMaterial rubyTool = EnumHelper.addToolMaterial("RUBY", 3, 1561, 8.0F, 3.0F, 10);
    	
    	 Item rubySword = new ItemSword(rubyTool).setUnlocalizedName("rubySword").setTextureName(MODID + ":ruby_sword");
    	 GameRegistry.registerItem(rubySword, "rubySword");
    	 
    	 GameRegistry.addShapedRecipe(new ItemStack(rubySword), "X",
                 "X",
                 "#",
                 'X', ruby,
                 '#', Items.stick);
    }
    // Init
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// Generate ruby veins
    	GameRegistry.registerWorldGenerator(new RubyOreGenerator(), 0);
    }
}
