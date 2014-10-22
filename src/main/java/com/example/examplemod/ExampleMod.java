package com.example.examplemod;

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
    	Item ruby = new Item();
    	ruby.setUnlocalizedName("ruby");
    	ruby.setCreativeTab(CreativeTabs.tabMaterials);
    	GameRegistry.registerItem(ruby, "ruby");
    	ruby.setTextureName(MODID + ":ruby");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
    }
}
