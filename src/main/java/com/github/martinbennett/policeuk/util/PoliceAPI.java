package com.github.martinbennett.policeuk.util;

import org.apache.http.client.utils.URIBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @apiNote <a href="https://data.police.uk/docs">Police UK Data</a>
 * @author VenomousInc
 * @since 05/05/2019
 */
public enum PoliceAPI {
    LOCATE_NEIGHBOURHOOD("locate-neighbourhood"),
    NEIGHBOURHOOD_PRIORITIES("priorities"),
    NEIGHBOURHOOD_EVENTS("events"),
    NEIGHBOURHOOD_TEAM("people"),
    NEIGHBOURHOOD_BOUNDARY("boundary"),
    NEIGHBOURHOODS("neighbourhoods"),
    LATEST_DATE_RECORDED("crime-last-updated"),
    CRIME_CATEGORIES("crime-categories"),
    FORCES("forces", "people"),
    STREET_CRIME("crimes-street/all-crime"),
    STREET_OUTCOME("outcomes-at-location"),
    OUTCOMES_FOR_CRIME("outcomes-for-crime"),
    CRIMES_AT_LOCATION("crimes-at-location"),
    CRIMES_WITHOUT_LOCATION("crimes-no-location");

    public final String PATH;
    public final String PATH_OTHER;

    PoliceAPI(final String PATH) {
        this.PATH = PATH;
        this.PATH_OTHER = null;
    }

    PoliceAPI(final String PATH, final String PATH_OTHER) {
        this.PATH = PATH;
        this.PATH_OTHER = PATH_OTHER;
    }

    public static final String API_URL_BASE = "https://data.police.uk";
    public static final String API_URL_PREFIX = "api";

    public static URIBuilder getBuilder() throws URISyntaxException {
        return new URIBuilder(API_URL_BASE);
    }

    /**
     * Example: https://data.police.uk/api/locate-neighbourhood?q=51.500617,-0.124629
     * @param coordQuery LAT,LNG
     * @return The nearest Neighbourhood to this Latitude, Longitude
     * @throws URISyntaxException
     * @throws MalformedURLException
     */
    public static URL neighbourhoodByCoords(final String coordQuery) throws URISyntaxException, MalformedURLException {
        return getBuilder().setPathSegments(API_URL_PREFIX, LOCATE_NEIGHBOURHOOD.PATH)
                .addParameter("q", coordQuery).build().toURL();
    }

    public static URL neighbourhoodPriorities(final String force, final String neighbourhoodId) throws URISyntaxException,
            MalformedURLException {
        return getBuilder().setPathSegments(API_URL_PREFIX, force, neighbourhoodId, NEIGHBOURHOOD_PRIORITIES.PATH).build().toURL();
    }

    public static URL neighbourhoodEvent(final String force, final String neighbourhoodId) throws URISyntaxException,
            MalformedURLException {
        return getBuilder().setPathSegments(API_URL_PREFIX, force, neighbourhoodId, NEIGHBOURHOOD_EVENTS.PATH).build().toURL();
    }

    public static URL neighbourhoodTeam(final String force, final String neighbourhoodId) throws URISyntaxException,
            MalformedURLException {
        return getBuilder().setPathSegments(API_URL_PREFIX, force, neighbourhoodId, NEIGHBOURHOOD_TEAM.PATH).build().toURL();
    }


    public static URL neighbourhoodBoundary(final String force, final String neighbourhoodId) throws URISyntaxException,
            MalformedURLException {
        return getBuilder().setPathSegments(API_URL_PREFIX, force, neighbourhoodId, NEIGHBOURHOOD_BOUNDARY.PATH).build().toURL();
    }

    public static URL specificNeighbourhood(final String force, final String neighbourhoodId) throws URISyntaxException,
            MalformedURLException {
        return getBuilder().setPathSegments(API_URL_PREFIX, force, neighbourhoodId).build().toURL();
    }

    public static URL forceNeighbourhoods(final String force) throws URISyntaxException, MalformedURLException {
        return getBuilder().setPathSegments(API_URL_PREFIX, force, NEIGHBOURHOODS.PATH).build().toURL();
    }

    public static URL specificOutcome(final String pid) throws URISyntaxException, MalformedURLException {
        return getBuilder().setPathSegments(API_URL_PREFIX, OUTCOMES_FOR_CRIME.PATH, pid).build().toURL();
    }

    public static URL crimesWithoutLocation(final DefinedCrimeCategory crimeCategory, final String force, final String date) {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX, CRIMES_WITHOUT_LOCATION.PATH)
                    .addParameter("force", force).addParameter("date", date)
                    .addParameter("category", crimeCategory.toString()).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL crimesWithoutLocation(final DefinedCrimeCategory crimeCategory, final String force) {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX, CRIMES_WITHOUT_LOCATION.PATH)
                    .addParameter("force", force)
                    .addParameter("category", crimeCategory.toString()).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL crimesWithoutLocation(final String force, final String date) {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX, CRIMES_WITHOUT_LOCATION.PATH)
                    .addParameter("force", force).addParameter("date", date).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL crimesWithoutLocation(final String force) {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX, CRIMES_WITHOUT_LOCATION.PATH)
                    .addParameter("force", force).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL crimesOnStreet(final String streetId, final String date) {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX,
                    CRIMES_AT_LOCATION.PATH).addParameter("date", date).addParameter("location_id", streetId).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL crimesOnStreet(final String lat, final String lng, final String date) {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX,
                    CRIMES_AT_LOCATION.PATH).addParameter("date", date)
                    .addParameter("lat", lat).addParameter("lng", lng).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL outcomesOfArea(final AreaPolygon poly, final String date) {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX,
                    STREET_OUTCOME.PATH).addParameter("date", date).addParameter("poly", poly.build()).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL outcomesOfArea(final String lat, final String lng, final String date) {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX,
                    STREET_OUTCOME.PATH).addParameter("date", date)
                    .addParameter("lat", lat).addParameter("lng", lng).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL outcomesOnStreet(final String streetId, final String date) {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX,
                    STREET_OUTCOME.PATH).addParameter("date", date).addParameter("location_id", streetId).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets the street crime URL for a vector area.
     * @param poly [lat],[lng]:[lat],[lng]:[lat],[lng]
     * @param date YYYY-mm
     * @return A Street Crime URL
     */
    public static URL streetCrimes(final AreaPolygon poly, final String date) {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX,
                    STREET_CRIME.PATH).addParameter("poly", poly.build()).addParameter("date", date).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets the street crime URL for a 1 mile radius.
     * @param lat Latitude
     * @param lng Longititude
     * @param date YYYY-mm
     * @return A Street Crime URL
     */
    public static URL streetCrimes(final String lat, final String lng, final String date) {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX,
                    STREET_CRIME.PATH).addParameter("lat", lat).addParameter("lng", lng)
                    .addParameter("date", date).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL forcesSeniors(final String force) {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX,
                    FORCES.PATH, force, FORCES.PATH_OTHER).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL specificForce(final String force) {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX, FORCES.PATH, force).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL allForces() {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX, FORCES.PATH).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param date Possibly meaningless, but defines a date for what defined categories are in place.
     * @return Crime categories
     */
    public static URL crimeCategories(final String date) {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX, CRIME_CATEGORIES.PATH)
                    .addParameter("date", date).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return Crime categories
     */
    public static URL crimeCategories() {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX, CRIME_CATEGORIES.PATH).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return The latest Police data update
     */
    public static URL lastUpdatedRecord() {
        try {
            return getBuilder().setPathSegments(API_URL_PREFIX, LATEST_DATE_RECORDED.PATH).build().toURL();
        } catch (URISyntaxException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
