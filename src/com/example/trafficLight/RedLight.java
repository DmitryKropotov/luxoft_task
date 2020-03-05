package com.example.trafficLight;

import lombok.extern.java.Log;

@Log
public class RedLight implements LightColor {

    private static LightColor instance;

    private RedLight() {};

    public static LightColor getInstance() {
        if (instance == null) {
            instance = new RedLight();
        }
        return instance;
    }

    @Override
    public void changeColor(TrafficLight trafficLight) {
        log.info("goNext method in RedLight class");
        trafficLight.setLight(new YellowLight(trafficLight.getLight()));
    }

    @Override
    public String toString() {
        return "Red light";
    }
}
