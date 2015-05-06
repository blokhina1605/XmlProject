package blokhina.epam.com.parser.impl;

import blokhina.epam.com.Power;
import blokhina.epam.com.parser.AbstractParser;
import blokhina.epam.com.parser.handlers.PowerHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yevheniia_Blokhina on 5/6/2015.
 */
public class PowerSAXParser extends AbstractParser {
    @Override
    public List<Power> parseDocument(String xmlPath) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            PowerHandler handler = new PowerHandler();
            parser.parse(xmlPath, handler);
            return handler.getPowers();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
