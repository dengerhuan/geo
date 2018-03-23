import cn.hn.geo.geometry.GeoUtils;
import cn.hn.geo.proj4j.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) {

        System.out.println(new Test().getClass().getClassLoader());

        System.out.println(Thread.currentThread().getClass().getClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());

        InputStream io=null;
        InputStreamReader isr=new InputStreamReader(io);

        BufferedReader br = new BufferedReader(isr);
       // br.readLine()
  /*      ConversionStrategy utm2LngLat = new UTM2LngLat(50, "N");
        ConversionStrategy gps2gcj = new Gps2Gcj();


        ConversionStrategy conversion = new CoordinateConversion(utm2LngLat);


        String utm = "695990.319418226 3206648.38602354";

        String[] ustm = utm.split(" ");
        double lng = Double.parseDouble(ustm[0]);
        double lat = Double.parseDouble(ustm[1]);

        double[] xx = conversion.convert(lng, lat);
        System.out.println(xx[0]);
        System.out.println(xx[1]);

        double[] bb = GeoUtils.getNeighborPoint(xx[0], xx[1], 45, 100);

        System.out.println(bb[0]);
        System.out.println(bb[1]);

        System.out.println(GeoUtils.getDistance(xx[0], xx[1], bb[0], bb[1]));

*/

    }
}


