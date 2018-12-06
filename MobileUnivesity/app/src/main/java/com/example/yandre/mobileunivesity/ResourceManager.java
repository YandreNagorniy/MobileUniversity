package com.example.yandre.mobileunivesity;

import android.content.Context;

public class ResourceManager {

    private Context context;

    public ResourceManager(Context context) {
        this.context = context;
    }

    public String getString(Integer idRes) {
        return context.getString(idRes);
    }

}
