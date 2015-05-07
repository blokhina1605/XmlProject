package blokhina.epam.com.factory;

import blokhina.epam.com.factory.parser.impl.*;

import java.util.List;

/**
 * Created by Yevheniia_Blokhina on 5/6/2015.
 */
public class Factory {

    private static final String XML_PATH = "resources\\powertools.xml";
    private static final String JSON_PATH = "resources\\power.json";

    private enum TypeParser {
        SAX, STAX, DOM, JDOM, JAXB, JSON
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
            case JDOM:
                return new PowerJDOMParser().parseDocument(XML_PATH);
            case JAXB:
                return new PowerJAXBParser().parseDocument(XML_PATH);
            case JSON:
                return new PowerJSONParser().parseDocument(JSON_PATH);
            default:
                throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        }
    }
}


