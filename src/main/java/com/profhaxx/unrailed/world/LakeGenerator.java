package com.profhaxx.unrailed.world;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import com.profhaxx.unrailed.App;

public class LakeGenerator {
    public static HashMap <LakeSource, GenerationTuple> generationMap = new HashMap<>();

    public static boolean empty() {
        Iterator it = generationMap.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if(!((GenerationTuple) pair.getValue()).empty()) return false;
        }
        return true;
    }

    public static void generate(World world, int x, int y) {
        /*
        generationMap.put(new LakeSource(world, i, j));
        while(!empty()) {

        }*/
        
        int upperX = (x - world.clusterSize/2) < 0 ? 0 
            : x - world.clusterSize;
        int lowerX = (x + world.clusterSize/2) > App.WIDTH/world.cmpsize 
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
                    world.spawn(new LakeSource(world, i, j));
                }
            }
        }
    }
}
