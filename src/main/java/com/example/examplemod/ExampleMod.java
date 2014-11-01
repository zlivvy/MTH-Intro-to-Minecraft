package com.example.examplemod;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
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
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
    }
}
