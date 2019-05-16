package com.example.testesharedpreferences.util;

import android.content.Context;
import android.content.SharedPreferences;


public class SecurityPreferences {

    private SharedPreferences mSharedPreferences; // variavel

    // CONSTRUTOR
    public SecurityPreferences(Context mcontext) {
        this.mSharedPreferences = mcontext.getSharedPreferences("BD_Parametros", Context.MODE_PRIVATE);
    } // Fim do Construtor

    public void storeString(String key, String value){
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public String getStoredString(String key){
        return this.mSharedPreferences.getString(key, "nada");
    }


}



