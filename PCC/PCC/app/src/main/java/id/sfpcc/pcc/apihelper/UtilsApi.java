/*
 * Copyright (c) 2017. Gilang Ramadhan (gilangramadhan96.gr@gmail.com)
 */

package id.sfpcc.pcc.apihelper;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

import java.util.HashMap;

import id.sfpcc.pcc.LoginActivity;

/**
 * Created by Gilang Ramadhan on 11/06/2017.
 */

public class UtilsApi {
    public static final String url = "http://192.168.52.202/pcc/";
    Context mContext;
    static SharedPreferences pref;
    Editor editor;
    private static final String PREF_NAME = "pcc";
    int PRIVATE_MODE = 0;

    public static final String LOGIN_USER = "login";
    public static final String NAMA_USER = "nama_user";
    public static final String EMAIL_USER = "email_user";
    public static final String PASS_USER = "pass_user";
    public static final String NO_USER = "no_user";
    public static final String ALAMAT_USER = "alamat_user";
    public static final String JABATAN_USER = "jabatan_user";

    //metode
    public static BaseApiService getApiService(){
        return RetrofitClient.getClient(url).create(BaseApiService.class);
    }

    //metode
    public UtilsApi (Context context){
        this.mContext = context;
        pref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    //Create Login Session
    public void CreateLoginSession(String nama_user, String email_user, String pass_user, String no_user, String alamat_user, String jabatan_user){
        editor.putBoolean(LOGIN_USER, true);
        editor.putString(NAMA_USER, nama_user);
        editor.putString(EMAIL_USER, email_user);
        editor.putString(PASS_USER, pass_user);
        editor.putString(NO_USER, no_user);
        editor.putString(ALAMAT_USER, alamat_user);
        editor.putString(JABATAN_USER, jabatan_user);
        editor.commit();
    }

    public HashMap<String, String > getUser (){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(NAMA_USER, pref.getString(NAMA_USER, null));
        user.put(EMAIL_USER, pref.getString(EMAIL_USER, null));
        user.put(PASS_USER, pref.getString(PASS_USER, null));
        user.put(NO_USER, pref.getString(NO_USER, null));
        user.put(ALAMAT_USER, pref.getString(ALAMAT_USER, null));
        user.put(JABATAN_USER, pref.getString(JABATAN_USER, null));
    return user;
    }

    public static boolean isLoged(){
        return pref.getBoolean(LOGIN_USER, false);
    }

    public void logout(){
        editor.clear();
        editor.commit();
    }
}
