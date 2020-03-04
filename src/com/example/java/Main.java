package com.example.java;

import com.example.trafficLight.GreenLight;
import com.example.trafficLight.LightColor;
import com.example.trafficLight.RedLight;
import com.example.trafficLight.TrafficLight;
import com.example.trafficLight.YellowLight;

import java.util.Scanner;

public class Main {

    private static volatile TrafficLight trafficLight = new TrafficLight();
    private static volatile boolean pedestrianButtonOn = false;
    private static volatile boolean changeServiceMode = false;

    public static void main(String[] args) {
        Runnable trafficLightAlgorithm = () -> {
            while (true) {
                if (!trafficLight.isServiceModeOn()) {
                    System.out.println("changeServiceMode " + changeServiceMode);
                }
                if (changeServiceMode) {
                    trafficLight.setServiceModeOn(!trafficLight.isServiceModeOn());
                    if (!trafficLight.isServiceModeOn()) {
                        trafficLight.setLight(GreenLight.getInstance());
                    }
                    changeServiceMode = false;
                    System.out.println("changeServiceMode has been switched off in the end of if before logic branches. trafficLight.getLight() is " + trafficLight.getLight());
                }
                if (!trafficLight.isServiceModeOn()) {
                    System.out.println("changeServiceMode " + changeServiceMode);
                }
                LightColor trafficLightColor = trafficLight.getLight();
                if (trafficLightColor == GreenLight.getInstance()) {
                    System.out.println("logic branch 1");
                    try {
                        System.out.println("30000 milliseconds are going to start");
                        long time = System.currentTimeMillis();
                        Thread.sleep(30000);
                        System.out.println((System.currentTimeMillis() - time) + " milliseconds passed by");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("catch block is over. PedestrianButtonOn " + pedestrianButtonOn + " changeServiceMode " + changeServiceMode);
                    while (!pedestrianButtonOn && !changeServiceMode){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("while loop is over. PedestrianButtonOn " + pedestrianButtonOn + " changeServiceMode " + changeServiceMode);
                } else if (trafficLightColor instanceof YellowLight && !trafficLight.isServiceModeOn()) {
                    System.out.println("logic branch 2");
                    try {
                        System.out.println("2000 milliseconds are going to start");
                        long time = System.currentTimeMillis();
                        Thread.sleep(2000);
                        System.out.println((System.currentTimeMillis() - time) + " milliseconds passed by");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (trafficLightColor == RedLight.getInstance()) {
                    System.out.println("logic branch 3");
                    try {
                        System.out.println("15000 milliseconds are going to start");
                        long time = System.currentTimeMillis();
                        Thread.sleep(15000);
                        System.out.println((System.currentTimeMillis() - time) + " milliseconds passed by");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    pedestrianButtonOn = false;
                    System.out.println("pedestrianButtonOn has been switched off in logic branch 3");
                }
                if (!trafficLight.isServiceModeOn()) {
                    System.out.println("pedestrianButtonOn " + pedestrianButtonOn + " changeServiceMode " + changeServiceMode);
                }
                if (trafficLightColor != null) {
                    trafficLightColor.changeColor(trafficLight);
                }
            }
        };
        new Thread(trafficLightAlgorithm).start();
        while (true) {
            System.out.println("To get current light print '1', to switch off green light for 15 seconds print '2', to change the mode print '3', to exit the app print 'exit'");
            Scanner scanner = new Scanner(System.in);
            String userCommand = scanner.next();
            switch (userCommand) {
                case "1":
                    System.out.println(trafficLight.getLight());
                    break;
                case "2":
                    if (trafficLight.isServiceModeOn()) {
                        System.out.println("The service mode is on. Please switch off the service mode on to walk the road");
                    } else {
                        pedestrianButtonOn = true;
                        System.out.println("pedestrianButtonOn is changed, pedestrianButtonOn is " + pedestrianButtonOn);
                    }
                    break;
                case "3":
                    changeServiceMode = true;
                    System.out.println("changeServiceMode is changed, changeServiceMode is " + changeServiceMode);
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
