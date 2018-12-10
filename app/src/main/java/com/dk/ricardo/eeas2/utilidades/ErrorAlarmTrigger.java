package com.dk.ricardo.eeas2.utilidades;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.dk.ricardo.eeas2.fragments.SingleFragments.LoginFragment;

public class ErrorAlarmTrigger extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences error;
        SharedPreferences.Editor editor1;
        error = PreferenceManager.getDefaultSharedPreferences(context);
        editor1 = error.edit();
        editor1.putInt("error", 0);
        editor1.commit();
    }
}
