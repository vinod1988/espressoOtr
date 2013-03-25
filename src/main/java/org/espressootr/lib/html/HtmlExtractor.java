package org.espressootr.lib.html;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.espressootr.lib.utils.InitUtil;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;

public class HtmlExtractor
{
    public static List<String> getTagFromHtmlString(final String htmlString)
    {
        List<String> tagList = new ArrayList<String>();
        
        Source source = new Source(htmlString);
        for (Element e : source.getAllElements())
        {
            tagList.add(e.getName());
        }
        
        return tagList;
        
    }
    
    public static String getStringFromHtmlString(final String htmlString)
    {
        Source source = new Source(htmlString);
        return source.getTextExtractor().toString();
        
    }
    
    public static String getString(final String url) throws MalformedURLException, IOException
    {
        Source source = new Source(new URL(url));
        return source.getTextExtractor().toString();
        
    }
    
    public static List<String> getTag(final String url) throws MalformedURLException, IOException
    {
        List<String> tagList = new ArrayList<String>();
        
        Source source = new Source(new URL(url));
        for (Element e : source.getAllElements())
        {
            tagList.add(e.getName());
        }
        
        return tagList;
    }
    
    public static List<String> getLinkTagValue(final String url) throws MalformedURLException, IOException
    {
        List<String> hrefList = new ArrayList<String>();
        
        Source source = new Source(new URL(url));
        
        for (Element e : source.getAllElements())
        {
            if (e.getName().equals("a"))
            {
                hrefList.add(e.getAttributeValue("href"));
                
            }
        }
        
        return hrefList;
        
    }
    
    public static List<String> getImgTagValue(final String url) throws MalformedURLException, IOException
    {
        List<String> imgSrcList = new ArrayList<String>();
        
        Source source = new Source(new URL(url));
        
        for (Element e : source.getAllElements())
        {
            if (e.getName().equals("img"))
            {
                imgSrcList.add(e.getAttributeValue("src"));
                
            }
        }
        
        return imgSrcList;
    }

    public static String getBodyString(final String url) throws MalformedURLException, IOException
    { 
        String bodyString = InitUtil.EMPTY_STRING;
        Source source = new Source(new URL(url));
        
        for (Element e : source.getAllElements())
        {
            if (e.getName().equals("body"))
            {
                bodyString = e.getTextExtractor().toString(); 
            }
        }
        
        return bodyString;
    }
    
    
}
