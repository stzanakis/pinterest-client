package eu.europeana;


import eu.europeana.accessors.BoardAccessor;
import eu.europeana.accessors.MeAccessor;
import eu.europeana.common.AccessorsManager;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.PropertiesConfigurationLayout;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
public class Main {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws FileNotFoundException, ConfigurationException {
        logger.info("Started in Main");

        //INITIALIZE START
        PropertiesConfiguration propertiesConfiguration = new PropertiesConfiguration();
        PropertiesConfigurationLayout configurationPropertiesLayout = new PropertiesConfigurationLayout(propertiesConfiguration);
        File credentialsFile = new File(AccessorsManager.getDefaultPropertiesPath() + "/" + AccessorsManager.getCredentialsFileName());
        if(credentialsFile.exists())
            configurationPropertiesLayout.load(new FileReader(credentialsFile));
        else
            configurationPropertiesLayout.load(new FileReader(Main.class.getClassLoader().getResource(AccessorsManager.getCredentialsFileName()).getFile()));

        AccessorsManager accessorsManager = new AccessorsManager();
        accessorsManager.initializeAllAccessors(propertiesConfiguration.getProperty(AccessorsManager.getAccessUrl_key()).toString());
        MeAccessor meAccessor = accessorsManager.getMeAccessor();
        BoardAccessor boardAccessor = accessorsManager.getBoardAccessor();
        //INITIALIZE END


        //PLAYGROUND START

//        System.out.println(boardAccessor.getBoardInformation("europeana", "Heroes"));
        System.out.println(boardAccessor.getPinsFromBoard("simontzanakis", "Places"));

        //PLAYGROUND END


        //CLOSE START
        accessorsManager.closeAllAccessors();
        //CLOSE END

        logger.info("Ended in Main");
    }
}
