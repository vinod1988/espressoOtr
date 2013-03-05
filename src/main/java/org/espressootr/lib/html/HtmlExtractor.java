package org.espressootr.lib.html;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

public class HtmlExtractor
{
    public static List<String> getTagFromHtmlString(String htmlString)
    {
        List<String> tagList = new ArrayList<String>();
        
        Source source = new Source(htmlString);
        for (Element e : source.getAllElements())
        {
            tagList.add(e.getName());
        }
        
        return tagList;
        
    }
    
    public static String getStringFromHtmlString(String htmlString)
    {
        Source source = new Source(htmlString);
        return source.getTextExtractor().toString();
        
    }
    
    public static String getString(String url) throws MalformedURLException, IOException
    {
        Source source = new Source(new URL(url));
        return source.getTextExtractor().toString();
        
    }
    
    public static List<String> getTag(String url) throws MalformedURLException, IOException
    {
        List<String> tagList = new ArrayList<String>();
        
        Source source = new Source(new URL(url));
        for (Element e : source.getAllElements())
        {
            tagList.add(e.getName());
        }
        
        return tagList;
    }

    public static String getLinkTagValue(String targetUrl)
    {
        // TODO Auto-generated method stub
        return null; 
        
    }

    public static String getImgTagValue(String targetUrl)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
}
