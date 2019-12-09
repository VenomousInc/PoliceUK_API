package com.github.martinbennett.policeuk.api;

/**
 * @author VenomousInc
 * @since 06/05/2019
 */
public class LastAPIUpdate {

    public String date;

    public String getDateSimple() {
        return date.substring(0, date.lastIndexOf('-'));
    }

    @Override
    public String toString() {
        return "LastAPIUpdate{" +
                "date='" + date + '\'' +
                '}';
    }
}
