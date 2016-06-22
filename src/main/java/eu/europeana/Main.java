package eu.europeana;


import eu.europeana.accessors.BoardAccessor;
import eu.europeana.accessors.MeAccessor;
import eu.europeana.common.AccessorsManager;
import eu.europeana.exceptions.BadRequest;
import eu.europeana.exceptions.DoesNotExistException;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
public class Main {
    private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws FileNotFoundException, ConfigurationException, DoesNotExistException, BadRequest, URISyntaxException {
        logger.info("Started in Main");

        //INITIALIZE START
        AccessorsManager am = new AccessorsManager("/data/credentials/pinterest-client");

        am.initializeAllAccessors();
        MeAccessor meAccessor = am.getMeAccessor();
        BoardAccessor boardAccessor = am.getBoardAccessor();
        //INITIALIZE END


        //PLAYGROUND START

//        System.out.println(boardAccessor.getBoardInformation("europeana", "Heroes"));
//        System.out.println(boardAccessor.getPinsFromBoard("simontzanakis", "Places"));
//        System.out.println(boardAccessor.getPinsFromBoard("europeana", "Heroes"));

//        System.out.println(boardAccessor.getAllMyBoards());

        System.out.println(meAccessor.getAllMyBoardsDisplayName());
        //PLAYGROUND END


        //CLOSE START
        am.closeAllAccessors();
        //CLOSE END

        logger.info("Ended in Main");
    }
}
