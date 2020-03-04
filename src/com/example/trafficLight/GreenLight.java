package com.example.trafficLight;

public class GreenLight implements LightColor {

    private static LightColor instance;

    private GreenLight() {};

    public static LightColor getInstance() {
        if (instance == null){
            instance = new GreenLight();
        }
        return instance;
    }

    @Override
    public void changeColor(TrafficLight trafficLight) {
       System.out.println("goNext method in GreenLight class");
       trafficLight.setLight(new YellowLight(trafficLight.getLight()));
    }

    @Override
    public String toString() {
        return "Green light";
    }
}
