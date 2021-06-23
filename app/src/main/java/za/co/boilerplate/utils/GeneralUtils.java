package za.co.boilerplate.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import za.co.boilerplate.BuildConfig;

public class GeneralUtils {
    public static void makeToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void openAppSettingsScreen(Context context) {
        Intent settingsIntent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + BuildConfig.APPLICATION_ID));
        settingsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(settingsIntent);
    }
}
