// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

@SuppressWarnings("unused")
public class StationObservation {

    private final double temperature;
    private final double humidity;
    private final double dew_point;

    public StationObservation(double temp, double hum, double dew) {
        temperature = temp;
        humidity = hum;
        dew_point = dew;
    }

    public double getTemp() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getDewPont() {
        return dew_point;
    }

    public String toString() {
        return "StationObservation: temp=" + temperature + ", humidity= " + humidity + "\n";
    }
}
