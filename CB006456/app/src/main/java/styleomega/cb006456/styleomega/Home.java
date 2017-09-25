package styleomega.cb006456.styleomega;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private String EmailHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        EmailHolder = getIntent().getStringExtra("email");
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {


            // Opening activity using intent on button click.
            Intent intent = new Intent(this, Home.class);
            intent.putExtra("email", EmailHolder);
            startActivity(intent);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_store) {
            Store_Fragment fragment =  new Store_Fragment();
            Bundle bun = new Bundle();
            bun.putString("emailholder", EmailHolder);
            fragment.setArguments(bun);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , fragment)
                    .commit();
        } else if (id == R.id.nav_contact) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new Contact_Fragment())
                    .commit();

        } else if (id == R.id.nav_cart) {
            Cart_Fragment fragment = new Cart_Fragment();
            Bundle bun =  new Bundle();
            bun.putString("emailholder", EmailHolder);
            fragment.setArguments(bun);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , fragment)
                    .commit();
        } else if (id == R.id.nav_share) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new Share_Fragment())
                    .commit();

        } else if (id == R.id.manageacc) {
            ManageAcc_Fragment fragment =  new ManageAcc_Fragment();

            Bundle args = new Bundle();
            args.putString("email",EmailHolder);
            fragment.setArguments(args);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , fragment)
                    .commit();

        } else if (id == R.id.logout) {

            finishAffinity();
            startActivity(new Intent(this, Login.class));
            //Finishing current DashBoard activity on button click.



        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


