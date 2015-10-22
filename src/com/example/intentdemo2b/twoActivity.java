package com.example.intentdemo2b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class twoActivity extends Activity implements OnClickListener{
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

		double[] paramArray = myBundle.getDoubleArray("myArray1");

		// Chack to see if number in all locations
		//for(int i=0; i<paramArray.length; i++){
			//if (paramArray[i]>=0) {
				//continue;
			//}
			//paramArray[i]=0;
		//}

		// Pass Array to functions to check for Max/Min
		Double myMax = myMaxArray(paramArray);
		Double myMin = myMinArray(paramArray);

		// operate on the input data
		Double vResult =  paramArray[0] + paramArray[1] + paramArray[2] + paramArray[3] + paramArray[4];
		
		// for illustration purposes. show data received & result
		dataReceived.setText("Data received is \n"
				+ "val1= " + paramArray[0] + " val2= " + paramArray[1] + "\nval3= " + paramArray[2] +
				" val4= " + paramArray[3] + "\nval5= " + paramArray[4] + "\n\nresult= " + vResult);
		
		// add to the bundle the computed result  
		myBundle.putDouble("vresult", vResult);
		myBundle.putDouble("max", myMax);
		myBundle.putDouble("min", myMin);
		
		// attach updated bumble to invoking intent
		myLocalIntent.putExtras(myBundle);
		
		// return sending an OK signal to calling activity
		setResult(Activity.RESULT_OK, myLocalIntent);
	
	}//onCreate

	// Checking for the MAX value
	private Double myMaxArray(double[] theArray) {

		Double myMax = theArray[0];
		if(theArray[1]>myMax){
			myMax=theArray[1];
		}
		if(theArray[2]>myMax){
			myMax=theArray[2];
		}
		if(theArray[3]>myMax){
			myMax=theArray[3];
		}
		if(theArray[4]>myMax){
			myMax=theArray[4];
		}
		return myMax;
	}

	//Checking for the MIN value
	private Double myMinArray(double[] theArray) {

		Double myMin = theArray[0];
		if(theArray[1]<myMin){
			myMin=theArray[1];
		}
		if(theArray[2]<myMin){
			myMin=theArray[2];
		}
		if(theArray[3]<myMin){
			myMin=theArray[3];
		}
		if(theArray[4]<myMin){
			myMin=theArray[4];
		}
		return myMin;
	}

	@Override
	public void onClick(View v) {
		    // close current screen - terminate twoActivity
			finish();
	}
}
