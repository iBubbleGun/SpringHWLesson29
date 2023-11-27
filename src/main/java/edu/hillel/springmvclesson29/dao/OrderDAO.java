package edu.hillel.springmvclesson29.dao;

import edu.hillel.springmvclesson29.util.InitialOrdersGenerator;

public class OrderDAO {

    private static final int ORDERS_COUNT = 10;
    public static final InitialOrdersGenerator orderDAO = new InitialOrdersGenerator(ORDERS_COUNT);
}
