package org.vurtatoo.lab4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	EditText editTextTwo;
	EditText editTextTen;
	Button buttonTen;
	Button buttonTwo;
	
	TextView textView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editTextTen = (EditText) findViewById(R.id.editTextTen);
        editTextTwo = (EditText) findViewById(R.id.editTextTwo);
        
        buttonTen = (Button) findViewById(R.id.buttonTen);
        buttonTwo = (Button) findViewById(R.id.buttonTwo);
        
        textView = (TextView) findViewById(R.id.textView2);
        
        buttonTen.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonTwo :{
			String string = editTextTwo.getText().toString();
			string = convertToTwo(string);
			textView.setText(string);
			editTextTen.setText(string);
		}
			
			break;

		case R.id.buttonTen : {
			String string = editTextTen.getText().toString();
			string = convertToTen(string);
			textView.setText(string);
			editTextTwo.setText(string);
		}
			break;
		}
		
	}

	private String convertToTen(String string) {
		if (string.isEmpty()) {
			return "Не введено число";
		}
		for (int i = 0; i < string.length(); i++) {
			char a = string.charAt(i);
			int aInt = (int) a;
			if ((aInt > 47) && (aInt < 50)) {
			} else {
				return "Введённое число не является двоичным числом.";
			}
		}
		Integer integer = Integer.valueOf(string,2);
		return String.valueOf(integer);
	}

	private String convertToTwo(String string) {
		if (string.isEmpty()) {
			return "Не введено число";
		}
		for (int i = 0; i < string.length(); i++) {
			char a = string.charAt(i);
			int aInt = (int) a;
			if ((aInt > 47) && (aInt < 58)) {
			} else {
				return "Введённое число не является десятичным числом.";
			}
		}
		
		Integer integer = Integer.valueOf(string);
		String rezult = "";
		while (integer > 0) {
			int integerRezult = integer % 2;
			rezult = integerRezult + rezult;
			integer = integer / 2;
		}
		return rezult;
	}
}
