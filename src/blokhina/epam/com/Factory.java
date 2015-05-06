package blokhina.epam.com;

import blokhina.epam.com.parser.impl.PowerJDOMParser;
import blokhina.epam.com.parser.impl.PowerDOMParser;
import blokhina.epam.com.parser.impl.PowerSAXParser;
import blokhina.epam.com.parser.impl.PowerStAXParser;

import java.util.List;

/**
 * Created by Yevheniia_Blokhina on 5/6/2015.
 */
public class Factory {

    private static final String XML_PATH = "resources\\powertools.xml";

    private enum TypeParser {
        SAX, STAX, DOM, DOM2
    }

    public static List<Power> createPowerBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new PowerDOMParser().parseDocument(XML_PATH);
            case STAX:
                return new PowerStAXParser().parseDocument(XML_PATH);
            case SAX:
                return new PowerSAXParser().parseDocument(XML_PATH);
            case DOM2:
                return new PowerJDOMParser().parseDocument(XML_PATH);
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}


