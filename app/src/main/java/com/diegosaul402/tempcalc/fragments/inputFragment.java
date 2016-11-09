package com.diegosaul402.tempcalc.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.diegosaul402.tempcalc.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class inputFragment extends Fragment {


    @Bind(R.id.input)
    EditText input;
    @Bind(R.id.radioCelsius)
    RadioButton radioCelsius;
    @Bind(R.id.radioFar)
    RadioButton radioFar;
    @Bind(R.id.radioKelvin)
    RadioButton radioKelvin;
    @Bind(R.id.radioGroup)
    RadioGroup radioGroup;
    @Bind(R.id.textOutput)
    TextView textOutput;
    @Bind(R.id.button)
    Button button;

    public inputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.button)
    public void handleClick(){
        if(radioCelsius.isChecked()) textOutput.setText("Celsius");
        if(radioFar.isChecked()) textOutput.setText("Farhenheit");
        if(radioKelvin.isChecked()) textOutput.setText("Kelvin");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
