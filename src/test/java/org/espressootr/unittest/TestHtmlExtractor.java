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
    
    String target = "<span style='line-height:2;'><b>안녕하세요</b></span>";
    
    String targetUrl = "http://ash84.tistory.com/notice/848";
    
    @Before
    public void setUp() throws Exception
    {
        
    }
    
    @Test
    public void testGetTagFromHTMLString()
    {
        List<String> tags = HtmlExtractor.getTagFromHtmlString(target);
        
        assertEquals(2, tags.size());
    }
    
    @Test
    public void testGetStringFromHTMLString()
    {
        String str = HtmlExtractor.getStringFromHtmlString(target);
        
        assertEquals(str, "안녕하세요");
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
    public void testGetLinkTag()
    {
        String linkUrl = HtmlExtractor.getLinkTagValue(targetUrl);
        
        // TODO:WRITE TEST CASE
        fail("Not yet implemented");
        
    }
    
    @Test
    public void testGetImgTag()
    {
        String imgUrl = HtmlExtractor.getImgTagValue(targetUrl);
        
        // TODO:WRITE TEST CASE
        fail("Not yet implemented");
    }
    
}
