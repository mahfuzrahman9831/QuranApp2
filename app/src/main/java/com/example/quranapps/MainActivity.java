package com.example.quranapps;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_main);

        bottomNavigationView = findViewById(R.id.bottomBarId);

        if (savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutId,new quran_page()).commit();
        }


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment fragment = null;

                if (menuItem.getItemId()==R.id.quranMenuId){
                    fragment=new quran_page();
                }
                if (menuItem.getItemId()==R.id.doaMenuId){
                    fragment=new doa_page();
                }
                if (menuItem.getItemId()==R.id.hadisMenuId){
                    fragment=new hadis_page();
                }
                if (menuItem.getItemId()==R.id.amolMenuId){
                    fragment=new amol_page();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutId,fragment).commit();

                return false;
            }
        });
    }

    @Override
    public void onBackPressed() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);


        builder.setMessage(R.string.AlertDialog_Message)
                .setCancelable(false);

        builder.setPositiveButton("হ্যাঁ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.setNegativeButton("না", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
