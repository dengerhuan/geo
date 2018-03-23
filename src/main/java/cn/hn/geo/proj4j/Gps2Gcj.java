package cn.hn.geo.proj4j;

public class Gps2Gcj extends AbstractLatlngConversion {

    /**
     * 84 to 火星坐标系 (GCJ-02)
     *
     * @param lng
     * @param lat
     * @return
     */
    public double[] convert(double lng, double lat) {
        if (outOfChina(lng, lat)) {
            return null;
        }
        double dLat = transformLat(lng - 105.0, lat - 35.0);
        double dlng = transformlng(lng - 105.0, lat - 35.0);
        double radLat = lat / 180.0 * pi;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
        dlng = (dlng * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
        double mgLat = lat + dLat;
        double mglng = lng + dlng;
        return new double[]{mglng, mgLat};
    }
}
