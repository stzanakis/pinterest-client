package eu.europeana.accessors.base;

import eu.europeana.accessors.BoardAccessor;
import eu.europeana.common.AccessorsManager;
import eu.europeana.model.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
public class BoardAccessorBase implements BoardAccessor {

    private static final Logger logger = LogManager.getLogger();
    private Client client = JerseyClientBuilder.newClient();
    URL accessorUrl;

    public BoardAccessorBase(String accessUrl) {
        logger.info("Initializing http client");
        try {
            this.accessorUrl = new URL(accessUrl);
        } catch (MalformedURLException e) {
            logger.fatal("Url is not valid: " + accessUrl);
            e.printStackTrace();
            return;
        }
        logger.info("Initialized http client with target url: {}", this.accessorUrl);
    }

    public String getBoardInformation(String user, String board) {
        WebTarget target = client.target(accessorUrl.toString());
        target = target.path(Constants.V1_PATH.getConstant()).path(Constants.BOARDS_PATH.getConstant())
                .path(user).path(board)
                .queryParam(Constants.ACCESS_TOKEN.getConstant(), AccessorsManager.getAccessToken())
                .queryParam(Constants.FIELDS.getConstant(), "id,name,url");
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        short status = (short) response.getStatus();
        System.out.println(response.readEntity(String.class));

        if (status == 200) {
//            CloudId cloudId = response.readEntity(CloudId.class);
//            logger.info("getCloudId: " + target.getUri() + ", response: " + status + ", Cloud Id with id: " + cloudId.getId() + " exists!");
//            return cloudId;
        }
        else{
//            String errorString = Tools.parseResponse(target.getUri().toString(), status, response);
//            logger.error(errorString);
//            switch (status)
//            {
//                case 404:
//                    throw new DoesNotExistException(errorString);
//                default:
//                    Tools.generalExceptionHandler(status, errorString);
//            }
            return null;
        }
        return null;
    }

    public String getPinsFromBoard(String user, String board) {
        WebTarget target = client.target(accessorUrl.toString());
        target = target.path(Constants.V1_PATH.getConstant()).path(Constants.BOARDS_PATH.getConstant())
                .path(user).path(board).path(Constants.PINS_PATH.getConstant())
                .queryParam(Constants.ACCESS_TOKEN.getConstant(), AccessorsManager.getAccessToken())
                .queryParam(Constants.FIELDS.getConstant(), "id,link,note,url");
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        short status = (short) response.getStatus();
        System.out.println(response.readEntity(String.class));

        if (status == 200) {
//            CloudId cloudId = response.readEntity(CloudId.class);
//            logger.info("getCloudId: " + target.getUri() + ", response: " + status + ", Cloud Id with id: " + cloudId.getId() + " exists!");
//            return cloudId;
        }
        else{
//            String errorString = Tools.parseResponse(target.getUri().toString(), status, response);
//            logger.error(errorString);
//            switch (status)
//            {
//                case 404:
//                    throw new DoesNotExistException(errorString);
//                default:
//                    Tools.generalExceptionHandler(status, errorString);
//            }
            return null;
        }
        return null;
    }

    public void close() {
        client.close();
    }
}
