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
public class Link {
    private String locale;
    private String title;
    @XmlElement(name = "site_name")
    private String siteName;
    private String description;
    private String favicon;

    public Link() {
    }

    public Link(String locale, String title, String siteName, String description, String favicon) {
        this.locale = locale;
        this.title = title;
        this.siteName = siteName;
        this.description = description;
        this.favicon = favicon;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }
}
