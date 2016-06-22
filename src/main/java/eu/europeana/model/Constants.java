package eu.europeana.model;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-05-25
 */
public enum Constants {
    V1_PATH("v1"),
    ME_PATH("me"),
    BOARDS_PATH("boards"),
    PINS_PATH("pins"),
    FOLLOWERS_PATH("followers"),
    ACCESS_TOKEN("access_token"),
    LIMIT("limit"),
    FIELDS("fields");

    private String constant;

    Constants(String constant) {
        this.constant = constant;
    }

    public String getConstant() {
        return constant;
    }
}
