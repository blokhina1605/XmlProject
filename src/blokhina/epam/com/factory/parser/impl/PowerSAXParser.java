package blokhina.epam.com.factory.parser.impl;

import blokhina.epam.com.factory.Power;
import blokhina.epam.com.factory.parser.AbstractParser;
import blokhina.epam.com.factory.parser.impl.handlers.PowerHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
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
            PowerHandler saxp = new PowerHandler();
            parser.parse(xmlPath, saxp);
            return saxp.getPowers();
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            ex.printStackTrace();
            return null;
        }

    }
}

