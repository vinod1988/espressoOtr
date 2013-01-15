package org.espressootr.lib.search;

import java.util.ArrayList;
import java.util.List;

public class BiSearch
{
    public static int biSearch(List<String> searchTarget, String searchKeyword)
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

	return searchIndex;
    }

    public static int biSearchIncludeRelation(List<String> searchTarget, String searchKeyword)
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
		if (compareTo(searchKeyword.length(), searchKeyword, searchTarget.get(midPt)))
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

	return searchIndex;
    }

    public static boolean compareTo(int size, String target, String compare)
    {// strncmp

	boolean result = true;
	int i = 0;

	char[] target_letter = target.toCharArray();
	char[] compare_letter = compare.toCharArray();

	for (i = 0; i < size; i++)
	{
	    if (target_letter[i] == compare_letter[i])
	    {
		result = true;
	    }
	    else
	    {
		result = false;
		break;
	    }
	}

	return result;

    }

    public static List<Integer> biExtendedSearch(List<String> searchTarget, String searchKeyword)
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
    
    
    public static List<Integer> binaryInclusiveExtendedSearch(List<String> searchTarget, String searchKeyword)
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
                // if (compareTo(searchKeyword.length(), searchKeyword,
                // searchTarget.get(midPt)))
                
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
                            if (compareTo(searchKeyword.length(), searchKeyword, searchTarget.get(submid)))
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
                            if (compareTo(searchKeyword.length(), searchKeyword, searchTarget.get(submid)))
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
