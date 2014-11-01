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
			for (int i = 0; i < 128; i++) {
				// set coordinates
				int x = chunkX * 16 + random.nextInt(16);
				int y = 15 + random.nextInt(145);
				int z = chunkZ * 16 + random.nextInt(16);
					
				
				// make a block
				new WorldGenMinable(GameRegistry
					.findBlock(ExampleMod.MODID, "oreRuby"), 16)
					.generate(world, random, x, y, z);

			}
			
		}

	}

}
