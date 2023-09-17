package org.example.listeners;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Pong;

public class ResultSender {

    private static final InfluxDB INFLUX_DB = InfluxDBFactory.connect("http://127.0.0.1:8086", "admin", "admin");
    private static final String DATABASE = "selenium";

    static {
        INFLUX_DB.setDatabase(DATABASE);
    }

    public static void send(final Point point) {
        INFLUX_DB.write(point);
    }

//    po
}
