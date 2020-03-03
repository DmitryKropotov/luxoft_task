package com.example.trafficLight;

public class GreenLight extends LightColor {

    private static LightColor instance;

    private GreenLight() {};

    public static LightColor getInstance() {
        if (instance == null){
            instance = new GreenLight();
        }
        return instance;
    }

        @Override
    public LightColor goNext() {
       return new YellowLight(this);
    }
}
