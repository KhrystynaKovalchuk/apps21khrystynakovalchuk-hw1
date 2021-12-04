package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    public double avgTemp;
    public double devTemp;
    public double minTemp;
    public double maxTemp;

    public TempSummaryStatistics(double AvgTemp, double DevTemp, double MinTemp, double MaxTemp){
        this.avgTemp = AvgTemp;
        this.devTemp = DevTemp;
        this.minTemp = MinTemp;
        this.maxTemp = MaxTemp;
    }
}