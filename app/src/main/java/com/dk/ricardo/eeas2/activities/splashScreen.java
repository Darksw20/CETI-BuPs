package com.dk.ricardo.eeas2.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;

import com.dk.ricardo.eeas2.MainActivity;
import com.dk.ricardo.eeas2.R;

public class splashScreen extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        View decorView=getWindow().getDecorView();
        int uiOptions=View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        /*
            Despues de 2 segundos se entra a la aplicacion
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent intent=new Intent(splashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}
