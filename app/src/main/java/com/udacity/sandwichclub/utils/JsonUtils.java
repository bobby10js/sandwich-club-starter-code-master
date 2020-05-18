package com.udacity.sandwichclub.utils;

import android.util.Log;
import com.udacity.sandwichclub.model.Sandwich;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class JsonUtils {
    static List<String> convert( JSONArray jsonArray){
        List<String> list =new ArrayList<>();
        try{
            for (int i = 0; i <jsonArray.length(); i++)
                list.add(jsonArray.getString(i));
            return list;
        }catch (Exception e){
            return null;
        }
    }
    public static Sandwich parseSandwichJson(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject names = jsonObject.getJSONObject("name");
            return new Sandwich(names.getString("mainName"),convert(names.getJSONArray("alsoKnownAs")), jsonObject.getString("placeOfOrigin"), jsonObject.getString("description"), jsonObject.getString("image"), convert(jsonObject.getJSONArray("ingredients")));
        }
        catch (Exception e){
            Log.e(TAG,"StringToJson"+e);
            return  null;
        }
    }
}
