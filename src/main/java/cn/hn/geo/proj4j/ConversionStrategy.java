package cn.hn.geo.proj4j;

public interface ConversionStrategy {
    double[] convert(double lng, double lat);
}
