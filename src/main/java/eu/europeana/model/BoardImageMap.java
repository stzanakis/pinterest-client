package eu.europeana.model;

import eu.europeana.common.Tools;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardImageMap {
    @XmlElement(name="60x60")
    private Image image;

    public BoardImageMap() {
    }

    public BoardImageMap(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
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
