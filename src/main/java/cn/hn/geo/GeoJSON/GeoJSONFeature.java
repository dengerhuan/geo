package cn.hn.geo.GeoJSON;

import java.util.List;
import java.util.Map;

public abstract class GeoJSONFeature {

    public abstract List getCoordinates();

    public abstract List getCoordinatesMulti();

    public abstract Map getProperties();
}
