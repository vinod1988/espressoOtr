package org.espressootr.lib.utils;

import java.util.Random;

public final class RandomUtil
{
    
    public static int getRandomNumber(int from, int to)
    {
        Random intRandom = new Random();
        
        int ri = intRandom.nextInt(to) + from;
        return ri;
    }
}
