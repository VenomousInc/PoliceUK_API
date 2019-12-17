package com.github.venomousinc.policeuk.util;

/**
 * @author VenomousInc
 * @since 06/05/2019
 */
public enum DefinedCrimeCategory {
    ALL_CRIME("all-crime")
    ,ANTI_SOCIAL_BEHAVIOUR("anti-social-behaviour")
    ,BICYCLE_THEFT("bicycle-theft")
    ,BURGLARY("burglary")
    ,CRIMINAL_DAMAGE_AND_ARSON("criminal-damage-arson")
    ,DRUGS("drugs")
    ,OTHER_THEFT("other-theft")
    ,POSSESSION_OF_WEAPONS("possession-of-weapons")
    ,PUBLIC_ORDER("public-order")
    ,ROBBERY("robbery")
    ,SHOPLIFTING("shoplifting")
    ,THEFT_FROM_THE_PERSON("theft-from-the-person")
    ,VEHICLE_CRIME("vehicle-crime")
    ,VIOLENCE_AND_SEXUAL_OFFENCES("violent-crime")
    ,OTHER_CRIME("other-crime");

    public final String URL;

    DefinedCrimeCategory(final String URL) {
        this.URL = URL;
    }

    /**
     * This is not URL, this converts {@link DefinedCrimeCategory} instance {@link DefinedCrimeCategory#name()}
     * @return Lowercase, underscores replaced with spaces.
     */
    public String getHumanizedName() {
        return name().toLowerCase().replaceAll("-_", " ");
    }

    public String toPrettyPrint() {
        return String.format("Crime: %s" +
                "%nURL: %s", getHumanizedName(), URL);
    }
    @Override
    public String toString() {
        return URL;
    }
}
