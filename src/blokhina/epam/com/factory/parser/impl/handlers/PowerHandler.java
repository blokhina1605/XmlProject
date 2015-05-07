package blokhina.epam.com.factory.parser.impl.handlers;

import blokhina.epam.com.factory.Power;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevheniia_Blokhina on 5/6/2015.
 */
public class PowerHandler extends DefaultHandler {


    private List<Power> powers = new ArrayList<>();
    private Power tempPower;
    private String contentHolder;
    private Power.TechnicalCharacteristics tc;

    public List<Power> getPowers() {
        return powers;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attr) {
        if (qName.equals("tool")) {
            tempPower = new Power();
        }
        if (qName.equals("technical_characteristics")) {
            tc = tempPower.new TechnicalCharacteristics();;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "model":
                tempPower.setModel(contentHolder);
                break;
            case "origin":
                tempPower.setOrigin(contentHolder);
                break;
            case "name":
                tempPower.setName(contentHolder);
                break;
            case "handly":
                tempPower.setHandly(Integer.parseInt(contentHolder));
                break;
            case "productivity":
                tc.setProductivity(Integer.parseInt(contentHolder));
                break;
            case "power_consumption":
                tc.setPowerConsumption(Integer.parseInt(contentHolder));
                break;
            case "automation":
                tc.setAutomation(Boolean.parseBoolean(contentHolder));
                break;
            case "technical_characteristics":
                tempPower.setTc(tc);
                break;
            case "tool":
                powers.add(tempPower);
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        contentHolder = String.valueOf(ch, start, length);
    }
}
