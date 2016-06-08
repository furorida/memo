package com.example.shunyatsukada.memo;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MemoActivity extends AppCompatActivity {

    EditText titleEditText;
    EditText contentEditText;

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        titleEditText = (EditText) findViewById(R.id.title);
        contentEditText = (EditText) findViewById(R.id.content);

        pref = getSharedPreferences("pref_memo",MODE_PRIVATE);

        titleEditText.setText(pref.getString("key_title", ""));
        contentEditText.setText(pref.getString("key_content",""));
    }

    public void save(View v){

        String titleText = titleEditText.getText().toString();
        String contentText = contentEditText.getText().toString();

        SharedPreferences.Editor editor = pref.edit();
        editor.putString("key_title", titleText);
        editor.putString("key_content", contentText);
        editor.commit();

        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_memo, menu);
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
