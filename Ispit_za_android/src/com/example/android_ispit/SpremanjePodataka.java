package com.example.android_ispit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SpremanjePodataka extends Activity implements OnClickListener {

	Button zatvori;
	Button da;
	Button ne;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.podaci);

		prikaziPodatke();

		Button da = (Button) findViewById(R.id.btnDa);
		da.setOnClickListener(this);

		Button ne = (Button) findViewById(R.id.btnNe);
		ne.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		switch (v.getId()) {

		case R.id.btnNe:
			Intent izlaz = new Intent(this, MainActivity.class);
			izlaz.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			izlaz.putExtra("Exit me", true);
			startActivity(izlaz);
			finish();
			break;

		case R.id.btnDa:
			Intent brisi = new Intent(this, MainActivity.class);
			finish();
			break;

		}

	}

	private void prikaziPodatke() {
		Intent i = getIntent();
		if (i.hasExtra("prviEdit")) {
			String toastIme = i.getExtras().getString("prviEdit");
			TextView prikazImena = (TextView) findViewById(R.id.prikazIme);
			if (toastIme != null)
				prikazImena.setText(toastIme);
		}

		if (i.hasExtra("drugiEdit")) {
			String toastPrezime = i.getExtras().getString("drugiEdit");
			TextView prikazPrezimena = (TextView) findViewById(R.id.prikazPrezime);
			if (toastPrezime != null)
				prikazPrezimena.setText(toastPrezime);
		}

		if (i.hasExtra("treciEdit")) {
			String toastAdresa = i.getExtras().getString("treciEdit");
			TextView prikazAdrese = (TextView) findViewById(R.id.prikazAdresa);
			if (toastAdresa != null)
				prikazAdrese.setText(toastAdresa);
		}

		if (i.hasExtra("cetEdit")) {
			String toastGrad = i.getExtras().getString("cetEdit");
			TextView prikazGrad = (TextView) findViewById(R.id.prikazGrad);
			if (toastGrad != null)
				prikazGrad.setText(toastGrad);
		}
		if (i.hasExtra("petEdit")) {
			String toastOib = i.getExtras().getString("petEdit");
			TextView prikazOib = (TextView) findViewById(R.id.prikazOib);
			if (toastOib != null)
				prikazOib.setText(toastOib);
		}
		if (i.hasExtra("sestEdit")) {
			String toastTelefon = i.getExtras().getString("sestEdit");
			TextView prikazTel = (TextView) findViewById(R.id.prikazBrojtel);
			if (toastTelefon != null)
				prikazTel.setText(toastTelefon);
		}
		if (i.hasExtra("sedamEdit")) {
			String izborSpola = i.getExtras().getString("sedamEdit");
			TextView prikazS = (TextView) findViewById(R.id.prikazSpol);
			if (izborSpola != null)
				prikazS.setText(izborSpola);
		}

		Button zatvori = (Button) findViewById(R.id.zatvori);
		zatvori.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent povratak = new Intent();
				if (v.getId() == R.id.zatvori) {
					setResult(RESULT_OK, povratak);
				}
				finish();
			}
		});

	}

}
