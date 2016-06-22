package eu.europeana.common;

import eu.europeana.accessors.BoardAccessor;
import eu.europeana.accessors.MeAccessor;
import eu.europeana.accessors.base.BoardAccessorBase;
import eu.europeana.accessors.base.MeAccessorBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
public class AccessorsManager {
    private static final Logger logger = LogManager.getLogger();
    private final static String accessUrl_key = "accessUrl";
    private static String defaultPropertiesPath;
    private final static String configurationFileName = "configuration-pinterest.properties";
    private final static String accessTokenFileName = "access_token.txt";
    private MeAccessor meAccessor;
    private BoardAccessor boardAccessor;

    public AccessorsManager(String defaultPropertiesPath) {
        this.defaultPropertiesPath = defaultPropertiesPath;
    }

    public void initializeAllAccessors(String accessUrl)
    {
        logger.info("Initializing all http clients");
        meAccessor = new MeAccessorBase(accessUrl);
        boardAccessor = new BoardAccessorBase(accessUrl);
        logger.info("Initialized all http clients");
    }

    public void closeAllAccessors()
    {
        logger.info("Closing all http clients");
        meAccessor.close();
        boardAccessor.close();
        logger.info("Closing all http clients");
    }

    public static String getAccessToken() {
        String access_token = null;
        try {
            BufferedReader brTest = new BufferedReader(new FileReader(new File(defaultPropertiesPath + "/" + AccessorsManager.getAccessTokenFileName())));
            access_token = brTest .readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return access_token;
    }

    public MeAccessor getMeAccessor() {
        return meAccessor;
    }

    public BoardAccessor getBoardAccessor() {
        return boardAccessor;
    }

    public static String getAccessUrl_key() {
        return accessUrl_key;
    }

    public static String getDefaultPropertiesPath() {
        return defaultPropertiesPath;
    }

    public static String getConfigurationFileName() {
        return configurationFileName;
    }

    public static String getAccessTokenFileName() {
        return accessTokenFileName;
    }
}
