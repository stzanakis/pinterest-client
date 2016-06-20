package eu.europeana.model;

import eu.europeana.common.Tools;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardCounts {
    private long pins;
    private long collaborators;
    private long followers;

    public BoardCounts() {
    }

    public BoardCounts(long pins, long collaborators, long followers) {
        this.pins = pins;
        this.collaborators = collaborators;
        this.followers = followers;
    }

    public long getPins() {
        return pins;
    }

    public void setPins(long pins) {
        this.pins = pins;
    }

    public long getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(long collaborators) {
        this.collaborators = collaborators;
    }

    public long getFollowers() {
        return followers;
    }

    public void setFollowers(long followers) {
        this.followers = followers;
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
