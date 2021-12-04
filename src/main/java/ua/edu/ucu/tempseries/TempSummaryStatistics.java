package ua.edu.ucu.tempseries;

import lombok.Getter;

@Getter
public class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

    public TempSummaryStatistics(double avgtemp, double devtemp, double mintemp, double maxtemp) {
        this.avgTemp = avgtemp;
        this.devTemp = devtemp;
        this.minTemp = mintemp;
        this.maxTemp = maxtemp;
    }
}