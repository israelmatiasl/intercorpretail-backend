package com.intercorpretail.customers.core.dtos;

public class KpiDto {
    private double average;
    private double standardDerivation;

    public KpiDto(double average, double standardDerivation) {
        this.average = average;
        this.standardDerivation = standardDerivation;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public double getStandardDerivation() {
        return standardDerivation;
    }

    public void setStandardDerivation(double standardDerivation) {
        this.standardDerivation = standardDerivation;
    }
}
