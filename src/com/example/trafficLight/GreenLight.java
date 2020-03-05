package com.example.trafficLight;

import lombok.extern.java.Log;

@Log
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
       log.info("goNext method in GreenLight class");
       trafficLight.setLight(new YellowLight(trafficLight.getLight()));
    }

    @Override
    public String toString() {
        return "Green light";
    }
}
