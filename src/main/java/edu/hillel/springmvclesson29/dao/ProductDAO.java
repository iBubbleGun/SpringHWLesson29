package edu.hillel.springmvclesson29.dao;

import edu.hillel.springmvclesson29.util.InitialProductListGenerator;

public class ProductDAO {

    private static final int PRODUCTS_COUNT = 100;
    public static final InitialProductListGenerator productDAO = new InitialProductListGenerator(PRODUCTS_COUNT);
}
