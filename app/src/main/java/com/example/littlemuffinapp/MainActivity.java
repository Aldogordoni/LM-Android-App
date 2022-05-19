package com.example.littlemuffinapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    Menu menu;
    TextView textView;

    public int prevVal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);


        navigationView.bringToFront();
        navigationView.setItemIconTintList(null);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_closed);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        Button mainButton = (Button) findViewById(R.id.mainButton);
        TextView outputText = (TextView) findViewById(R.id.outputText);

        String[] msgArray = new String[220];

        int max = 5;
        int min = 1;

        int x = (int) (Math.random() * 10000000) % max + min;

        msgArray[0] = "Test 1";
        msgArray[1] = "Test 2";
        msgArray[2] = "Test 3";
        msgArray[3] = "Test 4";
        msgArray[4] = "Test 5";

        prevVal = x;

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int x = (int) (Math.random() * 10000000) % max + min;
                while (prevVal == x){
                    x = (int) (Math.random() * 10000000) % max + min;
                }
                prevVal = x;
                outputText.setText(msgArray[x]);
            }
        });
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.snapchat_logo:

                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://snapchat.com/add/aldogordonii"));
                    intent.setPackage("com.snapchat.android");
                    startActivity(intent);
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://snapchat.com/add/aldogordonii")));
                }

                /*Intent intentSnapchat = getPackageManager().getLaunchIntentForPackage("com.snapchat.android");

                if(intentSnapchat != null){
                    startActivity(intentSnapchat);
                } else {
                    Toast.makeText(MainActivity.this, "Snapchat not found",Toast.LENGTH_LONG).show();
                }*/


                break;
            case R.id.instagram_app:

                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/aldo_gordoni"));
                    intent.setPackage("com.instagram.android");
                    startActivity(intent);
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/aldo_gordoni")));
                }


               /* Intent intentInstagram = new Intent(getPackageManager().getLaunchIntentForPackage("com.instagram.android")) ;
                if(intentInstagram != null){
                    startActivity(intentInstagram);
                } else {
                    Toast.makeText(MainActivity.this, "Instagram not found",Toast.LENGTH_LONG).show();
                }*/


                break;
            case R.id.whatsapp_app:

                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=+44"));
                    intent.setPackage("com.whatsapp");
                    startActivity(intent);
                } catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=+44")));
                }

                /*
                Intent intentWhatsapp = new Intent(getPackageManager().getLaunchIntentForPackage("com.whatsapp"));
                if(intentWhatsapp != null){
                    startActivity(intentWhatsapp);
                } else {
                    Toast.makeText(MainActivity.this, "Whatsapp not found",Toast.LENGTH_LONG).show();
                }*/


                break;

            case R.id.call_boo:
                Uri number = Uri.parse("tel:+44");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

                startActivity(callIntent);

                break;
            case R.id.send_boo_text:
                String message = "Hey ";
                Intent sendIntent = new Intent(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                sendIntent.setType("text/plain");

                Intent chooser = Intent.createChooser(sendIntent, "Send to ");

                if(chooser != null){
                    startActivity(chooser);
                } else {
                    Toast.makeText(MainActivity.this, "Share function not enabled in the app",Toast.LENGTH_LONG).show();
                }


                break;
            case R.id.adventure_book:
                Intent intent = new Intent(MainActivity.this, AdventureBookActivity.class);
                startActivity(intent);
                break;
            case R.id.boo_reflections:
                intent = new Intent(MainActivity.this, BooReflections.class);
                startActivity(intent);
                break;
            case R.id.cat_gifs:
                intent = new Intent(MainActivity.this, GifGeneratorActivity.class);
                startActivity(intent);
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

   /* public void shareFunction(View view){
        String message = "Hey boo";
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);
        sendIntent.setType("text/plain");

        Intent chooser = Intent.createChooser(sendIntent, "Send to Boo");
            startActivity(chooser);
    }*/

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer((GravityCompat.START));
        } else {
            super.onBackPressed();
        }
    }



}


