package com.example.dynamicfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init fragment
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame,fragment1)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.fragment1Item :
                if (!fragment1.isVisible()) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frame,fragment1)
                            .addToBackStack(null) // for button BACK
                            .commit();
                }
                return true;
                case R.id.fragment2Item :
                    if (!fragment2.isVisible()) {
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame,fragment2)
                                .addToBackStack(null) // for button BACK
                                .commit();
                    }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void create(MenuItem item) {
        Toast.makeText(this, "Bonjour drawer", Toast.LENGTH_LONG).show();
    }
}