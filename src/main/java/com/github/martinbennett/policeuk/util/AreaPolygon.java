package com.github.martinbennett.policeuk.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * @author VenomousInc
 * @since 05/05/2019
 */
public class AreaPolygon {

    private static final Logger LOGGER = LoggerFactory.getLogger( AreaPolygon.class );

    final ArrayList<String> COORDINATES = new ArrayList<>();

    public AreaPolygon() {
    }

    public AreaPolygon(final String latitude, final String longitude) {
        addCoord(latitude, longitude);
    }

    public void addCoord(String latCommaLng) {
        COORDINATES.add(latCommaLng);
    }

    public void addCoord(String lat, String lng) {
        COORDINATES.add(String.format("%s,%s", lat, lng));
    }

    /**
     * Output as:
     * [X,Y]:[X,Y]:[X,Y]
     * @return [lat],[lng]:[lat],[lng]:[lat],[lng]
     */
    public String build() {
        if(COORDINATES.isEmpty()) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();

        for(String coord : COORDINATES) {
           if(sb.length() > 0) {
               sb.append(":");
           }
           sb.append(coord);
        }

        final String result = sb.toString();
        LOGGER.info("Building Polygon:\nAreaPolygon<{}>", result);

        return result;
    }

    @Override
    public String toString() {
        return "AreaPolygon{" +
                "COORDINATES=" + COORDINATES +
                '}';
    }
}
