package eu.europeana.accessors;

import eu.europeana.exceptions.BadRequest;
import eu.europeana.exceptions.DoesNotExistException;
import eu.europeana.model.PinsData;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
public interface BoardAccessor {

    String getBoardInformation(String user, String board);

    /** Retrieves Pins from a specific User and Board. Returns only a set of pins.
     * @param user
     * @param board
     * @return {@link PinsData}
     * @throws DoesNotExistException
     * @throws BadRequest
     */
    PinsData getPinsFromBoard(String user, String board) throws DoesNotExistException, BadRequest;

    /** Retrieves Pins from a provided URL. Used mostly for collecting all pins with multiple calls.
     * @param url
     * @return
     * @throws DoesNotExistException
     * @throws BadRequest
     */
    PinsData getPinsFromBoard(URL url) throws DoesNotExistException, BadRequest;

    /** Retrieves all Pins from a specific User and Board. Makes multiple calls using pagination.
     * @param user
     * @param board
     * @return
     * @throws DoesNotExistException
     * @throws BadRequest
     * @throws MalformedURLException
     */
    PinsData getAllPinsFromBoard(String user, String board) throws DoesNotExistException, BadRequest, MalformedURLException;

    /**
     * Release all resources
     */
    void close();
}
