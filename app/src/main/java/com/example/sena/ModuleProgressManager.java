package com.example.sena;

import android.content.Context;
import android.content.SharedPreferences;

public class ModuleProgressManager {

    private static final String PREF = "SENA_MODULE_PROGRESS";

    private static String pref(Context ctx, String key) {
        return SessionManager.userPrefix(ctx) + key;
    }

    public static void markSeen(Context ctx, String moduleKey, String itemId) {
        SharedPreferences sp = ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        sp.edit().putBoolean(pref(ctx, moduleKey + "_seen_" + itemId), true).apply();
    }

    public static boolean isSeen(Context ctx, String moduleKey, String itemId) {
        SharedPreferences sp = ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        return sp.getBoolean(pref(ctx, moduleKey + "_seen_" + itemId), false);
    }

    public static int getSeenCount(Context ctx, String moduleKey) {
        SharedPreferences sp = ctx.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        String prefix = pref(ctx, moduleKey + "_seen_");

        int count = 0;
        for (String k : sp.getAll().keySet()) {
            if (k.startsWith(prefix) && sp.getBoolean(k, false)) count++;
        }
        return count;
    }

    public static boolean isModuleCompleted(Context ctx, String moduleKey) {
        int seen = getSeenCount(ctx, moduleKey);
        int total = ModuleStructure.getTotalItemsForModule(moduleKey);
        return total > 0 && seen >= total;
    }
}
