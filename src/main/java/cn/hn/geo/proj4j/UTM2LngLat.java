package cn.hn.geo.proj4j;

public class UTM2LngLat implements ConversionStrategy {


    double easting;
    double northing;

    int zone = 50;
    String latZone = "N";


    public UTM2LngLat(int zone, String latZone) {
        this.zone = zone;
        this.latZone = latZone.toUpperCase();
    }

    String southernHemisphere = "ACDEFGHJKLM";

    protected String getHemisphere(String latZone) {
        String hemisphere = "N";
        if (southernHemisphere.indexOf(latZone) > -1) {
            hemisphere = "S";
        }
        return hemisphere;
    }

    public double[] convert(double lng, double lat) {
        double[] latlon = {0.0, 0.0};
        easting = lng;
        northing = lat;
        String hemisphere = getHemisphere(latZone);
        double latitude = 0.0;
        double longitude = 0.0;

        if (hemisphere.equals("S")) {
            northing = 10000000 - northing;
        }
        setVariables();
        latitude = 180 * (phi1 - fact1 * (fact2 + fact3 + fact4)) / Math.PI;

        if (zone > 0) {
            zoneCM = 6 * zone - 183.0;
        } else {
            zoneCM = 3.0;

        }

        longitude = zoneCM - _a3;
        if (hemisphere.equals("S")) {
            latitude = -latitude;
        }

        latlon[0] = longitude;
        latlon[1] = latitude;
        return latlon;

    }

    protected void setVariables() {
        arc = northing / k0;
        mu = arc
                / (a * (1 - Math.pow(e, 2) / 4.0 - 3 * Math.pow(e, 4) / 64.0 - 5 * Math.pow(e, 6) / 256.0));

        ei = (1 - Math.pow((1 - e * e), (1 / 2.0)))
                / (1 + Math.pow((1 - e * e), (1 / 2.0)));

        ca = 3 * ei / 2 - 27 * Math.pow(ei, 3) / 32.0;

        cb = 21 * Math.pow(ei, 2) / 16 - 55 * Math.pow(ei, 4) / 32;
        cc = 151 * Math.pow(ei, 3) / 96;
        cd = 1097 * Math.pow(ei, 4) / 512;
        phi1 = mu + ca * Math.sin(2 * mu) + cb * Math.sin(4 * mu) + cc * Math.sin(6 * mu) + cd
                * Math.sin(8 * mu);

        n0 = a / Math.pow((1 - Math.pow((e * Math.sin(phi1)), 2)), (1 / 2.0));

        r0 = a * (1 - e * e) / Math.pow((1 - Math.pow((e * Math.sin(phi1)), 2)), (3 / 2.0));
        fact1 = n0 * Math.tan(phi1) / r0;

        _a1 = 500000 - easting;
        dd0 = _a1 / (n0 * k0);
        fact2 = dd0 * dd0 / 2;

        t0 = Math.pow(Math.tan(phi1), 2);
        Q0 = e1sq * Math.pow(Math.cos(phi1), 2);
        fact3 = (5 + 3 * t0 + 10 * Q0 - 4 * Q0 * Q0 - 9 * e1sq) * Math.pow(dd0, 4)
                / 24;

        fact4 = (61 + 90 * t0 + 298 * Q0 + 45 * t0 * t0 - 252 * e1sq - 3 * Q0
                * Q0)
                * Math.pow(dd0, 6) / 720;

        //
        lof1 = _a1 / (n0 * k0);
        lof2 = (1 + 2 * t0 + Q0) * Math.pow(dd0, 3) / 6.0;
        lof3 = (5 - 2 * Q0 + 28 * t0 - 3 * Math.pow(Q0, 2) + 8 * e1sq + 24 * Math.pow(t0, 2))
                * Math.pow(dd0, 5) / 120;
        _a2 = (lof1 - lof2 + lof3) / Math.cos(phi1);
        _a3 = _a2 * 180 / Math.PI;

    }

    double arc;

    double mu;

    double ei;

    double ca;

    double cb;

    double cc;

    double cd;

    double n0;

    double r0;

    double _a1;

    double dd0;

    double t0;

    double Q0;

    double lof1;

    double lof2;

    double lof3;

    double _a2;

    double phi1;

    double fact1;

    double fact2;

    double fact3;

    double fact4;

    double zoneCM;

    double _a3;

    double b = 6356752.314;

    double a = 6378137;

    double e = 0.081819191;

    double e1sq = 0.006739497;

    double k0 = 0.9996;

}
