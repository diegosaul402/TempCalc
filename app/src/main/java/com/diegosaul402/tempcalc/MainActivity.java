package com.diegosaul402.tempcalc;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.diegosaul402.tempcalc.fragments.DetailsFragment;
import com.diegosaul402.tempcalc.fragments.DetailsFragmentListener;
import com.diegosaul402.tempcalc.temps.TempEntity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.diegosaul402.tempcalc.temps.TempUtils.fromCelsius;
import static com.diegosaul402.tempcalc.temps.TempUtils.fromFahrenheit;
import static com.diegosaul402.tempcalc.temps.TempUtils.fromKelvin;

public class MainActivity extends AppCompatActivity {

    public DetailsFragmentListener fragmentListener;
    @Bind(R.id.txtInput)
    EditText txtInput;
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

    /**
     * The {@link ViewPager} that will host the section contents.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.detailsFragment);
        detailsFragment.setRetainInstance(true);

        fragmentListener = detailsFragment;
        fragmentListener.initList();

        radioCelsius.setChecked(true);
        txtInput.setFocusable(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btCalculate)
    public void handleClick(){
        String strInput = txtInput.getText().toString().trim();

        if(!strInput.isEmpty()){
            double inputD = Double.parseDouble(strInput);
            TempEntity tempEntity;

            if(radioCelsius.isChecked()) {
                tempEntity = fromCelsius(inputD);
                textOutput.setText(tempEntity.getStrOutput());
                fragmentListener.addToList(tempEntity);
            }
            if(radioFar.isChecked()){
                tempEntity = fromFahrenheit(inputD);
                textOutput.setText(tempEntity.getStrOutput());
                fragmentListener.addToList(tempEntity);
            }
            if(radioKelvin.isChecked()) {
                tempEntity = fromKelvin(inputD);
                textOutput.setText(tempEntity.getStrOutput());
                fragmentListener.addToList(tempEntity);
            }
        }
        else {
            txtInput.setError(getString(R.string.Required));
        }

    }
}
