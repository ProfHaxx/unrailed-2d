package com.profhaxx.unrailed.world;

import java.util.Random;

import com.profhaxx.unrailed.App;

public class RockGenerator {
    public static void generate(World world, int x, int y) {
        int upperX = (x - world.clusterSize) < 0 ? 0 
            : x - world.clusterSize;
        int lowerX = (x + world.clusterSize) > App.WIDTH/world.cmpsize 
            ?  App.WIDTH/world.cmpsize 
            : x + world.clusterSize;

        int upperY = (y - world.clusterSize) < 0 ? 0
            : y - world.clusterSize;
        int lowerY = (y + world.clusterSize) > App.HEIGHT/world.cmpsize
            ? App.HEIGHT/world.cmpsize
            : y + world.clusterSize;

        Random random = new Random();
        for(int i = upperX; i < lowerX; i++) {
            for(int j = upperY; j < lowerY; j++) {
                int dist = Math.abs(x-j) + Math.abs(y-j);
                double rand = random.nextDouble();

                if(rand < Math.pow(1.1, -2.0 * dist)) {
                    world.spawn(new RockDeposit(world, i, j));
                }
            }
        }
    }
}
