package eu.europeana.model;

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
public class Pin {
    private String id;
    private String link;
    private String url;
    private Creator creator;
    private Board board;
    @XmlElement(name = "original_link")
    private String originalLink;
    @XmlElement(name = "created_at")
    private String createdAt;
    private String note;
    private String color;
    @XmlElement(name = "counts")
    private PinCounts pinCounts;
    private Media media;
    private Attribution attribution;
    private PinImageMap image;
    private Metadata metadata;

    public Pin() {
    }

    public Pin(String id, String link, String url, Creator creator, Board board, String originalLink, String createdAt, String note, String color, PinCounts pinCounts, Media media, Attribution attribution, PinImageMap image, Metadata metadata) {
        this.id = id;
        this.link = link;
        this.url = url;
        this.creator = creator;
        this.board = board;
        this.originalLink = originalLink;
        this.createdAt = createdAt;
        this.note = note;
        this.color = color;
        this.pinCounts = pinCounts;
        this.media = media;
        this.attribution = attribution;
        this.image = image;
        this.metadata = metadata;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PinCounts getPinCounts() {
        return pinCounts;
    }

    public void setPinCounts(PinCounts pinCounts) {
        this.pinCounts = pinCounts;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Attribution getAttribution() {
        return attribution;
    }

    public void setAttribution(Attribution attribution) {
        this.attribution = attribution;
    }

    public PinImageMap getImage() {
        return image;
    }

    public void setImage(PinImageMap image) {
        this.image = image;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }
}
