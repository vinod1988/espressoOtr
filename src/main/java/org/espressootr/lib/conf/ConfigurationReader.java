package org.espressootr.lib.conf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.espressootr.lib.utils.InitUtil;

public class ConfigurationReader
{
    private final static String CONFIG_SPLITTER = ":"; 
    private final static char CONFIG_COMMENT = ';';
    
    private String configSplitter = InitUtil.EMPTY_STRING;
    private char configComment = InitUtil.EMPTY_CHAR;
    
    public ConfigurationReader()
    {
        this.configSplitter = CONFIG_SPLITTER;
        this.configComment = CONFIG_COMMENT; 
    }
      
    
    public String getConfigSplitter()
    {
        return configSplitter;
    }
  

    public void setConfigSplitter(String configSplitter)
    {
        this.configSplitter = configSplitter;
    }



    public char getConfigComment()
    {
        return configComment;
    }



    public void setConfigComment(char configComment)
    {
        this.configComment = configComment;
    }



    public ConfigMap loadConfiguration(String confFilePath) throws IOException
    {
        
        ConfigMap confMap = new ConfigMap();
        
        FileReader confFileReader = new FileReader(confFilePath);
        
        BufferedReader confReader = new BufferedReader(confFileReader);
        
        String line = null;
        String configKey = null;
        String configValue = null;
        
        while ((line = confReader.readLine()) != null)
        {
            line = line.trim();
            
            if (line.contains(CONFIG_SPLITTER) == true)
            {
                String[] keyValue = extractKeyValue(line);
                
                configKey = keyValue[0].trim();
                configValue = keyValue[1].trim();
                
                if (isVaildKeyValue(configKey, configValue) == true)
                {
                    confMap.set(configKey.toUpperCase(), configValue);
                }
                
            }
        }
        
        confReader.close();
        confFileReader.close();
        
        return confMap;
    }
    
    private String[] extractKeyValue(String configItem)
    {
        
        String[] keyValue = new String[2];
        int firstSplittedIndex = configItem.indexOf(CONFIG_SPLITTER);
        
        keyValue[0] = configItem.substring(0, firstSplittedIndex);
        keyValue[1] = configItem.substring(firstSplittedIndex + 1, configItem.length());
        
        return keyValue;
    }
    
    private boolean isVaildKeyValue(String configKey, String configValue)
    {
        
        boolean isVaild = true;
        
        if (configKey != null && configValue != null)
        {
            if (configKey.length() != 0 && configValue.length() != 0)
                isVaild = true;
            else if (configKey.toCharArray()[0] == CONFIG_COMMENT) // comment
                isVaild = false;
            else
                isVaild = false;
        }
        else
        {
            isVaild = false;
        }
        
        return isVaild;
    }
}
