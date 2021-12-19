package com.cugb.javaee.utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class JDBCUtilsTest {

    @Test
    void getConnection() {
        Connection conn = JDBCUtils.getConnection();
        assertNotEquals(conn,null);
    }
    @Test
    void free() throws SQLException {
        Connection conn = JDBCUtils.getConnection();
        JDBCUtils.free(null,null,conn);
        assertEquals(conn.isClosed(),true);
    }
}