package com.github.martinbennett.policeuk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.github.martinbennett.policeuk.api.area.Neighbourhood;
import com.github.martinbennett.policeuk.api.crime.Crime;
import com.github.martinbennett.policeuk.api.crime.CrimeCategory;
import com.github.martinbennett.policeuk.api.LastAPIUpdate;
import com.github.martinbennett.policeuk.api.Force;
import com.github.martinbennett.policeuk.api.crime.Outcome;
import com.github.martinbennett.policeuk.api.crime.DetailedOutcome;
import com.github.martinbennett.policeuk.api.Person;
import com.github.martinbennett.policeuk.api.neighbourhood.Priority;
import com.github.martinbennett.policeuk.util.AreaPolygon;
import com.github.martinbennett.policeuk.util.DefinedCrimeCategory;
import com.github.martinbennett.policeuk.util.PoliceAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * The United Kingdoms Police API
 * <p></p>
 * @apiNote <a href="https://data.police.uk/docs">Police UK Data</a>
 * @author VenomousInc
 * @since 05/05/2019
 *
 */
public class PoliceUK {

    private static final Logger LOGGER = LoggerFactory.getLogger( PoliceUK.class );

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public LastAPIUpdate lastAPIUpdate = null;

    public PoliceUK() {
        LOGGER.info("Creating PoliceUK Data Instance.");
        getLastAPIUpdate();
    }


    /**
     * CASE-SENSITIVE DATA!
     * Gets a specific Neighbourhood by the Force and ID.
     * @param force Northamptonshire
     * @param neighbourhoodId SCT111
     * @return Neighbourhood Data
     * @throws IOException Jackson Error
     * @throws URISyntaxException API URI Building error
     */
    public Neighbourhood getNeighbourhood(final String force, final String neighbourhoodId) throws IOException, URISyntaxException {
        return OBJECT_MAPPER.readValue(PoliceAPI.specificNeighbourhood(force, neighbourhoodId), Neighbourhood.class);
    }

    public ArrayList<Neighbourhood> getNeighbourhoods(final String force) throws IOException, URISyntaxException {
        return OBJECT_MAPPER.readValue(PoliceAPI.forceNeighbourhoods(force),
                TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Neighbourhood.class));
    }

    public DetailedOutcome getDetailedOutcome(final String persistentId) throws IOException, URISyntaxException {
        return OBJECT_MAPPER.readValue(PoliceAPI.specificOutcome(persistentId), DetailedOutcome.class);
    }

    public ArrayList<Crime> getCrimeWithoutLocation(final DefinedCrimeCategory category,
                                                    final String force,
                                                    final String date) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.crimesWithoutLocation(category, force, date),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Crime.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Crime> getCrimeWithoutLocation(final DefinedCrimeCategory category, final String force) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.crimesWithoutLocation(category, force),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Crime.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Crime> getCrimeWithoutLocation(final String force, final String date) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.crimesWithoutLocation(force, date),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Crime.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Crime> getCrimeWithoutLocation(String force) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.crimesWithoutLocation(force),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Crime.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets crime outcome at the LAT:LNG specified, at the latest date provided.
     * @param latitude 1 Mile radius from this lat
     * @param longitude 1 Mile radius from this lng
     * @param date The date of which the crime was committed
     * @return Crime outcomes with-in a 1 Mile radius of this area.
     */
    public ArrayList<Outcome> getOutcomes(final String latitude, final String longitude, final String date) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.outcomesOfArea(latitude, longitude, date),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Outcome.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets crime outcome at the LAT:LNG specified, at the latest date provided by the API.
     * @param latitude 1 Mile radius from this lat
     * @param longitude 1 Mile radius from this lng
     * @return Crime outcomes with-in a 1 Mile radius of this area.
     */
    public ArrayList<Outcome> getOutcomes(final String latitude, final String longitude) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.outcomesOfArea(latitude, longitude,
                    lastAPIUpdate != null ? lastAPIUpdate.getDateSimple() : getLastAPIUpdate().getDateSimple()),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Outcome.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Outcome> getOutcomeByPolygon(final AreaPolygon poly, final String date) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.outcomesOfArea(poly, date),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Outcome.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList<Outcome> getOutcomeByPolygon(final AreaPolygon poly) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.outcomesOfArea(poly,
                    lastAPIUpdate != null ? lastAPIUpdate.getDateSimple() : getLastAPIUpdate().getDateSimple()),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Outcome.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Outcome> getOutcomesOnStreet(final String streetId, final String date) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.outcomesOnStreet(streetId, date),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Outcome.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Outcome> getOutcomesOnStreet(final String streetId) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.outcomesOnStreet(streetId,
                    lastAPIUpdate != null ? lastAPIUpdate.getDateSimple() : getLastAPIUpdate().getDateSimple()),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Outcome.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Crime> getCrimesOnNearbyStreet(final String latitude, final String longitude, final String date) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.crimesOnStreet(latitude, longitude, date),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Crime.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Crime> getCrimesOnNearbyStreet(final String latitude, final String longitude) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.crimesOnStreet(latitude, longitude,
                    lastAPIUpdate != null ? lastAPIUpdate.getDateSimple() : getLastAPIUpdate().getDateSimple()),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Crime.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Crime> getCrimesByStreetID(final String streetId, final String date) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.crimesOnStreet(streetId, date),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Crime.class));
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Crime> getCrimesByStreetID(final String streetId) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.crimesOnStreet(streetId,
                    lastAPIUpdate != null ? lastAPIUpdate.getDateSimple() : getLastAPIUpdate().getDateSimple()),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Crime.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets crime at the LAT:LNG specified, at the latest date provided.
     * @param latitude 1 Mile radius from this lat
     * @param longitude 1 Mile radius from this lng
     * @param date The date of which the crime was committed
     * @return Crimes with-in a 1 Mile radius of this area.
     */
    public ArrayList<Crime> getCrimes(final String latitude, final String longitude, final String date) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.streetCrimes(latitude, longitude, date),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Crime.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets crime at the LAT:LNG specified, at the latest date provided by the API.
     * @param latitude 1 Mile radius from this lat
     * @param longitude 1 Mile radius from this lng
     * @return Crimes with-in a 1 Mile radius of this area.
     */
    public ArrayList<Crime> getCrimes(final String latitude, final String longitude) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.streetCrimes(latitude, longitude,
                    lastAPIUpdate != null ? lastAPIUpdate.getDateSimple() : getLastAPIUpdate().getDateSimple()),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Crime.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Crime> getCrimesByPolygon(final AreaPolygon poly, final String date) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.streetCrimes(poly, date),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Crime.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Crime> getCrimesByPolygon(final AreaPolygon poly) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.streetCrimes(poly,
                    lastAPIUpdate != null ? lastAPIUpdate.getDateSimple() : getLastAPIUpdate().getDateSimple()),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Crime.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Priority> getNeighbourhoodEvents(final String force, final String hood) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.neighbourhoodEvent(force, hood),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Person.class));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList<Priority> getNeighbourhoodPriorities(final String force, final String hood) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.neighbourhoodPriorities(force, hood),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Person.class));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Person> getNeighbourhoodTeam(final String force, final String hood) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.neighbourhoodTeam(force, hood),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Person.class));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Person> getForceSeniors(final String force) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.forcesSeniors(force),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Person.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Force getSpecificForce(final String force) {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.specificForce(force), Force.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Force> getPoliceForces() {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.allForces(),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, Force.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList<CrimeCategory> getCategories(final String date) {
        LOGGER.info("Getting categories with date: {}", date);
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.crimeCategories(date),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, CrimeCategory.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<CrimeCategory> getCategories() {
        try {
            return OBJECT_MAPPER.readValue(PoliceAPI.crimeCategories(),
                    TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, CrimeCategory.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LastAPIUpdate getLastAPIUpdate() {
        try {
            lastAPIUpdate = OBJECT_MAPPER.readValue(PoliceAPI.lastUpdatedRecord(), LastAPIUpdate.class);
            LOGGER.info("API Last Updated: {}", lastAPIUpdate.date);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.lastAPIUpdate;
    }
}
