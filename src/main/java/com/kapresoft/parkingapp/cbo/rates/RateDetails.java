package com.kapresoft.parkingapp.cbo.rates;

public class RateDetails {
    private int rateDetailID;
    private RateTimeUnit timeUnit;
    private float rate;
    private RateCurrency currency;
    private float percentDiscountRider;

    public int getRateDetailID() {
        return rateDetailID;
    }

    public void setRateDetailID(int rateDetailID) {
        this.rateDetailID = rateDetailID;
    }

    public RateTimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(RateTimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public RateCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(RateCurrency currency) {
        this.currency = currency;
    }

    public float getPercentDiscountRider() {
        return percentDiscountRider;
    }

    public void setPercentDiscountRider(float percentDiscountRider) {
        this.percentDiscountRider = percentDiscountRider;
    }
}
