package cn.hn.geo.proj4j;

public class Gcj2Bd extends AbstractLatlngConversion {


    /**
     * 将 GCJ-02 坐标转换成 BD-09 坐标
     *
     * @param lng
     * @param lat
     * @return
     */
    public double[] convert(double lng, double lat) {

        double x = lng, y = lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * pi);
        double bd_lng = z * Math.cos(theta) + 0.0065;
        double bd_lat = z * Math.sin(theta) + 0.006;
        return new double[]{bd_lng, bd_lat};
    }
}
