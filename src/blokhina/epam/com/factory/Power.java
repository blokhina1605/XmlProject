package blokhina.epam.com.factory;

import javax.xml.bind.annotation.*;

/**
 * Created by Yevheniia_Blokhina on 5/6/2015.
 */

@XmlRootElement(name = "powerTools")
@XmlAccessorType(XmlAccessType.FIELD)
public class Power {

    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "model")
    private String model;
    @XmlElement(name = "origin")
    private String origin;
    @XmlElement(name = "handly")
    private int handly;

    @XmlElement(name = "technical_characteristics")
    private TechnicalCharacteristics tc = new TechnicalCharacteristics();

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

    @XmlRootElement(name = "technical_characteristics")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class TechnicalCharacteristics {
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

        public int getPowerConsumption() {
            return powerConsumption;
        }

        public void setPowerConsumption(int powerConsumption) {
            this.powerConsumption = powerConsumption;
        }

        public int getProductivity() {
            return productivity;
        }

        public void setProductivity(int productivity) {
            this.productivity = productivity;
        }

        public boolean isAutomation() {
            return automation;
        }

        public void setAutomation(boolean automation) {
            this.automation = automation;
        }
    }

    public TechnicalCharacteristics getTc() {
        return tc;
    }

    public void setTc(TechnicalCharacteristics tc) {
        this.tc = tc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOrigin() {
        return origin;
    }

    public int getHandly() {
        return handly;
    }

    public void setHandly(int handly) {
        this.handly = handly;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
