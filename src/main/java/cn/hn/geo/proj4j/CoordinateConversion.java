package cn.hn.geo.proj4j;

public class CoordinateConversion implements ConversionStrategy {
    private ConversionStrategy strategy;

    public CoordinateConversion(ConversionStrategy strategy) {

        this.strategy = strategy;
    }

    public double[] convert(double lng, double lat) {
        return strategy.convert(lng, lat);
    }

}
