package org.espressootr.lib.utils;

public class CapacityUtils
{
    
    /***
     * for HashMap
     * 
     * @param expectedCount
     * @return
     */
    public static int adjustInitialCapacity(int expectedCount)
    {
        int initCapacity = (expectedCount * 100) / 75;
        
        initCapacity++;
        
        return initCapacity;
    }
}
