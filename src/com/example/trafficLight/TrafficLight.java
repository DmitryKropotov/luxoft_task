package com.example.trafficLight;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrafficLight {

    private LightColor light = GreenLight.getInstance();
    private boolean serviceModeOn = false;

    public void setServiceModeOn(boolean serviceModeOn) {
        if (serviceModeOn) {
            YellowLight yellowLight = new YellowLight();
            yellowLight.setPreviousLightColor(yellowLight);
            this.light = yellowLight;
        }
        this.serviceModeOn = serviceModeOn;
    }
}
