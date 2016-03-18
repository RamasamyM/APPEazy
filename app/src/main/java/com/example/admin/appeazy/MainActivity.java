package com.example.admin.appeazy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final String PREFS_NAME = "sharedpref";
    TextView textView1,textView2;
    EditText editText1,editText2;
    CheckBox checkBox;
    TextView textView3;
    SharedPreferences preferences;
    private static Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1= (TextView)findViewById(R.id.textView1);
        textView2= (TextView)findViewById(R.id.textView2);
        textView3= (TextView)findViewById(R.id.balance);
        editText1= (EditText)findViewById(R.id.userName);
        editText2= (EditText)findViewById(R.id.userPassword);
        login= (Button)findViewById(R.id.login);



            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    preferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", editText1.getText().toString());
                    editor.putString("password", editText2.getText().toString());
                    editor.putString("balance update",textView3.getText().toString());
                    editor.putString("logged", "logged");
                    editor.commit();
                    editText1.setText("");
                    editText2.setText("");
                    Toast.makeText(MainActivity.this, "saved data", Toast.LENGTH_SHORT).show();
                }
            });
    }

    private void Reset()
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();

    }



}
