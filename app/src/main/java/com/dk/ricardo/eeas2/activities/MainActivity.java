package com.dk.ricardo.eeas2.activities;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.dk.ricardo.eeas2.Entidades.UserSingleton;
import com.dk.ricardo.eeas2.R;
import com.dk.ricardo.eeas2.fragments.DashFragment;
import com.dk.ricardo.eeas2.interfaces.NavigationHost;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,NavigationHost
{
    int usuario=3;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        switch (usuario)//UserSingleton.getInstance().getTipoUser())
        {
            case 0:
                setContentView(R.layout.activity_main_dba);
                break;
            case 1:
                setContentView(R.layout.activity_main_org);
                break;
            case 2:
                setContentView(R.layout.activity_main_sm);
                break;
            case 3:
                setContentView(R.layout.activity_main_juez);
                break;
            case 4:
                setContentView(R.layout.activity_main_tallerista);
                break;
            case 5:
                setContentView(R.layout.activity_main_participante);
                break;
            case 6:
                setContentView(R.layout.activity_main_sr);
                break;
            case 7:
                setContentView(R.layout.activity_main_staff);
                break;
            default:
                setContentView(R.layout.activity_main_off);
                break;
        }


        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer;

        switch (usuario)//UserSingleton.getInstance().getTipoUser())
        {
            case 0:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_dba);
                break;
            case 1:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_org);
                break;
            case 2:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_sm);
                break;
            case 3:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_juez);
                break;
            case 4:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_tallerista);
                break;
            case 5:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_participante);
                break;
            case 6:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_sr);
                break;
            case 7:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_staff);
                break;
            default:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_off);
                break;
        }
        /*
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        */
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        /*
        * Este if sirve para poder mantener los datos aun cuando se cambie la vista de lugar
        *
        * */
        if (savedInstanceState == null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new DashFragment())
                    .commit();
        }
    }
    @Override
    public void onBackPressed() {
        ///TODO: cambiar el drawer layout segun el tipo de usuario
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        DrawerLayout drawer;

        switch (usuario)//UserSingleton.getInstance().getTipoUser())
        {
            case 0:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_dba);
                break;
            case 1:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_org);
                break;
            case 2:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_sm);
                break;
            case 3:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_juez);
                break;
            case 4:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_tallerista);
                break;
            case 5:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_participante);
                break;
            case 6:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_sr);
                break;
            case 7:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_staff);
                break;
            default:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_off);
                break;
        }
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dmain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        switch (id)
        {
            case R.id.itDash:
                Toast.makeText(getApplicationContext(),"Dashboard",Toast.LENGTH_LONG).show();
                break;
            case R.id.itContacts:
                Toast.makeText(getApplicationContext(),"Contactos",Toast.LENGTH_LONG).show();
                break;
            case R.id.itControl:
                Toast.makeText(getApplicationContext(),"Panel de Control",Toast.LENGTH_LONG).show();
                break;
            case R.id.itQR:
                Toast.makeText(getApplicationContext(),"Codigo QR",Toast.LENGTH_LONG).show();
                break;
            case R.id.itLocalization:
                Toast.makeText(getApplicationContext(),"Localizacion",Toast.LENGTH_LONG).show();
                break;
            case R.id.itMaps:
                Toast.makeText(getApplicationContext(),"Mapas",Toast.LENGTH_LONG).show();
                break;
            case R.id.itTool:
                Toast.makeText(getApplicationContext(),"Caja de herramientas",Toast.LENGTH_LONG).show();
                break;
            case R.id.itGeo:
                Toast.makeText(getApplicationContext(),"Geolocalizacion",Toast.LENGTH_LONG).show();
                break;
            case R.id.itEmergency:
                Toast.makeText(getApplicationContext(),"Numeros de Emergencia",Toast.LENGTH_LONG).show();
                break;
            case R.id.itComunication:
                Toast.makeText(getApplicationContext(),"Comunicacion",Toast.LENGTH_LONG).show();
                break;

        }

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        DrawerLayout drawer;

        switch (usuario)//UserSingleton.getInstance().getTipoUser())
        {
            case 0:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_dba);
                break;
            case 1:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_org);
                break;
            case 2:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_sm);
                break;
            case 3:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_juez);
                break;
            case 4:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_tallerista);
                break;
            case 5:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_participante);
                break;
            case 6:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_sr);
                break;
            case 7:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_staff);
                break;
            default:
                drawer = (DrawerLayout) findViewById(R.id.drawer_layout_off);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /**
     * Navigate to the given fragment.
     *
     * @param fragment       Fragment to navigate to.
     * @param addToBackstack Whether or not the current fragment should be added to the backstack.
     */
    @Override
    public void navigateTo(Fragment fragment, boolean addToBackstack) {
        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment);

        if (addToBackstack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }

    public void register(View view)
    {

    }
}
