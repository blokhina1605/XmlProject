package blokhina.epam.com.parser;

import blokhina.epam.com.Power;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevheniia_Blokhina on 5/6/2015.
 */
public abstract class AbstractParser {
    protected List<Power> powerTools = new ArrayList<>();

    public abstract List<Power> parseDocument(String xmlPath);
}
