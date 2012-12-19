package org.espressootr.lib.parallel;

public class ParallelCount
{
    
    public static int availableParallelCount()
    {
        return Runtime.getRuntime().availableProcessors();
    }
    
    public static int adjustParallelCount(int parallelCount)
    {
        int cpuCore = Runtime.getRuntime().availableProcessors();
        
        if (parallelCount > cpuCore)
        {
            
            parallelCount = cpuCore;
            
        }
        
        return parallelCount;
        
    }
}
