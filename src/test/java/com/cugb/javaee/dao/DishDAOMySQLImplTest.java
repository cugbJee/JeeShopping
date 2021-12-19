package com.cugb.javaee.dao;

import com.cugb.javaee.bean.Dish;
import com.cugb.javaee.utils.DAOFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DishDAOMySQLImplTest {
    IDishDAO dao=(IDishDAO) DAOFactory.newInstance("IDishDAO");

    @Test
    void findDishes() {
        assertEquals(dao.findDishes().isEmpty(),false);
    }

    @Test
    void updateDish() {
        Dish dish=new Dish();
        dish.setDishid(1);
        dish.setDishname("皮蛋瘦肉");
        dish.setPrice(5.0f);
        dish.setDescrp("美味可口");
        dish.setImag("images/500022.jpg");
        assertEquals(dao.updateDish(dish),1);
    }

    @Test
    void findDishesBy() {
		String sql="select dishid Dishid,name Dishname,price Price,description Descrip,img Imag" +
				"  from dish where dishid = ?";
		Object []para=new Object[]{1};
        assertEquals(dao.findDishesBy(sql,para).isEmpty(),false);
    }

    @Test
    void getTotalDishRecords() {
        assertEquals(dao.getTotalDishRecords(),18);
    }
}