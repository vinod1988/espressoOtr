package org.espressootr.lib.search;

import java.util.List;

public interface BeanSearch
{
    List<Integer> search(List<String> targetCollection, String searchKeyword);
    
}
