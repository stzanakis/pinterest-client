package eu.europeana.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedHashMap;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Metadata {
    private LinkedHashMap<String, Object> metadata;

    public Metadata() {
    }

    public Metadata(LinkedHashMap<String, Object> metadata) {
        this.metadata = metadata;
    }

    public LinkedHashMap<String, Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(LinkedHashMap<String, Object> metadata) {
        this.metadata = metadata;
    }
}
