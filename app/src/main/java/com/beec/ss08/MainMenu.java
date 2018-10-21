package com.beec.ss08;



import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.beec.ss08.Maps.FindLocationList;
import com.google.firebase.auth.FirebaseAuth;



public class MainMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FirebaseAuth mAuth;
    private TextView tvHeaderName;
    String uE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main_menu);
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        View header = navigationView.getHeaderView(0);
        TextView text = (TextView) header.findViewById(R.id.textView);

         text.setText("test");
        uE =EmailPasswordActivity.mAuth.getCurrentUser().getEmail().toString() + "";
             text.setText(uE);



        navigationView.setNavigationItemSelectedListener(this);

        //tvHeaderName= (TextView) navigationView.findViewById(R.id.textView);
        //tvHeaderName.setText("qsf");

        mAuth = FirebaseAuth.getInstance();

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction ft =  getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.replace(R.id.flContent, homeFragment).addToBackStack(HomeFragment.TAG).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.main_menu, menu);

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
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (id == R.id.nav_home) {

            HomeFragment homeFragment = new HomeFragment();
            transaction.replace(R.id.flContent, homeFragment).addToBackStack(null).commit();

        }else if (id == R.id.nav_check_list) {

            TodoFragment todoFragment = new TodoFragment();
            transaction.replace(R.id.flContent, todoFragment).addToBackStack(HomeFragment.TAG).commit();

        } else if (id == R.id.nav_todo) {
            InstructionFragment instructionFragment = new InstructionFragment();
            transaction.replace(R.id.flContent, instructionFragment).addToBackStack(HomeFragment.TAG).commit();

        } else if (id == R.id.nav_find_location) {

            FindLocationList findLocationList = new FindLocationList();
             transaction.replace(R.id.flContent, findLocationList).addToBackStack(HomeFragment.TAG).commit();

        } else if (id == R.id.nav_host) {
           OpenHomeFragment openHomeFragment = new OpenHomeFragment();
           transaction.replace(R.id.flContent, openHomeFragment).addToBackStack(HomeFragment.TAG).commit();

        } else if (id == R.id.nav_edit_profile) {

            EditProfFragment editProfFragment = new EditProfFragment();
            transaction.replace(R.id.flContent, editProfFragment).addToBackStack(HomeFragment.TAG).commit();

        } else if (id == R.id.nav_logout) {
            mAuth.signOut();
            Intent intent = new Intent(this, EmailPasswordActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
