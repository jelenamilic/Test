package com.example.android_ispit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText ime, prezime, adresa, oib, telefon;
	Spinner grad;
	RadioButton spolZenski, spolMuski;
	Button btnSpremi;
	int k;
	RadioGroup spol;
	public static final int REQUEST_CODE = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ime = (EditText) findViewById(R.id.editText_ime);
		prezime = (EditText) findViewById(R.id.editText_prezime);
		adresa = (EditText) findViewById(R.id.editText_adresa);
		grad = (Spinner) findViewById(R.id.spinnerGrad);
		oib = (EditText) findViewById(R.id.editText_oib);
		telefon = (EditText) findViewById(R.id.editText_brojtelefona);
		spol = (RadioGroup) findViewById(R.id.radioGroupSpol);
		spolZenski = (RadioButton) findViewById(R.id.radioButton_zenski);
		spolMuski = (RadioButton) findViewById(R.id.radioButton_muski);
		
		if (getIntent().getBooleanExtra("Exit me", false)) {
			finish();
			return;
		}

		Spinner s = (Spinner) findViewById(R.id.spinnerGrad);
		
		ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
				R.array.gradovi, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s.setAdapter(adapter);
		
		btnSpremi = (Button) findViewById(R.id.spremi);
		btnSpremi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				

				String toastIme = ime.getText().toString();
				String toastPrezime = prezime.getText().toString();
				String toastAdresa = adresa.getText().toString();
				String toastGrad = grad.getSelectedItem().toString();
				String toastOib = oib.getText().toString();
				String toastTelefon = telefon.getText().toString();
				String izborSpola = "";
				
				switch (spol.getCheckedRadioButtonId()) {
				case R.id.radioButton_muski:
					izborSpola = "Muški";
					break;
				case R.id.radioButton_zenski:
					izborSpola = "Ženski";
					break;
				}

				String data = toastIme + " " + toastPrezime + "\n"
						+ toastAdresa + "\n" + toastGrad + "\n" + "oib: "
						+ toastOib + "\n" + "tel: " + toastTelefon + "\n"
						+ "spol: " + izborSpola;

				Toast toast = Toast.makeText(MainActivity.this, data, 5000);
				toast.show();

				if(v.getId() == R.id.spremi) {

					Intent i = new Intent (MainActivity.this, SpremanjePodataka.class);
					i.putExtra("prviEdit", toastIme);
					i.putExtra("drugiEdit", toastPrezime);
					i.putExtra("treciEdit", toastAdresa);
					i.putExtra("cetEdit", toastGrad);
					i.putExtra("petEdit", toastOib);
					i.putExtra("sestEdit", toastTelefon);
					i.putExtra("sedamEdit", izborSpola);
					startActivityForResult(i, REQUEST_CODE);
				
				}
			}
		});

	}

	@SuppressWarnings("unused")
	public void onBackPressed() {

		boolean backpress;

		if (backpress = true) {
			Toast toast = Toast.makeText(this,
					"Hvala na korištenju aplikacije!", 2000);
			toast.show();
		}
		super.onBackPressed();
		
		

	}

	@Override
	protected void onResume() {
		super.onResume();
		
		ime.setText("");
		prezime.setText("");
		adresa.setText("");
		oib.setText("");
		telefon.setText("");
		spolZenski.setText("");
		spolMuski.setText("");
		
		
	}
	

}
