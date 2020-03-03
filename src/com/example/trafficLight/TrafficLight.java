package com.example.trafficLight;

public class TrafficLight {

    private LightColor light;
    private boolean serviceModeOn;

    public LightColor getLight() {
        return light;
    }

    public void setLight(LightColor light) {
        this.light = light;
    }

    public boolean isServiceModeOn() {
        return serviceModeOn;
    }

    public void setServiceModeOn(boolean serviceModeOn) {
        if (serviceModeOn) {
            YellowLight yellowLight = new YellowLight();
            yellowLight.setPreviousLightColor(yellowLight);
            this.light = yellowLight;
        }
        this.serviceModeOn = serviceModeOn;
    }
}
