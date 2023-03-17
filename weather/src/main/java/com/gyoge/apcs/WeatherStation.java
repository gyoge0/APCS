// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

@SuppressWarnings("unused")
public class WeatherStation {

    private final String name;
    private final String id;
    private final String state;
    private final double lat;
    private final double lng;
    private final String url;
    private StationObservation soRef = null;

    WeatherStation(String name, String id, String state, double lat, double lng, String url) {
        this.name = name;
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.state = state;
        this.url = url;
    }

    /* Produce the id of this station */
    public String getId() {
        return id;
    }

    /* Produce the name of this station */
    public String getName() {
        return name;
    }

    /* Produce the longitude of this station */
    public double getLong() {
        return lng;
    }

    /* Produce the latitude of this station */
    public double getLat() {
        return lat;
    }

    public String getUrl() {
        return url;
    }

    public String getState() {
        return state;
    }

    public StationObservation getRef() {
        return soRef;
    }

    public void setRef(StationObservation ref) {
        this.soRef = ref;
    }

    /* Determine if this weather station is located in the given state */
    public boolean isLocatedInState(String st) {
        return this.state.equals(st);
    }

    public String toString() {
        return String.format("%5s, %8s, lat=%7.2f, long=%7.2f : %s", state, id, lat, lng, name);
    }
}
