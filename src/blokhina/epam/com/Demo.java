package blokhina.epam.com;

import blokhina.epam.com.factory.Factory;
import blokhina.epam.com.factory.Power;
import blokhina.epam.com.factory.builder.PowerJSONBuilder;


import java.util.List;

/**
 * Created by Yevheniia_Blokhina on 5/6/2015.
 */
public class Demo {
    public static void main(String[] args) {

        List<Power> listPower = Factory.createPowerBuilder("JSON");
        System.out.println(listPower);
//        PowerJSONBuilder.buildJsonPower(listPower);

    }
}
