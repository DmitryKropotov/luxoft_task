package com.example.trafficLight;

public class YellowLight implements LightColor {

    private LightColor previousLightColor;

    public YellowLight() {}

    public YellowLight(LightColor previousLightColor) {
        System.out.println("previousLightColor is set to " + previousLightColor + " in constructor of YellowLight");
        this.previousLightColor = previousLightColor;
    }

    public void setPreviousLightColor(LightColor previousLightColor) {
        System.out.println("previousLightColor is set to " + previousLightColor + " in setter of YellowLight");
        this.previousLightColor = previousLightColor;
    }

    @Override
    public void changeColor(TrafficLight trafficLight) {
        if (!(previousLightColor instanceof YellowLight)) {
            System.out.println("goNext method in YellowLight class");
        }
       if (previousLightColor == GreenLight.getInstance()) {
           trafficLight.setLight(RedLight.getInstance());
       } else if (previousLightColor == RedLight.getInstance()) {
           trafficLight.setLight(GreenLight.getInstance());
       }
    }

    @Override
    public String toString() {
        return "Yellow light";
    }
}
