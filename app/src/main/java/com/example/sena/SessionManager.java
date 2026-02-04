package com.example.sena;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private static final String PREF = "SENA_SESSION";
    private static final String KEY_USER = "current_user";

    public static void setLoggedUser(Context ctx, String username) {
        SharedPreferences sp = ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        sp.edit().putString(KEY_USER, username == null ? null : username.trim()).apply();
    }

    public static String getLoggedUser(Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        return sp.getString(KEY_USER, null);
    }

    public static boolean isLoggedIn(Context ctx) {
        return getLoggedUser(ctx) != null && !getLoggedUser(ctx).trim().isEmpty();
    }

    public static void logout(Context ctx) {
        SharedPreferences sp = ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        sp.edit().remove(KEY_USER).apply();
    }

    public static String userPrefix(Context ctx) {
        String u = getLoggedUser(ctx);
        if (u == null || u.trim().isEmpty()) return "guest_";
        return "u_" + u.trim().toLowerCase() + "_";
    }
}
