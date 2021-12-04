package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;
import java.util.Arrays;

public class TemperatureSeriesAnalysis {
    private final int minBound = -273;
    private double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = new double[0];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double temperature : temperatureSeries) {
            if (temperature < minBound) {
                throw new InputMismatchException();
            }
        }
        this.temperatureSeries = Arrays.copyOf(temperatureSeries, temperatureSeries.length);
    }

    public void check(){
        if (temperatureSeries.length == 0){
            throw new IllegalArgumentException();
        }
    }

    public double average() {
        double sumTemperatures = 0;
        check();
//        if (temperatureSeries.length == 0){
//            throw new IllegalArgumentException();
//        }

        for (double temperature: temperatureSeries){
            sumTemperatures += temperature;
        }

        return sumTemperatures/temperatureSeries.length;
    }

    public double deviation() {
        double sum = 0;
        double averageMeaning = average();
        check();

        double[] deviationMeaningsSquared = new double[temperatureSeries.length];

        for(int i=0; i<temperatureSeries.length; i++){
            deviationMeaningsSquared[i] = Math.pow((temperatureSeries[i] - averageMeaning), 2);
            sum += deviationMeaningsSquared[i];
        }

        return Math.sqrt((sum/temperatureSeries.length));
    }

    public double min() {
        check();

        double minVal = temperatureSeries[0];
        for (double temperature: temperatureSeries){
            if (temperature < minVal){
                minVal = temperature;
            }
        }
        return minVal;
    }

    public double max() {
        check();

        double maxVal = temperatureSeries[0];

        for(double temperature: temperatureSeries){
            if(temperature > maxVal){
                maxVal = temperature;
            }
        }
        return maxVal;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        check();
        double differenceStart = Double.POSITIVE_INFINITY;
        double closest = 0;

        for (double temperature: temperatureSeries){
            double difference = Math.abs(temperature - tempValue);
            if (difference < differenceStart){
                differenceStart = difference;
                closest = temperature;
            }
            else if(difference == differenceStart && temperature > 0){
                differenceStart = difference;
                closest = temperature;
            }
        }
        return closest;
    }

    public double[] findTempsLessThen(double tempValue) {
        check();

        int counter = 0;

        for (double temperature: temperatureSeries){
            if (temperature < tempValue){
                counter++;
            }
        }

        double[] values = new double[counter];
        int ind = 0;

        for (double temp : temperatureSeries) {
            if (temp < tempValue) {
                values[ind] = temp;
                ind ++;
            }
        }

        return values;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        check();

        int counter = 0;

        for (double temperature: temperatureSeries){
            if (temperature >= tempValue){
                counter++;
            }
        }

        double[] values = new double[counter];
        int ind = 0;

        for (double temp : temperatureSeries) {
            if (temp >= tempValue) {
                values[ind] = temp;
                ind ++;
            }
        }
        return values;
    }


    public TempSummaryStatistics summaryStatistics() {
        check();
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        for (double temp: temps){
            if (temp < minBound){
                throw new InputMismatchException();
            }
        }

        double[] values = new double[temperatureSeries.length * 2];

        System.arraycopy(temperatureSeries, 0, values, 0, temperatureSeries.length);

        int index = temperatureSeries.length;
        for (double tmp: temps){
            values[index] = tmp;
            index++;
        }

        int sumValues = 0;
        for (double value: values){
            sumValues += value;
        }
        return sumValues;
    }
}