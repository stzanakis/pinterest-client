package eu.europeana.model;

import javax.xml.bind.annotation.*;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageMap {
    @XmlElement(name = "60x60")
    private Image image;

    public ImageMap() {
    }

    public ImageMap(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
