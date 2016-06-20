package eu.europeana.common;

import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.MarshallerProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * @author Simon Tzanakis (Simon.Tzanakis@europeana.eu)
 * @since 2016-06-20
 */
public class Tools{

        public static String marshallAny(Object object) throws JAXBException {

            JAXBContext jaxbContext =   JAXBContextFactory.createContext(new Class[]{object.getClass()}, null);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

//        System.out.println(jaxbContext);

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(MarshallerProperties.JSON_INCLUDE_ROOT, false);

//        jaxbMarshaller.marshal(customer, file);
//        jaxbMarshaller.marshal(dataProvider, System.out);

            jaxbMarshaller.setProperty("eclipselink.media-type", "application/json");
            StringWriter stringWriter = new StringWriter();
            jaxbMarshaller.marshal(object,stringWriter);

            return stringWriter.toString();
        }
}
