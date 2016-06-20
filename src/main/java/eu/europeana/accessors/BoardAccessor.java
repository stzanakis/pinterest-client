package eu.europeana.accessors;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
public interface BoardAccessor {

    String getBoardInformation(String user, String board);
    String getPinsFromBoard(String user, String board);

    /**
     * Release all resources
     */
    void close();
}
