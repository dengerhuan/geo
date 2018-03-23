package cn.hn.geo.GeoJSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeoJSONBuilder {


    private static final String GEOMETRY = "geometry";

    private List<Map<String, Object>> features = new ArrayList<>();
    private GeoJSON geoJson;

    {

        // 初始化返回值的类型
        // 初始化features数组
        geoJson = new GeoJSON(features);

    }


    /**
     * 初始化一个feature
     *
     * @return
     */
    Map<String, Object> initFeature() {
        Map<String, Object> obj = new HashMap<>();
        obj.put("type", "Feature");
        obj.put(GEOMETRY, new HashMap<String, Object>());
        return obj;
    }

    @SuppressWarnings("unchecked")
    void buildPoint(Map<String, Object> obj) {
        Map ge = (Map<String, Object>) obj.get(GEOMETRY);
        ge.put("type", GeoJSONType.Point);
    }

    @SuppressWarnings("unchecked")
    void buildPolygon(Map<String, Object> obj) {
        Map ge = (Map<String, Object>) obj.get(GEOMETRY);
        ge.put("type", GeoJSONType.Polygon);
    }

    @SuppressWarnings("unchecked")
    void setCoordinates(GeoJSONFeature feature, Map<String, Object> obj) {
        Map ge = (Map<String, Object>) obj.get(GEOMETRY);
        ge.put("coordinates", feature.getCoordinates());
    }


    @SuppressWarnings("unchecked")
    void setCoordinatesMulti(GeoJSONFeature feature, Map<String, Object> obj) {
        Map ge = (Map<String, Object>) obj.get(GEOMETRY);
        ge.put("coordinates", feature.getCoordinatesMulti());
    }


    void setProperties(GeoJSONFeature feature, Map<String, Object> obj) {
        obj.put("properties", feature.getProperties());
    }

    void append(Map<String, Object> feature) {
        features.add(feature);
    }

    public GeoJSON build() {
        return geoJson;
    }
}

