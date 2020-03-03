package com.example.trafficLight;

public class YellowLight extends LightColor {

    private LightColor previousLightColor;

    public YellowLight() {}

    public YellowLight(LightColor previousLightColor) {
        this.previousLightColor = previousLightColor;
    }

    public void setPreviousLightColor(LightColor previousLightColor) {
        this.previousLightColor = previousLightColor;
    }

    @Override
    public LightColor goNext() {
       if (previousLightColor.equals(GreenLight.getInstance())) {
           return RedLight.getInstance();
       } else if (previousLightColor.equals(RedLight.getInstance())) {
           return GreenLight.getInstance();
       } else {
           return this;
       }
    }
}
