package eu.europeana.accessors;

import eu.europeana.exceptions.BadRequest;
import eu.europeana.exceptions.DoesNotExistException;
import eu.europeana.model.BoardsData;
import eu.europeana.model.PinsData;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
public interface BoardAccessor {

    String getBoardInformation(String user, String board);
    BoardsData getAllBoards() throws BadRequest, DoesNotExistException;
    PinsData getPinsFromBoard(String user, String board) throws DoesNotExistException, BadRequest;

    /**
     * Release all resources
     */
    void close();
}
