package blokhina.epam.com.factory.parser.impl;

import blokhina.epam.com.factory.Power;
import blokhina.epam.com.factory.parser.AbstractParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevheniia_Blokhina on 5/7/2015.
 */
public class PowerJAXBParser{


    public List<PowerJAXB> parseDocument(String xmlPath) {
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(PowerJAXBWrapper.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            PowerJAXBWrapper powerList = (PowerJAXBWrapper) unmarshaller.unmarshal(new File(xmlPath));
            List<PowerJAXB> po = (List<PowerJAXB>) powerList.getPowerJAXBList();

//            Marshaller marshaller = jc.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.marshal(power, System.out);
        return po;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}

@XmlRootElement(name = "powerTools")
@XmlAccessorType(XmlAccessType.FIELD)
class PowerJAXBWrapper {

    @XmlElement(name = "tool")
    private List<PowerJAXB> powerJAXBList = new ArrayList<>();

    public List<PowerJAXB> getPowerJAXBList() {
        return powerJAXBList;
    }
}

@XmlRootElement(name = "tool")
@XmlAccessorType(XmlAccessType.FIELD)
class PowerJAXB {

    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "model")
    private String model;
    @XmlElement(name = "origin")
    private String origin;
    @XmlElement(name = "handly")
    private int handly;

    @XmlElement(name = "technical_characteristics")
    private TechnicalCharacteristicsJAXB tc = new TechnicalCharacteristicsJAXB();

    @Override
    public String toString() {
        return "\nPower{" +
                name +
                " " + model + " " + handly +
                "-handed" +
                ", origin=" + origin +
                ". " + tc +

                "}";
    }

//    public TechnicalCharacteristicsJAXB getTc() {
//        return tc;
//    }
//
//    public void setTc(TechnicalCharacteristicsJAXB tc) {
//        this.tc = tc;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getModel() {
//        return model;
//    }
//
//    public void setModel(String model) {
//        this.model = model;
//    }
//
//    public String getOrigin() {
//        return origin;
//    }
//
//    public int getHandly() {
//        return handly;
//    }
//
//    public void setHandly(int handly) {
//        this.handly = handly;
//    }
//
//    public void setOrigin(String origin) {
//        this.origin = origin;
//    }

}

@XmlRootElement(name = "technical_characteristics")
@XmlAccessorType(XmlAccessType.FIELD)
class TechnicalCharacteristicsJAXB {
    @XmlElement(name = "power_consumption")
    private int powerConsumption;
    @XmlElement(name = "productivity")
    private int productivity;
    @XmlElement(name = "automation")
    private boolean automation;

    @Override
    public String toString() {
        return "Technical characteristics{" +
                "power consumption: " + powerConsumption + " W, " +
                "productivity: " + productivity + " rpm" +
                ", automation: " + automation +
                "}";
    }

//    public int getPowerConsumption() {
//        return powerConsumption;
//    }
//
//    public void setPowerConsumption(int powerConsumption) {
//        this.powerConsumption = powerConsumption;
//    }
//
//    public int getProductivity() {
//        return productivity;
//    }
//
//    public void setProductivity(int productivity) {
//        this.productivity = productivity;
//    }
//
//    public boolean isAutomation() {
//        return automation;
//    }
//
//    public void setAutomation(boolean automation) {
//        this.automation = automation;
//    }
}

