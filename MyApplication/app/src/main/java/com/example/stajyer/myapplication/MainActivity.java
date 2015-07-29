package com.example.stajyer.myapplication;

import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private ActionBar actionBar;
    private DrawerLayout drawerLayout;
    private ListView navlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        navlist = (ListView)findViewById(R.id.navList);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.opendrawer,R.string.closedrawer);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);


        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        else if (id == android.R.id.home){
            if(drawerLayout.isDrawerOpen(navlist)){
                drawerLayout.closeDrawer(navlist);
            }
            else
                drawerLayout.openDrawer(navlist);
        }

        return super.onOptionsItemSelected(item);
    }
}
