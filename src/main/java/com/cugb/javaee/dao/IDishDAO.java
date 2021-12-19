package com.cugb.javaee.dao;


import com.cugb.javaee.bean.Dish;

import java.util.ArrayList;

public interface IDishDAO {

    /***
     * findDishes
     * @return
     */
    ArrayList findDishes();

    /***
     * updateDish
     * @param dish 封装的菜品对象
     * @return
     */
    int updateDish(Dish dish);

    ArrayList findDishesBy(String sql, Object[] params);

    int getTotalDishRecords();

}
