package com.example.examplemod;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class RubyOreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
		if (world.provider.dimensionId == 0) {
			// We want to generate lots of veins in a chunk (up to 128), 
			// so we will wrap the whole thing in a for loop 
			// to repeat the process 128 times.
			
			// ASSIGNMENT 1a
			// Adjust it so there are only up to two veins per chunk.
			for (int i = 0; i < 3; i++) {
				// set coordinates
				// The x and z coordinates will range from 0 to 15, 
				// and the y coordinate will range from 15 to 160 (15 + 145 = 160), 
				// which means that the vein can spawn anywhere in the chunk 
				// between layers 15 to 160.
				int x = chunkX * 16 + random.nextInt(16);
			
				// ASSIGNMENT 1b
				// Make rubies spawn only between depths 16 to 30.
				int y = 16 + random.nextInt(30);
				int z = chunkZ * 16 + random.nextInt(16);

					
				
				// We then use the built in WorldGenMinable class 
				// to actually create the vein, 
				// which for now will be max size 16 (ruby ore blocks):
				
				// ASSIGNMENT 1c
				// Make ruby veins only contain up to 6 rubies in a vein
				new WorldGenMinable(GameRegistry
					.findBlock(ExampleMod.MODID, "oreRuby"), 6)
					.generate(world, random, x, y, z);

			}
			
		}

	}

}
