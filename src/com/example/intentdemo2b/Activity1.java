package com.example.intentdemo2b;
// Multi-Activity Application
// Darragh Meehan
// Mobile Device Programming
// Exam 1

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity1 extends Activity {
    EditText txtValue1;
    EditText txtValue2;
	EditText txtValue3;
	EditText txtValue4;
	EditText txtValue5;
    TextView txtResult;
	TextView txtMax;
	TextView txtMin;
	Button btnCal;
    Button btnCal1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);
        txtValue1 = (EditText)findViewById(R.id.EditText01);
        txtValue2 = (EditText)findViewById(R.id.EditText02);
		txtValue3 = (EditText)findViewById(R.id.EditText03);
		txtValue4 = (EditText)findViewById(R.id.EditText04);
		txtValue5 = (EditText)findViewById(R.id.EditText05);
        txtResult = (TextView) findViewById(R.id.txtResult);
		txtMax = (TextView) findViewById(R.id.txtMax);
		txtMin = (TextView) findViewById(R.id.txtMin);

		btnCal = (Button) findViewById(R.id.btnCal);
		btnCal.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Values used in first calculation
				int v1 = 500;
				int v2 = 420;
				int v3 = 520;
				int v4 = 75;
				int v5 = 85;

				// create intent to call twoActivity
				Intent myIntentA1A2 = new Intent (Activity1.this,
						oneActivity.class);
				// create a Bundle (MAP) container to ship data
				Bundle myDataBundle = new Bundle();

				// add <key,value> data items to the container
				myDataBundle.putInt("val1", v1);
				myDataBundle.putInt("val2", v2);
				myDataBundle.putInt("val3", v3);
				myDataBundle.putInt("val4", v4);
				myDataBundle.putInt("val5", v5);

				// attach the container to the intent
				myIntentA1A2.putExtras(myDataBundle);

				// call twoActivity, tell your local listener to wait a
				// response sent to a listener known as 101
				startActivityForResult(myIntentA1A2, 101);
			}
		});

		btnCal1 = (Button) findViewById(R.id.btnCal1);
		btnCal1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// get values from the UI
				Double v1 = Double.parseDouble(txtValue1.getText().toString());
				Double v2 = Double.parseDouble(txtValue2.getText().toString());
				Double v3 = Double.parseDouble(txtValue3.getText().toString());
				Double v4 = Double.parseDouble(txtValue4.getText().toString());
				Double v5 = Double.parseDouble(txtValue5.getText().toString());

				// create a Bundle (MAP) container to ship data
				Bundle myData = new Bundle();
				double [] myArray = {v1,v2,v3,v4,v5};
				myData.putDoubleArray("myArray1", myArray);

				// create intent to call twoActivity
				Intent myIntentA1A2 = new Intent (Activity1.this,
						twoActivity.class);

				// attach the container to the intent
				myIntentA1A2.putExtras(myData);

				// call twoActivity, tell your local listener to wait a
				// response sent to a listener known as 101
				startActivityForResult(myIntentA1A2, 101);
			}
		});
	}//onCreate

    //////////////////////////////////////////////////////////////////////////////
    // local listener receives callbacks from other activities
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		try	{
			if ((requestCode == 101 ) && (resultCode == Activity.RESULT_OK)){
				Bundle myResultBundle = data.getExtras();
				Double myResult = myResultBundle.getDouble("vresult");
				Double myMax = myResultBundle.getDouble("max");
				Double myMin = myResultBundle.getDouble("min");
				txtResult.setText("Sum is " + myResult);
				txtMax.setText("Max value is " + myMax);
				txtMin.setText("Min value is " + myMin);
			}
		}
		catch (Exception e) {
			txtResult.setText("Problems - " + requestCode + " " + resultCode);
		}
	}//onActivityResult
}//Activity1