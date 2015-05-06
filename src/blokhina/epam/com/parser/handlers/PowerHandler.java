package blokhina.epam.com.parser.handlers;

import blokhina.epam.com.Power;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevheniia_Blokhina on 5/6/2015.
 */
public class PowerHandler extends DefaultHandler {

    /*private List<Power> powers = new ArrayList<>();

    private Power assembledPower;
    private String contentHolder;

    public List<Power> getPowers() {
        return powers;
    }

    @Override
    public void startElement(String uri, String localName) {
        assembledPower = new Power();
        assembledPower.setId(attributes.getValue("id"));

    }


    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "plane":
                powers.add(assembledPower);
                break;
            case "model":
                assembledPower.setModel(contentHolder);
                break;
            case "origin":
                assembledPower.setOrigin(contentHolder);
                break;
            case "chars":
                assembledPower.setChars(assembledChars);
                break;
            case "type":
                assembledChars.setPlaneType(PlaneType.valueOf(contentHolder));
                break;
            case "crew":
                assembledChars.setCrew(Crew.valueOf(contentHolder));
                break;
            case "ammo":
                assembledChars.setAmmo(assembledAmmo);
                break;
            case "rocket":
                assembledChars.setRocket(new Rocket(Integer.valueOf(contentHolder)));
                break;
            case "radar":
                assembledChars.setRadar(new Radar(Boolean.valueOf(contentHolder)));
                break;
            case "parameters":
                assembledPower.setParameters(assembledParameters);
                break;
            case "length":
                assembledParameters.setLength(Integer.valueOf(contentHolder));
                break;
            case "width":
                assembledParameters.setWidth(Integer.valueOf(contentHolder));
                break;
            case "height":
                assembledParameters.setHeight(Integer.valueOf(contentHolder));
                break;
            case "price":
                assembledPower.setPrice(Integer.valueOf(contentHolder));
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        contentHolder = String.valueOf(ch, start, length);
    }*/
}
