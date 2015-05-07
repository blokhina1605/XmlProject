package blokhina.epam.com.factory.parser.impl;

import blokhina.epam.com.factory.Power;
import blokhina.epam.com.factory.parser.AbstractParser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * Created by Yevheniia_Blokhina on 5/6/2015.
 */
public class PowerStAXParser extends AbstractParser {

    private Power tempPower;
    private Power.TechnicalCharacteristics tc;

    @Override
    public List<Power> parseDocument(String xmlPath) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(xmlPath));
            parsePlanesList(reader);
            return powerTools;
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void parsePlanesList(XMLStreamReader reader) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    String localName = reader.getLocalName();
                    switch (localName) {
                        case "tool":
                            tempPower = new Power();
                            break;
                        case "model":
                            tempPower.setModel(reader.getElementText());
                            break;
                        case "origin":
                            tempPower.setOrigin(reader.getElementText());
                            break;
                        case "name":
                            tempPower.setName(reader.getElementText());
                            break;
                        case "technical_characteristics":
                            tc = tempPower.new TechnicalCharacteristics();
                            tempPower.setTc(tc);
                            break;
                        case "power_consumption":
                            tc.setPowerConsumption(Integer.parseInt(reader.getElementText()));
                            break;
                        case "productivity":
                            tc.setProductivity(Integer.parseInt(reader.getElementText()));
                            break;
                        case "handly":
                            tempPower.setHandly(Integer.parseInt(reader.getElementText()));
                            break;
                        case "automation":
                            tc.setAutomation(Boolean.parseBoolean(reader.getElementText()));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    localName = reader.getLocalName();
                    switch (localName) {
                        case "tool":
                            powerTools.add(tempPower);
                            break;
                        case "technical_characteristics":
                            tempPower.setTc(tc);
                            break;
                    }
                    break;
            }
        }
    }
}
