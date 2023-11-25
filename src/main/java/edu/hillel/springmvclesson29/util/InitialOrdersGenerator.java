package edu.hillel.springmvclesson29.util;

import edu.hillel.springmvclesson29.dao.ProductDAO;
import edu.hillel.springmvclesson29.model.Order;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

public class InitialOrdersGenerator {

    private final Map<Integer, Order> orders = new LinkedHashMap<>();
    private final Random rnd = new Random();

    public InitialOrdersGenerator(int ordersCount) {
        generate(ordersCount);
    }

    public Map<Integer, Order> getInitialOrders() {
        return orders;
    }

    private void generate(int ordersCount) {
        IntStream.rangeClosed(1, ordersCount)
                .forEach(i -> orders.put(
                                i, new Order(
                                        i, ProductDAO.productDAO.getRandomProductList(getRandomNumber(1, ProductDAO.productDAO.getInitialProducts().size())))
                        )
                );
    }

    private int getRandomNumber(int min, int max) {
        return rnd.nextInt((max - min) + 1) + min;
    }
}
