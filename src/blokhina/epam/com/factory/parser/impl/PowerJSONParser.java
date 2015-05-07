package blokhina.epam.com.factory.parser.impl;

import blokhina.epam.com.factory.Power;
import blokhina.epam.com.factory.parser.AbstractParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Yevheniia_Blokhina on 5/7/2015.
 */
public class PowerJSONParser extends AbstractParser {

    private static final String JSON_PATH = "resources\\power.json";


    public List<Power> parseDocument(String jsonPath) {
        try {
            FileReader reader = new FileReader(jsonPath);
            JSONParser jsonParser = new JSONParser();
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
            JSONObject jo;
            Power power;
            Power.TechnicalCharacteristics tc;
            for (int i = 0; i < jsonArray.size(); i++) {
                jo = (JSONObject) jsonArray.get(i);
                JSONObject innerjo = (JSONObject) jo.get("technical_characteristics");
                power = new Power();
                tc = power.new TechnicalCharacteristics();
                power.setName(jo.get("name").toString());
                power.setModel(jo.get("model").toString());
                power.setOrigin(jo.get("origin").toString());
                power.setHandly(Integer.parseInt(jo.get("handly").toString()));
                tc.setProductivity(Integer.parseInt(innerjo.get("productivity").toString()));
                tc.setPowerConsumption(Integer.parseInt(innerjo.get("power_consumption").toString()));
                tc.setAutomation(Boolean.parseBoolean(innerjo.get("automation").toString()));
                power.setTc(tc);
                powerTools.add(power);
            }
            return powerTools;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
