package com.boongg.store.Utilities;

import android.util.Base64;
import android.util.JsonToken;
import android.util.Log;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class JWTUtils {

    public static String decoded(String JWTEncoded) throws Exception {
        try {
            String[] split = JWTEncoded.split("\\.");
            Log.d("JWT_DECODED", "Header: " + getJson(split[0]));
            Log.d("JWT_DECODED", "Body: " + getJson(split[1]));
            JSONObject user=new JSONObject(getJson(split[1]));
            return  user.getJSONObject("user").getString("_store");

        } catch (UnsupportedEncodingException e) {
            //Error
        }
        return null;
    }

    public static JSONObject getUserLoginDetailsFromJWT(String JWTEncoded) throws Exception {
        try {
            String[] split = JWTEncoded.split("\\.");
            Log.d("JWT_DECODED", "Header: " + getJson(split[0]));
            Log.d("JWT_DECODED", "Body: " + getJson(split[1]));
            JSONObject user=new JSONObject(getJson(split[1]));
            return  user.getJSONObject("user");

        } catch (UnsupportedEncodingException e) {
            //Error
        }
        return null;
    }

    public static String getCreatedTime(String JWTEncoded) throws Exception {
        try {
            String[] split = JWTEncoded.split("\\.");
            JSONObject user=new JSONObject(getJson(split[1]));
            return  user.getString("iat");

        } catch (UnsupportedEncodingException e) {
            //Error
        }
        return null;
    }
    private static String getJson(String strEncoded) throws UnsupportedEncodingException{
        byte[] decodedBytes = Base64.decode(strEncoded, Base64.URL_SAFE);
        return new String(decodedBytes, "UTF-8");
    }
}