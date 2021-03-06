package eu.europeana.model;

import eu.europeana.common.Tools;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Board {
    private String id;
    private String name;
    private String url;
    private String description;
    private Creator creator;
    @XmlElement(name = "created_at")
    private String createdAt;
    private String privacy;
    private String reason;
    @XmlElement(name = "counts")
    private BoardCounts boardCounts;
    private BoardImageMap image;

    public Board() {
    }

    public Board(String id, String name, String url, String description, Creator creator, String createdAt, String privacy, String reason, BoardCounts boardCounts, BoardImageMap image) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.description = description;
        this.creator = creator;
        this.createdAt = createdAt;
        this.privacy = privacy;
        this.reason = reason;
        this.boardCounts = boardCounts;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BoardCounts getBoardCounts() {
        return boardCounts;
    }

    public void setBoardCounts(BoardCounts boardCounts) {
        this.boardCounts = boardCounts;
    }

    public BoardImageMap getImage() {
        return image;
    }

    public void setImage(BoardImageMap image) {
        this.image = image;
    }

    @Override
    public String toString() {
        try {
            return Tools.marshallAny(this);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return "";
    }
}

