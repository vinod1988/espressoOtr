package org.espressootr.lib.json;
 
import com.google.gson.Gson;

public class JsonBodum
{
    static final Gson gson = new Gson();
    
    public static String toJson(Object src)
    {
        return gson.toJson(src);
    }
    
    public static <T> T fromJson(String json, Class<T> classOfT)
    {
        return gson.fromJson(json, classOfT);
    } 
 
}
