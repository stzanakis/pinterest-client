package eu.europeana.accessors;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
public interface MeAccessor {

    String getMe();
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
