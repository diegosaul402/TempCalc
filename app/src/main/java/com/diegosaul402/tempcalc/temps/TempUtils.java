package com.diegosaul402.tempcalc.temps;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by diego on 09/11/2016.
 */

public class TempUtils {
    public static TempEntity fromCelsius(double celsius){
        TempEntity temps = new TempEntity();
        temps.setTempC(celsius);
        temps.setTempF(celsius*1.8+32.0);
        temps.setTempK(celsius+273.15);
        temps.setTimetamp(new Date());

        DecimalFormat formatter = new DecimalFormat("#0.00");
        temps.setStrOutput(formatter.format(temps.getTempC())+"°C Equivale a: " +
                formatter.format(temps.getTempF())+ "°F y " +
                formatter.format(temps.getTempK())+"K");
        return temps;
    }

    public static TempEntity fromKelvin(double kelvin){
        TempEntity temps = new TempEntity();
        temps.setTempK(kelvin);
        temps.setTempF(1.8*(kelvin-273.15)+32.0);
        temps.setTempC(kelvin-273.15);
        temps.setTimetamp(new Date());

        DecimalFormat formatter = new DecimalFormat("#0.00");
        temps.setStrOutput(formatter.format(temps.getTempK())+"K Equivale a: " +
                formatter.format(temps.getTempF())+ "°F y " +
                formatter.format(temps.getTempC())+"°C");
        return temps;
    }

    public static TempEntity fromFahrenheit(double far){
        TempEntity temps = new TempEntity();
        temps.setTempF(far);
        temps.setTempK(0.555*(far-32)+273.15);
        temps.setTempC((far-32)/1.8);
        temps.setTimetamp(new Date());

        DecimalFormat formatter = new DecimalFormat("#0.00");
        temps.setStrOutput(formatter.format(temps.getTempF())+"°F Equivale a: " +
                formatter.format(temps.getTempC())+ "°C y " +
                formatter.format(temps.getTempK())+"K");
        return temps;
    }
}
