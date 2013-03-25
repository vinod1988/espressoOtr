package org.espressootr.lib.json;
 
import com.google.gson.Gson;

/***
 * not thread-safe
 * @author AhnSeongHyun
 *
 */
public class JsonBodum
{
    static final Gson gson = new Gson();
    
    public static String toJson(final Object src)
    {
        return gson.toJson(src);
    }
    
    public static <T> T fromJson(final String json, final Class<T> classOfT)
    {
        return gson.fromJson(json, classOfT);
    } 
 
}
