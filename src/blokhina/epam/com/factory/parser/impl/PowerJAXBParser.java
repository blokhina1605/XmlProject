package blokhina.epam.com.factory.parser.impl;

import blokhina.epam.com.factory.Power;
import blokhina.epam.com.factory.parser.AbstractParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

/**
 * Created by Yevheniia_Blokhina on 5/7/2015.
 */
public class PowerJAXBParser extends AbstractParser {
//
//    @XmlRootElement
//    public class javism_jaxb {
//        String name;
//        int age;
//        int id;
//
//        public String getName() {
//            return name;
//        }
//
//        @XmlElement
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        @XmlElement
//        public void setAge(int age) {
//            this.age = age;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//    }

    @Override
    public List<Power> parseDocument(String xmlPath) {
//        try {
//            File file = new File(xmlPath);
//            JAXBContext jaxbContext = JAXBContext.newInstance(javism_jaxb.class);
//
//            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//            javism_jaxb customer = (javism_jaxb) jaxbUnmarshaller.unmarshal(file);
//
//            System.out.println("Customer: " + customer.getName() +
//                    "(id='" + customer.getId() +
//                    "',age='" + customer.getAge() +
//                    "')");
//            return null;
//        } catch (JAXBException jaxbe) {
//            System.out.println(jaxbe.getLocalizedMessage());
//            jaxbe.printStackTrace();
//            return null;
//        }
        return null;
    }

}

