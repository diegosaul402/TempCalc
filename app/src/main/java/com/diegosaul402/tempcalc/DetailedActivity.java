package com.diegosaul402.tempcalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailedActivity extends AppCompatActivity {

    @Bind(R.id.textDets)
    TextView textDets;
    @Bind(R.id.textDate)
    TextView textDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        textDets.setText(intent.getStringExtra("text"));

        Date fecha = new Date(intent.getLongExtra("date",0));
        textDate.setText(fecha.toString());
    }
}
