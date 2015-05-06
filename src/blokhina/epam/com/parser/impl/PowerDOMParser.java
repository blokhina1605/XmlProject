package blokhina.epam.com.parser.impl;

import blokhina.epam.com.Power;
import blokhina.epam.com.parser.AbstractParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yevheniia_Blokhina on 5/6/2015.
 */
public class PowerDOMParser extends AbstractParser {
    @Override
    public List<Power> parseDocument(String xmlPath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlPath);
            Element root = document.getDocumentElement();
            NodeList nodeList = root.getChildNodes();
            parsePowerList(nodeList);
            return powerTools;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void parsePowerList(NodeList planesNodeList) {
        {
            try {

                for (int tmp = 0; tmp < planesNodeList.getLength(); tmp++) {
                    Power temp = new Power();
                    Power.TechnicalCharacteristics tc = temp.new TechnicalCharacteristics();
                    Node node = planesNodeList.item(tmp);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;


                        temp.setName(element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue());
                        temp.setModel(element.getElementsByTagName("model").item(0).getChildNodes().item(0).getNodeValue());
                        temp.setOrigin(element.getElementsByTagName("origin").item(0).getChildNodes().item(0).getNodeValue());
                        tc.setAutomation(Boolean.parseBoolean(element.getElementsByTagName("automation").item(0).getChildNodes().item(0).getNodeValue()));
                        tc.setPowerConsumption(Integer.parseInt(element.getElementsByTagName("power_consumption").item(0).getChildNodes().item(0).getNodeValue()));
                        tc.setProductivity(Integer.parseInt(element.getElementsByTagName("productivity").item(0).getChildNodes().item(0).getNodeValue()));
                        temp.setTc(tc);


                        powerTools.add(temp);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
                e.printStackTrace();
            }
        }

    }
}
