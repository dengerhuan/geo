package cn.hn.geo.proj4j;

public class Bd2Gcj extends AbstractLatlngConversion {


    /**
     * 将 BD-09 坐标转换成GCJ-02 坐标
     *
     * @param lng
     * @param lat
     * @return
     */
    public double[] convert(double lng, double lat) {


        double x = lng - 0.0065, y = lat - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * pi);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * pi);
        double gg_lng = z * Math.cos(theta);
        double gg_lat = z * Math.sin(theta);
        return new double[]{gg_lng, gg_lat};
    }
}
