package com.ss.ttvideoengine.selector.shift;

import java.io.Serializable;

/* access modifiers changed from: package-private */
public class Shift implements Serializable, Comparable<Shift> {
    private static final long serialVersionUID = 7003130400674500845L;
    public final double mDownThreshold;
    public final double mRate;
    public final double mUpThreshold;

    public double getMedianThreshold() {
        return (this.mDownThreshold + this.mUpThreshold) / 2.0d;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.mRate);
        long doubleToLongBits2 = Double.doubleToLongBits(this.mDownThreshold);
        long doubleToLongBits3 = Double.doubleToLongBits(this.mUpThreshold);
        return (((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
    }

    public String toString() {
        return "Shift{mRate=" + this.mRate + ", mDownThreshold=" + this.mDownThreshold + ", mUpThreshold=" + this.mUpThreshold + '}';
    }

    public int compareTo(Shift shift) {
        return Double.compare(this.mRate, shift.mRate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shift)) {
            return false;
        }
        Shift shift = (Shift) obj;
        if (Double.compare(shift.mRate, this.mRate) == 0 && Double.compare(shift.mDownThreshold, this.mDownThreshold) == 0 && Double.compare(shift.mUpThreshold, this.mUpThreshold) == 0) {
            return true;
        }
        return false;
    }

    public Shift(double d, double d2, double d3) {
        this.mRate = d;
        this.mDownThreshold = d2;
        this.mUpThreshold = d3;
    }
}
