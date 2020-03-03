package com.example.java;

import com.example.trafficLight.TrafficLight;

import java.util.Scanner;

public class Main {
    private static TrafficLight trafficLight = new TrafficLight();

    public static void main(String[] args) {
        Runnable trafficLightAlgorithm = () -> {

        };
        new Thread(trafficLightAlgorithm).start();
        while (true) {
            System.out.println("To get current light print '1', to change the mode print '2', to exit the app print 'exit'");
            Scanner scanner = new Scanner(System.in);
            String userCommand = scanner.next();
            switch (userCommand) {
                case "1":
                    System.out.println(trafficLight.getLight());
                    break;
                case "2":
                    trafficLight.setServiceModeOn(!trafficLight.isServiceModeOn());
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }
    }
}
