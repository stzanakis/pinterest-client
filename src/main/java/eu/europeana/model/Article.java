package eu.europeana.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-21
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Article {
    @XmlElement(name = "published_at")
    private String publishedAt;
    private String description;
    private String name;
    private String[] authors;

    public Article() {
    }

    public Article(String publishedAt, String description, String name, String[] authors) {
        this.publishedAt = publishedAt;
        this.description = description;
        this.name = name;
        this.authors = authors;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }
}
