package com.cugb.javaee.utils;

import com.cugb.javaee.dao.IDishDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DAOFactoryTest {

    @Test
    void newInstance() {
        IDishDAO dishdao= (IDishDAO) DAOFactory.newInstance("IDishDAO");

    }
}