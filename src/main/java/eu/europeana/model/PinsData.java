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
public class PinsData {
    @XmlElement(name = "data")
    private Pin[] pins;

    public PinsData() {
    }

    public PinsData(Pin[] pins) {
        this.pins = pins;
    }

    public Pin[] getPins() {
        return pins;
    }

    public void setPins(Pin[] pins) {
        this.pins = pins;
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
