package com.example.kooperatywalubelska.Administrator;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.kooperatywalubelska.R;
import com.example.kooperatywalubelska.Supplier.SupplierMain;
import com.example.kooperatywalubelska.Supplier.SupplierMainActivity;
import com.example.kooperatywalubelska.User.UserMain;
import com.example.kooperatywalubelska.User.UserEventListActivity;
import com.example.kooperatywalubelska.User.UserMainActivity;
import com.example.kooperatywalubelska.User.UserPersonalInformationActivity;

public class AdministratorMain extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administrator_manu_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragment_container,new AdministratorMainActivity()).commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent i;
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        switch(item.getItemId()) {
            case R.id.nav_main_activity_administrator:
                transaction.replace(R.id.fragment_container,new AdministratorMainActivity());
                transaction.addToBackStack(null);
                transaction.commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_main_activity_user:
                transaction.replace(R.id.fragment_container,new UserMainActivity());
                transaction.addToBackStack(null);
                transaction.commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_product:
                transaction.replace(R.id.fragment_container,new AdministratorProductListActivity());
                transaction.addToBackStack(null);
                transaction.commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_supplier:
                i = new Intent(getApplicationContext(), SupplierMain.class);
                startActivity(i);
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_user:
                i = new Intent(getApplicationContext(), UserMain.class);
                startActivity(i);
                drawer.closeDrawer(GravityCompat.START);
                break;
        }

        return true;
    }

    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}