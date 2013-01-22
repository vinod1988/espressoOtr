package org.espressootr.lib.search;

import java.util.ArrayList;
import java.util.List;

import org.espressootr.lib.string.StringComparer;

public class ExtendedInclusiveBiSearch implements BeanSearch
{

    @Override
    public List<Integer> search(List<String> targetCollection, String searchKeyword)
    {
        return biExtendedSearchInclusiveRelation(targetCollection, searchKeyword);
        
    }
    
    private static List<Integer> biExtendedSearchInclusiveRelation(List<String> searchTarget, String searchKeyword)
    {
        
        List<Integer> searchIndex = new ArrayList<Integer>();
        
        int start, end, midPt;
        final int FIND = 0;
        start = 0;
        end = searchTarget.size() - 1;
        
        int result = -1;
        
        while (start <= end)
        {
            midPt = (start + end) / 2;
            
            result = searchTarget.get(midPt).compareTo(searchKeyword);
            
            if (result != FIND && searchKeyword.length() < searchTarget.get(midPt).length())
            { 
                result = searchTarget.get(midPt).substring(0, searchKeyword.length()).compareTo(searchKeyword);
            }
            
            if (result == FIND)
            {
                searchIndex.add(midPt);
                
                if (midPt > 0)
                {// Search upward
                
                    int submid = midPt;
                    submid--;
                    
                    for (;;)
                    {
                        if (submid < 0)
                        {
                            break;
                        }
                        
                        result = searchTarget.get(submid).compareTo(searchKeyword);
                        if (result != FIND && (searchKeyword.length() < searchTarget.get(submid).length()))
                        {
                            if (StringComparer.compareTo(searchKeyword.length(), searchKeyword, searchTarget.get(submid)))
                            {// strncmp
                            
                                result = FIND;
                            }
                        }
                        
                        if (result == FIND)
                        {
                            searchIndex.add(submid);
                            submid--;
                        }
                        else
                        {
                            break;// for break
                        }
                    }
                    
                }
                
                if (midPt < searchTarget.size())
                {// Search downward
                
                    int submid = midPt;
                    submid++;
                    
                    for (;;)
                    {
                        if (submid >= searchTarget.size())
                        {
                            break;// for break
                        }
                        
                        result = searchTarget.get(submid).compareTo(searchKeyword);
                        if (result != FIND && searchKeyword.length() < searchTarget.get(submid).length())
                        {
                            if (StringComparer.compareTo(searchKeyword.length(), searchKeyword, searchTarget.get(submid)))
                            {// strncmp
                                result = FIND;
                            }
                        }
                        
                        if (result == FIND)
                        {
                            searchIndex.add(submid);
                            submid++;
                        }
                        else
                        {
                            break; // for break
                        }
                    }
                }
                
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
        
        return searchIndex;
    }
     
}
