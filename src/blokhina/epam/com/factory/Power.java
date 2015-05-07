package blokhina.epam.com.factory;

/**
 * Created by Yevheniia_Blokhina on 5/6/2015.
 */
public class Power {
    private String name;
    private String model;
    private String origin;
    private int handly;

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

    public class TechnicalCharacteristics {
        private int powerConsumption;
        private int productivity;
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
