package cn.hn.geo.proj4j;

public class Gcj2Gps extends AbstractLatlngConversion {


    /**
     * 火星坐标系 (GCJ-02) to 84
     *
     * @param lng
     * @param lat
     * @return
     */
    public double[] convert(double lng, double lat) {

        double[] gps = transform(lng, lat);
        double lngtitude = lng * 2 - gps[0];
        double latitude = lat * 2 - gps[1];
        return new double[]{lngtitude, latitude};
    }
}
