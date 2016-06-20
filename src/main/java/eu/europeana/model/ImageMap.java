package eu.europeana.model;

import javax.xml.bind.annotation.*;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
@XmlSeeAlso({ Image.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageMap {
    @XmlElements(value = {
            @XmlElement(name="60x60",
                    type=Image.class),
            @XmlElement(name="original",
                    type=Image.class)
    })
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
