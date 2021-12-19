package com.cugb.javaee.dao;

import com.cugb.javaee.bean.Dish;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class baseDAOTest {
baseDAO basedao=new baseDAO();
    @Test
    void findRecords() {
        String sql="select count(*) from dish;";
        assertEquals(basedao.findRecords(sql),18);
    }

    @Test
    void findObjs() {
        //注意设置别名与bean类一致，注意para列表包括查询条件
        String sql="select dishid Dishid,name Dishname,price Price,description Descrip,img Imag" +
                "  from dish where dishid = ?";

        Object []para=new Object[]{1};
        ArrayList<Dish> a=basedao.findObjs(sql,para, Dish.class);
        assertEquals(basedao.findObjs(sql,para, Dish.class).isEmpty(),false);
    }

    @Test
    void updateObj() {
        String sql="update dish set price=? where dishid=?";
        Object []para=new Object[]{5.1,1};
//        Object []para=new Object[]{1,"皮蛋瘦肉", 5,"美味可口","images/500022.jpg"};
        assertEquals(basedao.updateObj(sql,para),1);

    }
}