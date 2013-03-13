package org.espressootr.unittest;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.espressootr.lib.html.HtmlExtractor;
import org.junit.Before;
import org.junit.Test;

public class TestHtmlExtractor
{
    
    String target = "<span style='line-height:2;'><b>Hello World.</b></span>";
    
    String targetUrl = "http://ash84.tistory.com/notice/848";
    
    @Before
    public void setUp() throws Exception
    {
        
    }
    
    @Test
    public void testGetTagFromHTMLString()
    {
        List<String> tags = HtmlExtractor.getTagFromHtmlString(target);
        System.out.println(tags);
        assertEquals(2, tags.size());
    }
    
    @Test
    public void testGetStringFromHTMLString()
    {
        String str = HtmlExtractor.getStringFromHtmlString(target);
        
        assertEquals(str, "Hello World.");
    }
    
    @Test
    public void testGetTag() throws MalformedURLException, IOException
    {
        List<String> tags = HtmlExtractor.getTag(targetUrl);
    }
    
    @Test
    public void testGetString() throws MalformedURLException, IOException
    {
        String str = HtmlExtractor.getString(targetUrl);
        
    }
    
    @Test
    public void testGetLinkTag() throws MalformedURLException, IOException
    {
        List<String> linkUrlList = HtmlExtractor.getLinkTagValue(targetUrl);
        
        assertEquals(27,linkUrlList.size());
    }
    
    @Test
    public void testGetImgTag() throws MalformedURLException, IOException
    {
        List<String> imgSrcList = HtmlExtractor.getImgTagValue(targetUrl);
        
        assertEquals(2,imgSrcList.size());
    }
    
    @Test
    public void testGetBodyString() throws MalformedURLException, IOException
    {
        String str = HtmlExtractor.getBodyString(targetUrl); 
        
    }
    
}
