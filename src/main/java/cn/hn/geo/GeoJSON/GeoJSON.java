package cn.hn.geo.GeoJSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeoJSON implements Serializable {
    private List<Map<String, Object>> features;
    private String type;


    public GeoJSON() {
        type = GeoJSONType.FeatureCollection.toString();
        features = new ArrayList<>();
    }

    public GeoJSON(List<Map<String, Object>> features) {
        type = GeoJSONType.FeatureCollection.toString();
        this.features = features;
    }

    public List<Map<String, Object>> getFeatures() {
        return features;
    }

    public void setFeatures(List<Map<String, Object>> features) {
        this.features = features;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}



