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
        //change option (JSON, DOM, JDOM, SAX, STAX)
        List<Power> listPower = Factory.createPowerBuilder("JSON");

        //JSON builder
        PowerJSONBuilder.buildJsonPower(listPower);

        //print list of obj
        System.out.println(listPower);

    }
}
