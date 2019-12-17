package com.github.venomousinc.policeuk.api;

/**
 * @author VenomousInc
 * @since 06/05/2019
 */
public class LastAPIUpdate {

    public String date;

    public String getDateSimple() {
        return date.substring(0, date.lastIndexOf('-'));
    }

    public String toPrettyPrint() {
        return String.format(
                "# LastAPIUpdate #%n date: %s", this.date);
    }

    @Override
    public String toString() {
        return "LastAPIUpdate{" +
                "date='" + date + '\'' +
                '}';
    }
}
