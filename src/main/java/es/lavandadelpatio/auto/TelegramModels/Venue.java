package es.lavandadelpatio.auto.TelegramModels;

import javax.persistence.Entity;
import java.util.Optional;

/**
 * Created by raulm on 08/07/2017.
 */
public class Venue {

    /**
     * Venue location
     */
    Location location;


    /**
     * 	Name of the venue
     */
    String title;


    /**
     * Address of the venue
     */
    String address;


    /**
     * Foursquare identifier of the venue
     */
    Optional<String> foursquare_id;
}
