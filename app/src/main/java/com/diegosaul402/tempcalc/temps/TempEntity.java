package com.diegosaul402.tempcalc.temps;

import java.util.Date;

/**
 * Created by diego on 09/11/2016.
 */

public class TempEntity {
    private double tempK;
    private double tempF;
    private double tempC;
    private Date timetamp;

    private String strOutput;

    public double getTempK() {
        return tempK;
    }

    public void setTempK(double tempK) {
        this.tempK = tempK;
    }

    public double getTempF() {
        return tempF;
    }

    public void setTempF(double tempF) {
        this.tempF = tempF;
    }

    public double getTempC() {
        return tempC;
    }

    public void setTempC(double tempC) {
        this.tempC = tempC;
    }

    public Date getTimetamp() {
        return timetamp;
    }

    public void setTimetamp(Date timetamp) {
        this.timetamp = timetamp;
    }

    public String getStrOutput() {
        return strOutput;
    }

    public void setStrOutput(String strOutput) {
        this.strOutput = strOutput;
    }
}
