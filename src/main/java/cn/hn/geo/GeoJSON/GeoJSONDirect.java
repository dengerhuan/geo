package cn.hn.geo.GeoJSON;

import java.util.Map;

public class GeoJSONDirect {

    private GeoJSONBuilder builder;

    public GeoJSONDirect(GeoJSONBuilder builder) {
        this.builder = builder;
    }

    public void constructPoint(GeoJSONFeature feature) {
        Map<String, Object> obj = builder.initFeature();
        builder.buildPoint(obj);
        builder.setCoordinates(feature, obj);
        builder.setProperties(feature, obj);
        builder.append(obj);
    }

    public void constructPolygon(GeoJSONFeature feature) {
        Map<String, Object> obj = builder.initFeature();
        builder.buildPolygon(obj);
        builder.setCoordinatesMulti(feature, obj);
        builder.setProperties(feature, obj);
        builder.append(obj);
    }

}
