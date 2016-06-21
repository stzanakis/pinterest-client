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
public class Place {
    private String category;
    private String name;
    private String locality;
    private String country;
    private String region;
    private double longitude;
    @XmlElement(name = "source_url")
    private String sourceUrl;
    private String street;
    @XmlElement(name = "post_code")
    private String postCode;
    private double latitude;

    public Place() {
    }

    public Place(String category, String name, String locality, String country, String region, double longitude, String sourceUrl, String street, String postCode, double latitude) {
        this.category = category;
        this.name = name;
        this.locality = locality;
        this.country = country;
        this.region = region;
        this.longitude = longitude;
        this.sourceUrl = sourceUrl;
        this.street = street;
        this.postCode = postCode;
        this.latitude = latitude;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
