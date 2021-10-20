package com.shankhajana.imageCapture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IpActivity extends AppCompatActivity {
    EditText edit_Ip;
    Button buttonSubmitIp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip);

//        Boolean isFirstRun = AppUtils.isFirstRun(this);
//        Log.e("Is first run ? ",""+isFirstRun);
//        if(isFirstRun==false){
//            openMainActivity();
//        }

        edit_Ip=findViewById(R.id.editTextServerIp);
        buttonSubmitIp=findViewById(R.id.button_submit_ip);

        buttonSubmitIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //saving the server ip address to shared preferences
                String enteredValue= edit_Ip.getText().toString();
                Log.e("Entered value",""+enteredValue);
                if(enteredValue.isEmpty()){
                    Toast.makeText(IpActivity.this, "Enter a valid url !", Toast.LENGTH_SHORT).show();
                    edit_Ip.setError("Server url cannot be empty !");



                }
                else{
                    EndpointUtil.saveBaseURI(IpActivity.this, enteredValue);
                   // AppUtils.setFirstRun(IpActivity.this,false);
                    openMainActivity();
                }


            }
        });


    }
    public void openMainActivity(){
        Intent openMainActivity = new Intent(IpActivity.this,MainActivity.class);
        startActivity(openMainActivity);
    }
}