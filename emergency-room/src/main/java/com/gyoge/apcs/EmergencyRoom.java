// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.PriorityQueue;
import javax.swing.*;

@SuppressWarnings("unused")
public class EmergencyRoom {
    // list of conditions
    private static final String[] conditions = {
        "Cardiac Arrest", "Stroke", "Poisoning", "Minor Head Injury", "Broken Ankle"
    };

    private final String name;
    private final PriorityQueue<Patient> patients = new PriorityQueue<>();

    public EmergencyRoom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public PriorityQueue<Patient> getPatients() {
        return patients;
    }

    @Override
    public String toString() {
        return "EmergencyRoom{" + "name='" + name + '\'' + ", patients=" + patients + '}';
    }

    public int triage(int age, String condition) {
        //noinspection EnhancedSwitchMigration
        switch (condition) {
            case "Cardiac Arrest":
                return age >= 65 ? 1 : 2;
            case "Stroke":
                return age >= 65 ? 3 : 4;
            case "Poisoning":
                return age <= 10 ? 5 : 6;
            case "Minor Head Injury":
                return age <= 18 ? 7 : 8;
            case "Broken Ankle":
                return age >= 65 ? 9 : 10;
            default:
                return 0;
        }
    }

    public void addPatient() {
        // use dialogue boxes and dropdowns to get patient info
        String condition =
                (String)
                        JOptionPane.showInputDialog(
                                null,
                                "Choose a condition.",
                                "Select Patient Condition",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                conditions,
                                conditions[0]);
        int age =
                Integer.parseInt(
                        JOptionPane.showInputDialog("Enter Patient's Age: ").replace(" ", ""));
        String name = JOptionPane.showInputDialog("Enter Patient's Name: ");

        patients.add(new Patient(name, triage(age, condition)));
    }

    @SuppressWarnings("UnusedReturnValue")
    public Patient treatPatient() {
        Patient treat = patients.remove();

        if (treat == null) {
            System.out.println("All patients have been treated!");
        } else {
            System.out.println(treat.getName() + " is being treated");
            System.out.println("The following patients are still awaiting treatment:");
            System.out.println(patients);
        }

        return treat;
    }

    public static void main(String[] args) {
        EmergencyRoom er = new EmergencyRoom("ER");
        for (int i = 0; i < 5; i++) {
            er.addPatient();
        }
        for (int i = 0; i < 5; i++) {
            er.treatPatient();
        }
    }
}
