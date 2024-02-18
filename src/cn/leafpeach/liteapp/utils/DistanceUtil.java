package cn.leafpeach.liteapp.utils;

import static java.lang.Math.atan2;
import static java.lang.Math.sin;
import static java.lang.Math.cos;
import static java.lang.Math.sqrt;

public class DistanceUtil {

    // 将角度转化为弧度
    public static double radians(double d) {
        return d * Math.PI / 180.0;
    }

    // 地球赤道半径
    private static final double radius = 6378.137;

    // 根据两点经纬度坐标计算直线距离(KM)
    public static double getDistance(double lng1, double lat1, double lng2, double lat2) {
        double radLng1 = radians(lng1);
        double radLat1 = radians(lat1);
        double radLng2 = radians(lng2);
        double radLat2 = radians(lat2);
        double distance;

        double a = radLat2 - radLat1;
        double b = radLng2 - radLng1;

        double c = sin(a / 2) * sin(a / 2) + cos(radLat1) * cos(radLat2) * sin(b / 2) * sin(b / 2);
        distance = (2 * atan2(sqrt(c), sqrt(1 - c))) * radius;
        return distance;
    }

    // 根据两点经纬度坐标计算横波到达时间
    public static double getTime(double lng1, double lat1, double lng2, double lat2) {
        double distance = getDistance(lng1, lat1, lng2, lat2);
        return distance / 4.4;
    }
}