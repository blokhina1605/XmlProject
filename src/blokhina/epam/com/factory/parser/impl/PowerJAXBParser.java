package blokhina.epam.com.factory.parser.impl;

import blokhina.epam.com.factory.Power;
import blokhina.epam.com.factory.parser.AbstractParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

/**
 * Created by Yevheniia_Blokhina on 5/7/2015.
 */
public class PowerJAXBParser extends AbstractParser {


    @Override
    public List<Power> parseDocument(String xmlPath) {
//        JAXBContext jc = null;
//        try {
//            jc = JAXBContext.newInstance(Power.class);
//
//            Unmarshaller unmarshaller = jc.createUnmarshaller();
//            Power power = (Power) unmarshaller.unmarshal(new File(xmlPath));
//
//            Marshaller marshaller = jc.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(power, System.out);
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
        return null;
    }
}

