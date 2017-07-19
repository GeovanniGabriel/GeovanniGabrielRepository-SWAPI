package com.geovanni.starwars.app.Bussiness.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.geovanni.starwars.app.R;

/**
 * Created by gabri on 18/07/2017.
 */

public class Alerts {

    public static void showToast(Context context, String message, int duration) {
        Toast.makeText(context, message, duration).show();
    }

    private static void showAlert(Context context, String title, String message,
                                  String acceptButtonText, final AlertDialogInterface callback) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialogLightStyle);

        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(acceptButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                        if (callback != null) {
                            callback.onAccept();
                        }
                    }
                }).create().show();
    }

    public static void showAlertMessage(Context context, String message) {
        showAlert(context, context.getString(R.string.alert_title_default), message, context.getString(R.string.alert_accept), null);
    }

    public static void showAlertMessage(Context context, String message, final AlertDialogInterface callback) {
        showAlert(context, context.getString(R.string.alert_title_default), message, context.getString(R.string.alert_accept), callback);
    }

    public static void showAlertMessage(Context context, String title, String message) {
        showAlert(context, title, message, context.getString(R.string.alert_accept), null);
    }

    public interface AlertDialogInterface {
        void onAccept();
    }
}
