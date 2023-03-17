// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import core.data.DataSource;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

@SuppressWarnings("HttpUrlsUsage")
public class ProcessWeatherData {

    public static void main(String[] args) {
        DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml");
        ds.load();
        List<WeatherStation> allStations =
            ds.fetchList(
                WeatherStation.class,
                "station/station_name",
                "station/station_id",
                "station/state",
                "station/latitude",
                "station/longitude",
                "station/xml_url");
        System.out.println("Total stations: " + allStations.size());

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a state abbreviation: ");
        String state = sc.next();
        System.out.println("Stations in " + state);

        List<WeatherStation> stateStations =
            allStations.stream()
                .filter(station -> station.isLocatedInState(state))
                .collect(Collectors.toList());

        stateStations.stream().map(WeatherStation::getName).forEach(System.out::println);

        for (WeatherStation station : stateStations) {
            try {
                DataSource ds2 = DataSource.connect(station.getUrl());
                ds2.load();
                //noinspection SpellCheckingInspection
                ds2.fetch(StationObservation.class, "temp_f", "relative_humidity", "dewpoint_f");
            } catch (Exception e) {
                System.out.println("Exception - reading entry");
            }
        }

        stateStations.stream()
            .collect(Collectors.groupingBy(WeatherStation::getState))
            .forEach(
                (stationState, stations) -> {
                    System.out.println(
                        "State: " + stationState + ", Stations: " + stations.size());
                    stations.stream()
                        .map(WeatherStation::getName)
                        .forEach(System.out::println);
                });

        stateStations.stream()
            .max(Comparator.comparingDouble(WeatherStation::getLat))
            .ifPresent(
                station ->
                    System.out.printf(
                        "Northernmost station is: %s at %s%n",
                        station.getName(), station.getLat()));

        stateStations.stream()
            .min(Comparator.comparingDouble(WeatherStation::getLat))
            .ifPresent(
                station ->
                    System.out.printf(
                        "Southernmost station is: %s at %s%n",
                        station.getName(), station.getLat()));

        List<Double> temps =
            stateStations.stream()
                .map(WeatherStation::getRef)
                .filter(Objects::nonNull)
                .map(StationObservation::getTemp)
                .collect(Collectors.toList());

        temps.stream()
            .max(Double::compareTo)
            .ifPresent(max -> System.out.printf("Max temp is: %s%n", max));

        temps.stream()
            .min(Double::compareTo)
            .ifPresent(min -> System.out.printf("Min temp is: %s%n", min));
    }
}
