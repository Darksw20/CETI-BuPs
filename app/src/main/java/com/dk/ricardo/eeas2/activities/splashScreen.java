package com.dk.ricardo.eeas2.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dk.ricardo.eeas2.R;
import com.dk.ricardo.eeas2.fragments.LoginFragment;
import com.dk.ricardo.eeas2.interfaces.NavigationHost;

public class splashScreen extends AppCompatActivity implements NavigationHost
{

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final View decorView=getWindow().getDecorView();
        final int uiOptions=View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                if (savedInstanceState == null)
                {

                    getSupportFragmentManager().beginTransaction().add(R.id.containerLogin, new LoginFragment()).commitAllowingStateLoss();
                    final int uiOptions2=View.SYSTEM_UI_FLAG_VISIBLE;
                    decorView.setSystemUiVisibility(uiOptions2);

                }
            }
        }, 2000);

       // Intent inicio = new Intent(getApplicationContext(), MainActivity.class);
       // startActivity(inicio);

    }
/*
    @Override
    protected void onPause()
    {
        super.onPause();
        finish();
    }
*/
    @Override
    public void navigateTo(Fragment fragment, boolean addToBackstack) {
        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.containerLogin, fragment);
        if (addToBackstack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
