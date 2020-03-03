package com.example.trafficLight;

public class RedLight extends LightColor {

    private static LightColor instance;

    private RedLight() {};

    public static LightColor getInstance() {
        if (instance == null) {
            instance = new RedLight();
        }
        return instance;
    }

    @Override
    public LightColor goNext() {
        return new YellowLight(this);
    }
}
