package com.geovanni.starwars.app.Bussiness.Utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by gabri on 16/07/2017.
 */

public class NavigationUtil {

    public static <T> void openActivity(Context context, Class<T> classTarget) {
        Intent intent = new Intent(context, classTarget);
        context.startActivity(intent);
    }

}
