package com.devcamp.yapp.db;

import android.app.ActionBar;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.devcamp.yapp.db.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private final int DYNAMIC_VIEW_ID = 0x8000;
    private LinearLayout dynamicLayout;
    private int numLayout = 0;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

    MenuItem maker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, splash.class));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       dynamicLayout = (LinearLayout)findViewById(R.id.dynamicArea);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addPrevLayout();

                }
            });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }


    private void addPrevLayout(){
        numLayout++;

        final FrameLayout dynamicFrame = new FrameLayout(this);
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final FrameLayout finalFrame = (FrameLayout) inflater.inflate(R.layout.preview_home, dynamicFrame);

        finalFrame.setId(DYNAMIC_VIEW_ID + numLayout);
        finalFrame.getBackground();
        finalFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"저장된 파일 터치",Toast.LENGTH_LONG).show();
//                finalFrame.getId()
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });

        dynamicLayout.addView(finalFrame,
                new LinearLayout.LayoutParams(350, 350));
    }



    @Override
    public void onBackPressed () {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            } else {
            super.onBackPressed();
        }
    }

            @Override
            public boolean onCreateOptionsMenu (Menu menu){
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.main_activity2, menu);
                return true;
            }

            @Override
            public boolean onOptionsItemSelected (MenuItem item){
                // Handle action bar item clicks here. The action bar will
                // automatically handle clicks on the Home/Up button, so long
                // as you specify a parent activity in AndroidManifest.xml.
                int id = item.getItemId();

                //noinspection SimplifiableIfStatement
                if (id == R.id.action_settings) {
                    Toast.makeText(getApplicationContext(),"세팅 클릭",Toast.LENGTH_LONG).show();
                    return true;
                }

                return super.onOptionsItemSelected(item);
            }

            @SuppressWarnings("StatementWithEmptyBody")
            @Override
            public boolean onNavigationItemSelected (MenuItem item){
                // Handle navigation view item clicks here.
                int id = item.getItemId();

                if (id == R.id.nav_camera) {
                    // Handle the camera action
                    Toast.makeText(getApplication(), "만든 사람 클릭", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),people.class);
                    startActivity(intent);
                } else if (id == R.id.nav_gallery) {

                } else if (id == R.id.nav_slideshow) {

                } else if (id == R.id.nav_manage) {

                } else if (id == R.id.nav_share) {

                } else if (id == R.id.nav_send) {

                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }

        }
