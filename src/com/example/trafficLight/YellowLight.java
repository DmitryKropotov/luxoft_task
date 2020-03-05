package com.example.trafficLight;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Log
public class YellowLight implements LightColor {

    private LightColor previousLightColor;

    @Override
    public void changeColor(TrafficLight trafficLight) {
        if (!(previousLightColor instanceof YellowLight)) {
            log.info("goNext method in YellowLight class. previousLightColor is set to " + previousLightColor + " in setter of YellowLight");
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
