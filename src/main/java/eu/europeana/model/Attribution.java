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
public class Attribution {
    private String title;
    private String url;
    @XmlElement(name = "provider_icon_url")
    private String providerIconUrl;
    @XmlElement(name = "author_name")
    private String authorName;
    @XmlElement(name = "provider_favicon_url")
    private String providerFaviconUrl;
    @XmlElement(name = "author_url")
    private String authorUrl;
    @XmlElement(name = "provider_name")
    private String providerName;

    public Attribution() {
    }

    public Attribution(String title, String url, String providerIconUrl, String authorName, String providerFaviconUrl, String authorUrl, String providerName) {
        this.title = title;
        this.url = url;
        this.providerIconUrl = providerIconUrl;
        this.authorName = authorName;
        this.providerFaviconUrl = providerFaviconUrl;
        this.authorUrl = authorUrl;
        this.providerName = providerName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProviderIconUrl() {
        return providerIconUrl;
    }

    public void setProviderIconUrl(String providerIconUrl) {
        this.providerIconUrl = providerIconUrl;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getProviderFaviconUrl() {
        return providerFaviconUrl;
    }

    public void setProviderFaviconUrl(String providerFaviconUrl) {
        this.providerFaviconUrl = providerFaviconUrl;
    }

    public String getAuthorUrl() {
        return authorUrl;
    }

    public void setAuthorUrl(String authorUrl) {
        this.authorUrl = authorUrl;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
