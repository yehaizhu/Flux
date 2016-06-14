package sousou.zyh.com.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

/**
 * Created by zyh on 2016/4/6.
 */
public class GsonUtil {
    public static Gson gson = new GsonBuilder().setDateFormat(
            "yyyy-MM-dd HH:mm:ss").create();


    public static <T> T jsonToBean(String json, Class<T> obj) {
        T t = null;
        try {
            t = gson.fromJson(json, obj);
        } catch (JsonSyntaxException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        return t;
    }

    public static String objectToString(Object obj) {
        String s = null;
        try {
            s = gson.toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
