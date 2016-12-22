package com.example.dell.socialcampus.utill.json;

import org.json.JSONObject;

/**
 * Created by atong on 2016/11/27.
 */

public class SCJSONTranslate {

    public static Object translateToObject(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            String s = jsonObject.getString("hello");
            String abc = jsonObject.getString("abc");

        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            return null;
        }
    }
}
