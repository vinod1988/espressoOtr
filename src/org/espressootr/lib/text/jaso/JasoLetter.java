package org.espressootr.lib.text.jaso;

import java.util.ArrayList;
import java.util.List;

public class JasoLetter
{
    
    private List<String> choSung = null;
    private List<String> jungSung = null;
    private List<String> jongSung = null;
    private List<String> etc = null;
    
    public JasoLetter()
    {
        this.choSung = new ArrayList<String>();
        this.jungSung = new ArrayList<String>();
        this.jongSung = new ArrayList<String>();
        this.etc = new ArrayList<String>();
        
    }
    
    public void addChoSung(String chosung)
    {
        
        this.choSung.add(chosung);
        
    }
    
    public void addJungSung(String jungsung)
    {
        
        this.jungSung.add(jungsung);
        
    }
    
    public void addJongSung(String jongsung)
    {
        
        this.jongSung.add(jongsung);
        
    }
    
    public void addEtc(String etc)
    {
        
        this.etc.add(etc);
        
    }
    
    public List<String> getChoSung()
    {
        return choSung;
    }
    
    public void setChoSung(List<String> choSung)
    {
        this.choSung = choSung;
    }
    
    public List<String> getJungSung()
    {
        return jungSung;
    }
    
    public void setJungSung(List<String> jungSung)
    {
        this.jungSung = jungSung;
    }
    
    public List<String> getJongSung()
    {
        return jongSung;
    }
    
    public void setJongSung(List<String> jongSung)
    {
        this.jongSung = jongSung;
    }
    
    public List<String> getEtc()
    {
        return etc;
    }
    
    public void setEtc(List<String> etc)
    {
        this.etc = etc;
    }
    
}
