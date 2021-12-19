package com.cugb.javaee.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class DAOFactory {
    private DAOFactory() {

    }
    public static Object newInstance(String interfaceClassName) {
        InputStream in = JDBCUtils.class.getClassLoader().
                getResourceAsStream("daoconfig.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
            String classname = prop.getProperty(interfaceClassName);
            return Class.forName(classname).getDeclaredConstructor().newInstance();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;

    }
}
