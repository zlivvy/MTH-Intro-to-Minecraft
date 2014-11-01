package com.example.examplemod;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;

public class RubyOre extends BlockOre {
	@Override
	public Item getItemDropped(int par1, Random random, int par3) {
		return GameRegistry.findItem(ExampleMod.MODID, "ruby");
	}

}
