package blokhina.epam.com.factory.parser.impl;

import blokhina.epam.com.factory.Power;
import blokhina.epam.com.factory.parser.AbstractParser;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


import java.io.IOException;
import java.util.List;

/**
 * Created by Yevheniia_Blokhina on 5/6/2015.
 */
public class PowerJDOMParser extends AbstractParser {

    @Override
    public List<Power> parseDocument(String xmlPath) {
        try {
            SAXBuilder builder = new SAXBuilder();
            Power power;
            Power.TechnicalCharacteristics tc;
            Document document = (Document) builder.build(xmlPath);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("tool");

            for (int i = 0; i < list.size(); i++) {
                power = new Power();
                tc = power.new TechnicalCharacteristics();
                Element node = (Element) list.get(i);
                power.setName(node.getChildText("name"));
                power.setModel(node.getChildText("model"));
                power.setOrigin(node.getChildText("origin"));
                power.setHandly(Integer.parseInt(node.getChildText("handly")));

                tc.setAutomation(Boolean.parseBoolean(node.getChild("technical_characteristics").getChildText("automation")));
                tc.setPowerConsumption(Integer.parseInt(node.getChild("technical_characteristics").getChildText("power_consumption")));
                tc.setProductivity(Integer.parseInt(node.getChild("technical_characteristics").getChildText("productivity")));
                power.setTc(tc);
                powerTools.add(power);
            }
            return powerTools;

        } catch (IOException io) {
            System.out.println(io.getMessage());

        } catch (JDOMException jdomex) {
            System.out.println(jdomex.getMessage());
        }
        return null;

    }
}
