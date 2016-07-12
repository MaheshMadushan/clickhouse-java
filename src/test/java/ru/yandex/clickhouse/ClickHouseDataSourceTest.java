package ru.yandex.clickhouse;


import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;


public class ClickHouseDataSourceTest {
    @Test
    public void testConstructor() throws Exception {
        ClickHouseDataSource ds = new ClickHouseDataSource("jdbc:clickhouse://localhost:1234/ppc");
        assertEquals("localhost", ds.getHost());
        assertEquals(1234, ds.getPort());
        assertEquals("ppc", ds.getDatabase());

        ClickHouseDataSource ds2 = new ClickHouseDataSource("jdbc:clickhouse://clh.company.com:5324");
        assertEquals("clh.company.com", ds2.getHost());
        assertEquals(5324, ds2.getPort());
        assertEquals("default", ds2.getDatabase());

        try {
            new ClickHouseDataSource(null);
            fail("ClickHouseDataSource with null argument must fail");
        } catch (IllegalArgumentException ex) {
            // pass, it's ok
        }

        try {
            new ClickHouseDataSource("jdbc:mysql://localhost:2342");
            fail("ClickHouseDataSource with incorrect args must fail");
        } catch (IllegalArgumentException ex) {
            // pass, it's ok
        }

        try {
            new ClickHouseDataSource("jdbc:clickhouse://localhost:wer");
            fail("ClickHouseDataSource with incorrect args must fail");
        } catch (IllegalArgumentException ex) {
            // pass, it's ok
        }
    }

}