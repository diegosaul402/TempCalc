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
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

import com.diegosaul402.tempcalc.R;
import com.diegosaul402.tempcalc.temps.TempEntity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.diegosaul402.tempcalc.temps.TempUtils.fromCelsius;
import static com.diegosaul402.tempcalc.temps.TempUtils.fromFahrenheit;
import static com.diegosaul402.tempcalc.temps.TempUtils.fromKelvin;

/**
 * A simple {@link Fragment} subclass.
 */
public class inputFragment extends Fragment {


    @Bind(R.id.txtInput)
    EditText textInput;
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
    @Bind(R.id.btCalculate)
    Button btCalculate;

    private DetailsFragmentListener fragmentListener;

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
        textInput.setFocusable(true);

        //DetailsFragment fragment = (DetailsFragment) getFragmentManager().findFragmentById(R.id.detailsFragment);
        //fragment.setRetainInstance(true);
        //fragmentListener = fragment;

        //fragmentListener.initList();
        return view;
    }

    @OnClick(R.id.btCalculate)
    public void handleClick(){
        String strInput = textInput.getText().toString().trim();

        if(!strInput.isEmpty()){
            double inputD = Double.parseDouble(strInput);
            TempEntity tempEntity;

            if(radioCelsius.isChecked()) {
                tempEntity = fromCelsius(inputD);
                textOutput.setText(tempEntity.getStrOutput());
            }
            if(radioFar.isChecked()){
                tempEntity = fromFahrenheit(inputD);
                textOutput.setText(tempEntity.getStrOutput());
            }
            if(radioKelvin.isChecked()) {
                tempEntity = fromKelvin(inputD);
                textOutput.setText(tempEntity.getStrOutput());
            }
        }
        else {
            Toast toast = Toast.makeText(getActivity().getApplicationContext(),getString(R.string.Required), Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
