package com.example.shunyatsukada.memo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    boolean isFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref= getSharedPreferences("スマホ", Context.MODE_PRIVATE);
        boolean data = pref.getBoolean("key_tutorial", false);


        isFirst = data;


        if (!isFirst) {
            Intent intent = new Intent(this, Setumei.class);
            startActivity(intent);
        }
    }

    public void memo(View v) {


        Intent intent = new Intent(this, MemoActivity.class);
        startActivity(intent);
    }

    public void setumeii(View v) {

        Intent intent = new Intent(this, Setumei.class);
        startActivity(intent);
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

        return super.onOptionsItemSelected(item);
    }
}
