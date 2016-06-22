package eu.europeana.accessors.base;

import eu.europeana.accessors.BoardAccessor;
import eu.europeana.common.AccessorsManager;
import eu.europeana.exceptions.BadRequest;
import eu.europeana.exceptions.DoesNotExistException;
import eu.europeana.model.BoardData;
import eu.europeana.model.Constants;
import eu.europeana.model.Page;
import eu.europeana.model.PinsData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.jersey.client.JerseyClientBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
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
//                .queryParam(Constants.FIELDS.getConstant(), "id,name,url");
                .queryParam(Constants.FIELDS.getConstant(), "id,name,url,counts,created_at,creator,description,image,privacy,reason");
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        short status = (short) response.getStatus();
//        System.out.println(response.readEntity(String.class));
        BoardData boardData = response.readEntity(new GenericType<BoardData>() {});
        System.out.println(boardData.getBoard());

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

    public PinsData getAllPinsFromBoard(String user, String board) throws DoesNotExistException, BadRequest, MalformedURLException {
        PinsData allpinsFromBoard = getPinsFromBoard(user, board);
        Page page = allpinsFromBoard.getPage();
        String next = allpinsFromBoard.getPage().getNext();
        while(page != null && next != null) {
                logger.debug("In page next");
                PinsData pinsFromBoard = getPinsFromBoard(new URL(next));
                allpinsFromBoard.getPins().addAll(pinsFromBoard.getPins());
                page = pinsFromBoard.getPage();
                if(page != null)
                    next = page.getNext();
        }
        if(page != null || next != null)
            allpinsFromBoard.setPage(new Page(null, null));

        return allpinsFromBoard;
    }

    public PinsData getPinsFromBoard(URL url) throws DoesNotExistException, BadRequest {
        WebTarget target = client.target(url.toString());
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        short status = (short) response.getStatus();

        if (status == 200) {
            PinsData pinsData = response.readEntity(PinsData.class);
            logger.info("getPinsFromBoard: " + target.getUri() + ", response: " + status + ", returned a list of results!");
            return pinsData;
        }
        else{
            String errorString = response.readEntity(String.class);
            logger.error(errorString);
            switch (status)
            {
                case 400:
                    throw new BadRequest(errorString);
                case 404:
                    throw new DoesNotExistException(errorString);
            }
            return null;
        }
    }

    public PinsData getPinsFromBoard(String user, String board) throws DoesNotExistException, BadRequest {
        WebTarget target = client.target(accessorUrl.toString());
        target = target.path(Constants.V1_PATH.getConstant()).path(Constants.BOARDS_PATH.getConstant())
                .path(user).path(board).path(Constants.PINS_PATH.getConstant())
                .queryParam(Constants.ACCESS_TOKEN.getConstant(), AccessorsManager.getAccessToken())
//                .queryParam(Constants.FIELDS.getConstant(), "id,link,note,url");
                .queryParam(Constants.FIELDS.getConstant(), "id,link,note,url,original_link,attribution,board,color,counts,created_at,creator,image,media,metadata");
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        short status = (short) response.getStatus();
//        System.out.println(response.readEntity(String.class));

//        PinsData pinsData = response.readEntity(new GenericType<PinsData>() {
//        });

//        System.out.println(status);
//        System.out.println(response.getHeaders());
//        System.out.println(pinsData);

//        System.out.println(pinsData.getPins()[0].getMetadata().getMetadata().toString());

        if (status == 200) {
            PinsData pinsData = response.readEntity(PinsData.class);
            logger.info("getPinsFromBoard: " + target.getUri() + ", response: " + status + ", returned a list of results!");
            return pinsData;
        }
        else{
            String errorString = response.readEntity(String.class);
            logger.error(errorString);
            switch (status)
            {
                case 400:
                    throw new BadRequest(errorString);
                case 404:
                    throw new DoesNotExistException(errorString);
            }
            return null;
        }
    }

    public void close() {
        logger.info("Closing http client");
        client.close();
        logger.info("Closing http client with target url: {}", this.accessorUrl);
    }
}
