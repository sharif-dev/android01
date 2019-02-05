package edu.sharif.prj01;

// The full volatile visibility guarantee means,
// that when a value is written to days, then all
// variables visible to the thread are also written
// to main memory. That means, that when a value is
// written to days, the values of years and months
// are also written to main memory.
//
// Notice the totalDays() method starts by reading
// the value of days into the total variable. When
// reading the value of days, the values of months
// and years are also read into main memory. Therefore
// you are guaranteed to see the latest values of days,
// months and years with the above read sequence.
public class VolatileSharedObject {
    private int years;
    private int months;
    private volatile int days;

    public int totalDays() {
        int total = this.days;
        total += months * 30;
        total += years * 365;
        return total;
    }

    public void update(int years, int months, int days){
        this.years  = years;
        this.months = months;
        this.days   = days;
    }

    // The values of months and years are still written
    // to main memory when the days variable is modified,
    // but this time it happens before the new values
    // have been written to months and years. The new
    // values are thus not properly made visible to other
    // threads
    public void update2(int years, int months, int days){
        this.days   = days; // note
        this.months = months;
        this.years  = years;
    }

}
