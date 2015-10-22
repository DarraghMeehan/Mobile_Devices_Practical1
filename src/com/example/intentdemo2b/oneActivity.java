package com.example.intentdemo2b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class oneActivity extends Activity implements OnClickListener{
    EditText dataReceived;
    Button  btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        dataReceived = (EditText) findViewById(R.id.etDataReceived);
        btnDone = (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(this);

        // pick call made to twoActivity via Intent
        Intent myLocalIntent = getIntent();

        // look into the bundle sent to twoActivity for data items
        Bundle myBundle =  myLocalIntent.getExtras();
        int v1 = myBundle.getInt("val1");
        int v2 = myBundle.getInt("val2");
        int v3 = myBundle.getInt("val3");
        int v4 = myBundle.getInt("val4");
        int v5 = myBundle.getInt("val5");

        // operate on the input data
        // Checking for MAX value
        int myMax = v1;
        if(v2>myMax){
            myMax=v2;
        }
        if(v3>myMax){
            myMax=v3;
        }
        if(v4>myMax){
            myMax=v4;
        }
        if(v5>myMax){
            myMax=v5;
        }

        // Checking for MIN value
        int myMin = v1;
        if(v2<myMin){
            myMin=v2;
        }
        if(v3<myMin){
            myMin=v3;
        }
        if(v4<myMin){
            myMin=v4;
        }
        if(v5<myMin){
            myMin=v5;
        }
        int vResult =  v1 + v2 + v3 + v4 + v5;

        // for illustration purposes. show data received & result
        dataReceived.setText("Data received is \n"
                + "val1= " + v1 + " val2= " + v2 + "\nval3= " + v3 + " val4= " + v4
                + "\nval5= " + v5 + "\n\nresult= " + vResult);

        // add to the bundle the computed result
        myBundle.putDouble("vresult", vResult);
        myBundle.putDouble("max", myMax);
        myBundle.putDouble("min", myMin);

        // attach updated bumble to invoking intent
        myLocalIntent.putExtras(myBundle);

        // return sending an OK signal to calling activity
        setResult(Activity.RESULT_OK, myLocalIntent);

    }//onCreate

    @Override
    public void onClick(View v) {
        // close current screen - terminate twoActivity
        finish();
    }

}
