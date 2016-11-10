package com.diegosaul402.tempcalc.temps;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by diego on 09/11/2016.
 */

public class TempUtils {
    private static TempEntity fromCelsius(double celsius){
        TempEntity temps = new TempEntity();
        temps.setTempC(celsius);
        temps.setTempF(celsius*1.8+32.0);
        temps.setTempK(celsius+273.15);
        temps.setTimetamp(new Date());
        return temps;
    }

    private static TempEntity fromKelvin(double kelvin){
        TempEntity temps = new TempEntity();
        temps.setTempK(kelvin);
        temps.setTempF(1.8*(kelvin-273.15)+32.0);
        temps.setTempC(kelvin-273.15);
        temps.setTimetamp(new Date());
        return temps;
    }

    private static TempEntity fromFahrenheit(double far){
        TempEntity temps = new TempEntity();
        temps.setTempF(far);
        temps.setTempK(0.555*(far-32)+273.15);
        temps.setTempC((far-32)/1.8);
        temps.setTimetamp(new Date());
        return temps;
    }

    public static String calcFromC(double celsius){
        TempEntity temps;
        DecimalFormat formatter = new DecimalFormat("#0.00");
        temps = fromCelsius(celsius);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        String output;
        output = formatter.format(temps.getTempC())+"°C Equivale a: " +
                formatter.format(temps.getTempF())+ "°F y " +
                formatter.format(temps.getTempK())+"K, " + simpleDateFormat.format(temps.getTimetamp());
        return output;
    }

    public static String calcFromF(double far){
        TempEntity temps;
        DecimalFormat formatter = new DecimalFormat("#0.00");
        temps = fromFahrenheit(far);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        String output;
        output = formatter.format(temps.getTempF())+"°F Equivale a: " +
                formatter.format(temps.getTempC())+ "°C y " +
                formatter.format(temps.getTempK())+"K, " + simpleDateFormat.format(temps.getTimetamp());
        return output;
    }

    public static String calcFromK(double k){
        TempEntity temps;
        DecimalFormat formatter = new DecimalFormat("#0.00");
        temps = fromKelvin(k);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        String output;
        output = formatter.format(temps.getTempK())+"K Equivale a: " +
                formatter.format(temps.getTempF())+ "°F y " +
                formatter.format(temps.getTempC())+"°C, " + simpleDateFormat.format(temps.getTimetamp());
        return output;
    }
}
