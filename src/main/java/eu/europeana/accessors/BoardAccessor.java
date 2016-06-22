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
    PinsData getPinsFromBoard(String user, String board) throws DoesNotExistException, BadRequest;
    PinsData getPinsFromBoard(URL url) throws DoesNotExistException, BadRequest;
    PinsData getAllPinsFromBoard(String user, String board) throws DoesNotExistException, BadRequest, MalformedURLException;

    /**
     * Release all resources
     */
    void close();
}
