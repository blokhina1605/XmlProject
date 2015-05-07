package blokhina.epam.com.factory.builder;

import blokhina.epam.com.factory.Power;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yevheniia_Blokhina on 5/7/2015.
 */
public class PowerJSONBuilder {

    public static void buildJsonPower(List<Power> listPower) {
        JSONObject jsonPower;
        JSONArray arrayPowerJson = new JSONArray();
        JSONObject innerJsonChars;
        for (Power power : listPower) {
            innerJsonChars = new JSONObject();
            jsonPower = new JSONObject();
            jsonPower.put("name", power.getName());
            jsonPower.put("model", power.getModel());
            jsonPower.put("handly", power.getHandly());
            jsonPower.put("origin", power.getOrigin());
            innerJsonChars.put("productivity", power.getTc().getProductivity());
            innerJsonChars.put("power_consumption", power.getTc().getPowerConsumption());
            innerJsonChars.put("automation", power.getTc().isAutomation());
            jsonPower.put("technical_characteristics", innerJsonChars);
            arrayPowerJson.add(jsonPower);
        }
        try( FileWriter fw = new FileWriter("resources\\power.json");) {
            fw.write(arrayPowerJson.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
