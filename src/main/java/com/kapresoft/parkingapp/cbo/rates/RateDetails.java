package com.kapresoft.parkingapp.cbo.rates;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RateDetails)) return false;
        RateDetails that = (RateDetails) o;
        return getRateDetailID() == that.getRateDetailID() &&
                Float.compare(that.getRate(), getRate()) == 0 &&
                Float.compare(that.getPercentDiscountRider(), getPercentDiscountRider()) == 0 &&
                getTimeUnit() == that.getTimeUnit() &&
                getCurrency() == that.getCurrency();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRateDetailID(), getTimeUnit(), getRate(), getCurrency(), getPercentDiscountRider());
    }

    @Override
    public String toString() {
        return "RateDetails{" +
                "rateDetailID=" + rateDetailID +
                ", timeUnit=" + timeUnit +
                ", rate=" + rate +
                ", currency=" + currency +
                ", percentDiscountRider=" + percentDiscountRider +
                '}';
    }
}
