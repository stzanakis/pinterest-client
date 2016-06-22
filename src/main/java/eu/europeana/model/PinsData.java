package eu.europeana.model;

import eu.europeana.common.Tools;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PinsData {
    @XmlElement(name = "data")
    private ArrayList<Pin> pins;
    private Page page;

    public PinsData() {
    }

    public PinsData(ArrayList<Pin> pins, Page page) {
        this.pins = pins;
        this.page = page;
    }

    public ArrayList<Pin> getPins() {
        return pins;
    }

    public void setPins(ArrayList<Pin> pins) {
        this.pins = pins;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
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
