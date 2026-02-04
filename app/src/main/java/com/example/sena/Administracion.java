package com.example.sena;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class Administracion {

    private static final String PREF = "SENA_AUTH";

    private static String keyPass(String user) { return "user_" + user.toLowerCase() + "_pass"; }
    private static String keyEmail(String user) { return "user_" + user.toLowerCase() + "_email"; }

    public static boolean userExists(Context ctx, String user) {
        SharedPreferences sp = ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        return sp.contains(keyPass(user));
    }

    // 0 = OK, 1 = usuario no existe, 2 = pass incorrecta, 3 = campos vacíos
    public static int login(Context ctx, String user, String pass) {
        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) return 3;

        SharedPreferences sp = ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE);

        if (!sp.contains(keyPass(user))) return 1;

        String savedPass = sp.getString(keyPass(user), "");
        if (!pass.equals(savedPass)) return 2;

        // ✅ sesión actual
        SessionManager.setLoggedUser(ctx, user);
        return 0;
    }

    // 0 = OK, 1 = campos vacíos, 2 = ya existe
    public static int register(Context ctx, String email, String user, String pass) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(user) || TextUtils.isEmpty(pass)) return 1;

        SharedPreferences sp = ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE);

        if (sp.contains(keyPass(user))) return 2;

        sp.edit()
                .putString(keyEmail(user), email)
                .putString(keyPass(user), pass)
                .apply();

        // ✅ opcional: al registrar lo deja logueado
        SessionManager.setLoggedUser(ctx, user);
        return 0;
    }

    public static String getEmail(Context ctx, String user) {
        SharedPreferences sp = ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        return sp.getString(keyEmail(user), "");
    }
}
