package eu.europeana.accessors;

import eu.europeana.exceptions.BadRequest;
import eu.europeana.exceptions.DoesNotExistException;
import eu.europeana.model.BoardsData;

import java.net.URISyntaxException;
import java.util.List;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
public interface MeAccessor {

    String getMe();

    BoardsData getAllBoards() throws BadRequest, DoesNotExistException;

    /** Retrieves all boards by requesting only the urls and then parsing the actual internal naming of each board.
     * @return List of all the boards internal names
     * @throws BadRequest
     * @throws DoesNotExistException
     * @throws URISyntaxException
     */
    public List<String> getAllBoardsInternalName() throws BadRequest, DoesNotExistException, URISyntaxException;

    /** Retrieves all boards by requesting only the name and creates a list out of them.
     * @return List of all the board diplay
     * @throws BadRequest
     * @throws DoesNotExistException
     * @throws URISyntaxException
     */
    public List<String> getAllBoardsDisplayName() throws BadRequest, DoesNotExistException, URISyntaxException;

    String getMyBoards();
    String getMySuggestedBoards();
    String getMyFollowers();
    String getMyFollowingBoards();
    String getMyLikedPins();

    /**
     * Release all resources
     */
    void close();
}
