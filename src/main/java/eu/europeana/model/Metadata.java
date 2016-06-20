package eu.europeana.model;

import eu.europeana.common.Tools;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
import java.util.LinkedHashMap;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
@XmlRootElement
//@JsonIgnoreProperties(ignoreUnknown = true)
@XmlAccessorType(XmlAccessType.FIELD)
public class Metadata {
//    @XmlElements(value = {
//            @XmlElement(name="place"),
//            @XmlElement(name="link")
//    })
    private LinkedHashMap<String, String> metadata;

    public Metadata() {
    }

    public Metadata(LinkedHashMap<String, String> metadata) {
        this.metadata = metadata;
    }

    public LinkedHashMap<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(LinkedHashMap<String, String> metadata) {
        this.metadata = metadata;
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
