package org.espressootr.lib.utils;

public class CapacityUtil
{
    
    /***
     * for HashMap
     * 
     * @param expectedCount
     * @return
     */
    public static int adjustInitialCapacity(final int expectedCount)
    {
        int initCapacity = (expectedCount * 100) / 75;
        
        initCapacity++;
        
        return initCapacity;
    }
}
