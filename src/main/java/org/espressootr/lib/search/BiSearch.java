package org.espressootr.lib.search;

import java.util.ArrayList;
import java.util.List;

public class BiSearch implements BeanSearch
{
    
    @Override
    public List<Integer> search(List<String> targetCollection, String searchKeyword)
    {
        return biSearch(targetCollection, searchKeyword);
        
    }
    
    private static List<Integer> biSearch(List<String> searchTarget, String searchKeyword)
    {
        
        int searchIndex = -1;
        
        int start, end, midPt;
        final int FIND = 0;
        start = 0;
        end = searchTarget.size() - 1;
        
        while (start <= end)
        {
            midPt = (start + end) / 2;
            
            int result = searchTarget.get(midPt).compareTo(searchKeyword);
            
            if (result == FIND)
            {
                searchIndex = midPt;
                break;
                
            }
            else if (result < FIND)
            {
                start = midPt + 1;
            }
            else
            {
                end = midPt - 1;
            }
        }
        
        List<Integer> searchIndexList = new ArrayList<Integer>();
        searchIndexList.add(searchIndex);
        
        return searchIndexList;
    }
    
}
