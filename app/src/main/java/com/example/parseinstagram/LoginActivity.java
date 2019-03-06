package com.example.parseinstagram;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.parseinstagram.fragments.ComposeFragment;
import com.example.parseinstagram.fragments.PostsFragment;
import com.example.parseinstagram.fragments.ProfileFragment;

public class LoginActivity extends AppCompatActivity {

    public final String TAG = "LoginActivity";


    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final FragmentManager fragmentManager = getSupportFragmentManager();

        bottomNavigationView = findViewById(R.id.bottom_navigation);



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = new ComposeFragment();
                switch (item.getItemId()) {
                    case R.id.action_home:
                        //Todo:swap fragment here
                        fragment = new PostsFragment();
                    //    Toast.makeText(LoginActivity.this, "Home!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_compose:
                        fragment = new ComposeFragment();
                     //   Toast.makeText(LoginActivity.this, "Write something and take a Pic", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_profile:
                    default:
                        //Todo:swap fragment here
                        fragment = new ProfileFragment();
                     //   Toast.makeText(LoginActivity.this, "You're Profile", Toast.LENGTH_SHORT).show();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });

// Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }


}
