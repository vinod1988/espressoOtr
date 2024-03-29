package org.espressootr.lib.search;

import java.util.List;

public class Searcher
{
    static final BeanSearch biSearch;
    static final BeanSearch extBiSearch;
    static final BeanSearch incBiSearch;
    static final BeanSearch extIncBiSearch;
    
    static
    {
        
        biSearch = new BiSearch();
        extBiSearch = new ExtendedBiSearch();
        incBiSearch = new InclusiveBiSearch();
        extIncBiSearch = new ExtendedInclusiveBiSearch();
        
    }
    
    public static List<Integer> search(final List<String> targetCollection, final String searchKeyword)
    {
        return biSearch.search(targetCollection, searchKeyword);
    }
    
    public static List<Integer> extendedSearch(final List<String> targetCollection, final String searchKeyword)
    {
        return extBiSearch.search(targetCollection, searchKeyword);
    }
    
    public static List<Integer> incSearch(final List<String> targetCollection, final String searchKeyword)
    {
        return incBiSearch.search(targetCollection, searchKeyword);
    }
    
    public static List<Integer> extIncSearch(final List<String> targetCollection, final String searchKeyword)
    {
        return extIncBiSearch.search(targetCollection, searchKeyword);
    }
    
}
