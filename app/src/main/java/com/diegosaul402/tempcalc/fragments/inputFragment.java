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
import com.diegosaul402.tempcalc.temps.TempEntity;
import com.diegosaul402.tempcalc.temps.TempUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.diegosaul402.tempcalc.temps.TempUtils.calcFromC;
import static com.diegosaul402.tempcalc.temps.TempUtils.calcFromF;
import static com.diegosaul402.tempcalc.temps.TempUtils.calcFromK;

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
        radioCelsius.setChecked(true);
        input.setFocusable(true);
        return view;
    }

    @OnClick(R.id.button)
    public void handleClick(){
        String strInput = input.getText().toString().trim();
        double inputD = Double.parseDouble(strInput);

        if(radioCelsius.isChecked()) textOutput.setText(calcFromC(inputD));
        if(radioFar.isChecked()) textOutput.setText(calcFromF(inputD));
        if(radioKelvin.isChecked()) textOutput.setText(calcFromK(inputD));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
