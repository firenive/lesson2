package org.example.tests;


import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.InfluxDBIOException;
import org.influxdb.dto.Pong;
import org.testng.annotations.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InfluxDBConnectionLiveTest {

    @Test
    public void whenCorrectInfoDatabaseConnects() {
        InfluxDB connection = connectDatabase();
        assertTrue(pingServer(connection));


    }

    private InfluxDB connectDatabase() {
        return  InfluxDBFactory.connect("http://127.0.0.1:8086", "admin", "admin");
    }

    private boolean pingServer( InfluxDB influxDB) {
        try {
            Pong response = influxDB.ping();
            if (response.getVersion().equalsIgnoreCase("unknown")) {
                System.out.println("Error pinging server.");
                return false;
            } else {
                System.out.println("Database version: {} " + response.getVersion());
                return true;
            }
        } catch (InfluxDBIOException idbo) {
            System.out.println("Exception while pinging database:\n" + idbo);
            return false;
        }
    }

    @Test
    public  void checkDatabaseExist() {
        InfluxDB connection = connectDatabase();
        System.out.println(connection.describeDatabases());
    }
}
