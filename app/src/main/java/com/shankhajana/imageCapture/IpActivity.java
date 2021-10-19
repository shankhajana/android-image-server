package com.shankhajana.imageCapture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IpActivity extends AppCompatActivity {
    EditText edit_Ip;
    Button buttonSubmitIp;
    public static final String MyPREFERENCES = "ServerIpPrefs" ;

    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip);
       SharedPreferences sh = getSharedPreferences(Util.MyPREFERENCES, MODE_PRIVATE);

        Boolean isFirstRun = sh.getBoolean(Util.IS_FIRST_RUN, true);
        Log.e("Is first run ? ",""+isFirstRun);
        if(isFirstRun==false){
            openMainActivity();

        }
        edit_Ip=findViewById(R.id.editTextServerIp);
        //String enteredValue= edit_Ip.getText().toString();
        buttonSubmitIp=findViewById(R.id.button_submit_ip);
        buttonSubmitIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //saving the server ip address to shared preferences

                String enteredValue= edit_Ip.getText().toString();
                Log.e("Entered value",""+enteredValue);


                openMainActivity();

                //validating if this is a valid ip address
                if(Patterns.IP_ADDRESS.matcher(enteredValue).matches()){
                    Toast.makeText(IpActivity.this, "Valid IP address !", Toast.LENGTH_SHORT).show();
                    sharedpreferences = getSharedPreferences(MyPREFERENCES,
                            Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString(Util.IP, enteredValue);
                    editor.putBoolean(Util.IS_FIRST_RUN,false);
                    editor.commit();
                    openMainActivity();

                }
                else{

                    Toast.makeText(IpActivity.this, "Invalid  IP address !", Toast.LENGTH_SHORT).show();
                }


                //reading the stored value
                SharedPreferences sh = getSharedPreferences(Util.MyPREFERENCES, MODE_PRIVATE);
                String enteredIp=sh.getString(Util.IP,"");


            }
        });


    }
    public void openMainActivity(){
        Intent openMainActivity = new Intent(IpActivity.this,MainActivity.class);
        startActivity(openMainActivity);
    }
}