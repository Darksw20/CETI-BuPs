package com.dk.ricardo.eeas2.activities;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.dk.ricardo.eeas2.DBase.ConexionSQLiteHelper;
import com.dk.ricardo.eeas2.JavaBeans.Entidades.UserSingleton;
import com.dk.ricardo.eeas2.R;
import com.dk.ricardo.eeas2.fragments.Comunication.ComunicationFragment;
import com.dk.ricardo.eeas2.fragments.Contacts.ContactsFragment;
import com.dk.ricardo.eeas2.fragments.ContestGestor.ContestGestorFragment;
import com.dk.ricardo.eeas2.fragments.ControlPanel.ControlFragment;
import com.dk.ricardo.eeas2.fragments.EmergencyNumbers.EmergencyNumbsFragment;
import com.dk.ricardo.eeas2.fragments.Dashboard.DashFragment;
import com.dk.ricardo.eeas2.fragments.SingleFragments.GanttChartFragment;
import com.dk.ricardo.eeas2.fragments.GeoLocation.GeoLocationFragment;
import com.dk.ricardo.eeas2.fragments.SingleFragments.LocalizationFragment;
import com.dk.ricardo.eeas2.fragments.Maps.MapUserLocationFragment;
import com.dk.ricardo.eeas2.fragments.MedicFiles.MedicFileFragment;
import com.dk.ricardo.eeas2.fragments.Options.OptionsFragment;
import com.dk.ricardo.eeas2.fragments.SingleFragments.QRImageFragment;
import com.dk.ricardo.eeas2.fragments.Schedule.SchedFragment;
import com.dk.ricardo.eeas2.fragments.Toolbox.ToolboxFragment;
import com.dk.ricardo.eeas2.fragments.WorkShGestor.WorkShGestorFragment;
import com.dk.ricardo.eeas2.interfaces.NavigationHost;
import com.dk.ricardo.eeas2.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        NavigationHost
{
    TextView texrName, textCharge;
    ConexionSQLiteHelper con;
    SQLiteDatabase db;
    String string;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //TODO: REVISAR QUE HAYA INTERNET CUANDO SE USE EL SINGLETON
        UserSingleton.getInstance().cargarWebService(this);
        delay();
        switch (UserSingleton.getInstance().getTipoUser())
        {
            case 1:
                setContentView(R.layout.activity_main_dba);
                break;
            case 2:
                setContentView(R.layout.activity_main_org);
                break;
            case 3:
                setContentView(R.layout.activity_main_sm);
                break;
            case 4:
                setContentView(R.layout.activity_main_tallerista);
                break;
            case 5:
                setContentView(R.layout.activity_main_juez);
                break;
            case 6:
                setContentView(R.layout.activity_main_participante);
                break;
            case 7:
                setContentView(R.layout.activity_main_sr);
                break;
            case 8:
                setContentView(R.layout.activity_main_staff);
                break;
            default:
                setContentView(R.layout.activity_main_off);
                break;
        }
        android.support.v7.widget.Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO: Agregar funciones de la base de datos(osea que jale)
        //Este switch es para crear la base de datos
        switch (UserSingleton.getInstance().getTipoUser())
        {
            case 1:
                drawer = findViewById(R.id.drawer_layout_dba);
                break;
            case 2:
                drawer = findViewById(R.id.drawer_layout_org);
                break;
            case 3:
                drawer = findViewById(R.id.drawer_layout_sm);
                break;
            case 4:
                drawer = findViewById(R.id.drawer_layout_tallerista);
                break;
            case 5:
                drawer = findViewById(R.id.drawer_layout_juez);
                break;
            case 6:
                drawer = findViewById(R.id.drawer_layout_participante);
                break;
            case 7:
                drawer = findViewById(R.id.drawer_layout_sr);
                break;
            case 8:
                drawer = findViewById(R.id.drawer_layout_staff);
                break;
            default:
                drawer = findViewById(R.id.drawer_layout_off);
                break;
        }
        iniciarBD();
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        navigationView = findViewById(R.id.nav_view);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        /*
        * Este if sirve para poder mantener los datos aun cuando se cambie la vista de lugar
        *En realidad te manda al fragment de inicio
        * */
        if (savedInstanceState == null)
        {
            switch (UserSingleton.getInstance().getTipoUser())
            {
                case 1:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.container, new DashFragment())
                            .commit();

                    break;
                case 2:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.container, new DashFragment())
                            .commit();
                    break;
                case 3:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.container, new MedicFileFragment())
                            .commit();
                    break;
                case 4:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.container, new WorkShGestorFragment())
                            .commit();
                    break;
                case 5:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.container, new ContestGestorFragment())
                            .commit();
                    break;
                case 6:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.container, new DashFragment())
                            .commit();
                    break;
                case 7:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.container, new MedicFileFragment())
                            .commit();
                    break;
                case 8:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.container, new DashFragment())
                            .commit();
                    break;
                default:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.container, new GanttChartFragment())
                            .commit();
                    break;
            }

        }
    }
    @Override
    public void onBackPressed()
    {
        //TODO: Agregar que se revise el estado de internet
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
        texrName= findViewById(R.id.textName);
        textCharge= findViewById(R.id.textCharge);
        if(UserSingleton.getInstance().getNombre()==null)
        {
            texrName.setText("No hay internet disponible");
            textCharge.setText("Cerrar sesion");
            try
            {
                Log.e("Error de internet",""+UserSingleton.getInstance().getNombre());
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            switch (UserSingleton.getInstance().getTipoUser())
            {
                case 1:
                    string=""+getString(R.string.Bienvenida)+" "+(UserSingleton.getInstance().getNombre());
                    texrName.setText(string);
                    textCharge.setText(R.string.User1);
                    break;
                case 2:
                    string=""+getString(R.string.Bienvenida)+" "+(UserSingleton.getInstance().getNombre());
                    texrName.setText(string);
                    textCharge.setText(R.string.User2);
                    break;
                case 3:
                    string=""+getString(R.string.Bienvenida)+" "+(UserSingleton.getInstance().getNombre());
                    texrName.setText(string);
                    textCharge.setText(R.string.User3);
                    break;
                case 4:
                    string=""+getString(R.string.Bienvenida)+" "+(UserSingleton.getInstance().getNombre());
                    texrName.setText(string);
                    textCharge.setText(R.string.User4);
                    break;
                case 5:
                    string=""+getString(R.string.Bienvenida)+" "+(UserSingleton.getInstance().getNombre());
                    texrName.setText(string);
                    textCharge.setText(R.string.User5);
                    break;
                case 6:
                    string=""+getString(R.string.Bienvenida)+" "+(UserSingleton.getInstance().getNombre());
                    texrName.setText(string);
                    textCharge.setText(R.string.User6);
                    break;
                case 7:
                    string=""+getString(R.string.Bienvenida)+" "+(UserSingleton.getInstance().getNombre());
                    texrName.setText(string);
                    textCharge.setText(R.string.User7);
                    break;
                case 8:
                    string=""+getString(R.string.Bienvenida)+" "+(UserSingleton.getInstance().getNombre());
                    texrName.setText(string);
                    textCharge.setText(R.string.User8);
                    break;
                default:
                    texrName.setText("Cerrar sesion");
                    textCharge.setText("Por Favor");
                    break;
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Aqui se revisa que pedo con las opciones del
        //Action bar

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
        DrawerLayout drawer;
        switch (UserSingleton.getInstance().getTipoUser())
        {
            case 1:
                drawer = findViewById(R.id.drawer_layout_dba);
                break;
            case 2:
                drawer = findViewById(R.id.drawer_layout_org);
                break;
            case 3:
                drawer = findViewById(R.id.drawer_layout_sm);
                break;
            case 4:
                drawer = findViewById(R.id.drawer_layout_tallerista);
                break;
            case 5:
                drawer = findViewById(R.id.drawer_layout_juez);
                break;
            case 6:
                drawer = findViewById(R.id.drawer_layout_participante);
                break;
            case 7:
                drawer = findViewById(R.id.drawer_layout_sr);
                break;
            case 8:
                drawer = findViewById(R.id.drawer_layout_staff);
                break;
            default:
                drawer = findViewById(R.id.drawer_layout_off);
                break;
        }
        switch (id)
        {
            case R.id.itDbaDash:
                //case R.id.itOrgDash:
                //case R.id.itSMDash:
                //case R.id.itTallerDash:
                //case R.id.itJuezDash:
            case R.id.itPartDash:
            case R.id.itSRDash:
            case R.id.itStaffDash:

                Toast.makeText(getApplicationContext(),"Dashboard",Toast.LENGTH_LONG).show();
                navigateTo(new DashFragment(),true);
                break;
            case R.id.itDbaContacts:
            case R.id.itOrgContacts:
            case R.id.itSMContacts:
            case R.id.itTallerContacts:
            case R.id.itJuezContacts:
            case R.id.itPartContacts:
            case R.id.itSRContacts:
            case R.id.itStaffContacts:

                Toast.makeText(getApplicationContext(),"Contactos",Toast.LENGTH_LONG).show();
                navigateTo(new ContactsFragment(),true);
                break;
            case R.id.itDbaControl:
            case R.id.itOrgControl:
            case R.id.itSMControl:
            case R.id.itTallerControl:
            case R.id.itJuezControl:
                //case R.id.itPartExit:
                //case R.id.itSRExit:
            case R.id.itStaffControl:

                Toast.makeText(getApplicationContext(),"Panel de Control",Toast.LENGTH_LONG).show();
                navigateTo(new ControlFragment(),true);
                break;
            case R.id.itDbaQR:
            case R.id.itOrgQR:
            case R.id.itSMQR:
            case R.id.itTallerQR:
            case R.id.itJuezQR:
            case R.id.itPartQR:
            case R.id.itSRQR:
            case R.id.itStaffQR:

                Toast.makeText(getApplicationContext(),"Codigo QR",Toast.LENGTH_LONG).show();
                navigateTo(new QRImageFragment(),true);
                break;
            case R.id.itDbaLocalization:
            case R.id.itOrgLocalization:
            case R.id.itSMLocalization:
                //case R.id.itTallerLocalization:
                //case R.id.itJuezLocalization:
                //case R.id.itPartLocalization:
                //case R.id.itSRLocalization:
            case R.id.itStaffLocalization:

                Toast.makeText(getApplicationContext(),"Localizacion",Toast.LENGTH_LONG).show();
                navigateTo(new LocalizationFragment(),true);
                break;
            case R.id.itDbaMaps:
            case R.id.itOrgMaps:
            case R.id.itSMMaps:
            case R.id.itTallerMaps:
            case R.id.itJuezMaps:
            case R.id.itPartMaps:
                //case R.id.itSRMaps:
            case R.id.itStaffMaps:

                Toast.makeText(getApplicationContext(),"Mapas",Toast.LENGTH_LONG).show();
                navigateTo(new MapUserLocationFragment(),true);
                break;
            case R.id.itDbaTool:
            case R.id.itOrgTool:
                //case R.id.itSMExit:
                //case R.id.itTallerExit:
                //case R.id.itJuezExit:
                //case R.id.itPartExit:
                //case R.id.itSRExit:
            case R.id.itStaffTool:

                Toast.makeText(getApplicationContext(),"Caja de herramientas",Toast.LENGTH_LONG).show();
                navigateTo(new ToolboxFragment(),true);
                break;
            case R.id.itDbaGeo:
            case R.id.itOrgGeo:
            case R.id.itSMGeo:
            case R.id.itTallerGeo:
            case R.id.itJuezGeo:
            case R.id.itPartGeo:
            case R.id.itSRGeo:
            case R.id.itStaffGeo:

                Toast.makeText(getApplicationContext(),"Geolocalizacion",Toast.LENGTH_LONG).show();
                navigateTo(new GeoLocationFragment(),true);
                break;
            case R.id.itDbaEmergency:
            case R.id.itOrgEmergency:
            case R.id.itSMEmergency:
            case R.id.itTallerEmergency:
            case R.id.itJuezEmergency:
            case R.id.itPartEmergency:
            case R.id.itSREmergency:
            case R.id.itStaffEmergency:

                Toast.makeText(getApplicationContext(),"Numeros de Emergencia",Toast.LENGTH_LONG).show();
                navigateTo(new EmergencyNumbsFragment(),true);
                break;
            case R.id.itDbaComunication:
            case R.id.itOrgComunication:
            //case R.id.itSMComunication:
            case R.id.itTallerComunication:
            case R.id.itJuezComunication:
            case R.id.itPartComunication:
            case R.id.itSRComunication:
            case R.id.itStaffComunication:
                Toast.makeText(getApplicationContext(),"Comunicacion",Toast.LENGTH_LONG).show();
                navigateTo(new ComunicationFragment(),true);
                break;
            case R.id.itDbaExit:
            case R.id.itOrgExit:
            case R.id.itSMExit:
            case R.id.itTallerExit:
            case R.id.itJuezExit:
            case R.id.itPartiExit:
            case R.id.itSRExit:
            case R.id.itStaffExit:
            case R.id.errorLogin:
                Toast.makeText(getApplicationContext(),"Cerrar sesion",Toast.LENGTH_LONG).show();
                SharedPreferences loggin = getBaseContext().getSharedPreferences("LoginData", MODE_PRIVATE);
                SharedPreferences.Editor editor = loggin.edit();
                editor.clear();
                editor.commit();
                UserSingleton.getInstance().clean();
                this.finish();
                break;
            case R.id.itDbaOptions:
            case R.id.itOrgOptions:
            case R.id.itSMOptions:
            case R.id.itTallerOptions:
            case R.id.itJuezOptions:
            case R.id.itPartOptions:
            case R.id.itSROptions:
            case R.id.itStaffOptions:

                break;
            case R.id.itOrgReport:
                navigateTo(new OptionsFragment(),true);
                break;
            case R.id.itSMMedicalFiles:
            case R.id.itSRMedicalFiles:
                navigateTo(new MedicFileFragment(),true);
                break;
            case R.id.itPartSched:
            case R.id.itSRSched:
                navigateTo(new SchedFragment(),true);
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


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    public void delay()
    {
        //delay 500ms
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
            }
        }, 500);
    }

    public void iniciarBD()
    {
        con=new ConexionSQLiteHelper(this,"bd_usuarios",null,1);
        db=con.getWritableDatabase();
        ContentValues values=new ContentValues();
            values.put(Utilidades.CAMPO_CUM,UserSingleton.getInstance().getCum());
            values.put(Utilidades.CAMPO_NOMBRE,UserSingleton.getInstance().getNombre());
            values.put(Utilidades.CAMPO_APAT,UserSingleton.getInstance().getaPat());
            values.put(Utilidades.CAMPO_AMAT,UserSingleton.getInstance().getaMat());
            values.put(Utilidades.CAMPO_TIPO,UserSingleton.getInstance().getTipoUser());
        db.close();
    }

}
