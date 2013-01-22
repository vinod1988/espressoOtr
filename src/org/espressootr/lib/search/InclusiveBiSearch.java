package org.espressootr.lib.search;

import java.util.ArrayList;
import java.util.List;

import org.espressootr.lib.string.StringComparer;

public class InclusiveBiSearch implements BeanSearch
{

    @Override
    public List<Integer> search(List<String> targetCollection, String searchKeyword)
    {
        return biSearchInclusiveRelation(targetCollection, searchKeyword);
        
    }
    
    private static List<Integer> biSearchInclusiveRelation(List<String> searchTarget, String searchKeyword)
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

            if (result != FIND && searchKeyword.length() < searchTarget.get(midPt).length())
            {
                if (StringComparer.compareTo(searchKeyword.length(), searchKeyword, searchTarget.get(midPt)))
                {// strncmp

                    result = FIND;
                }
            }

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
