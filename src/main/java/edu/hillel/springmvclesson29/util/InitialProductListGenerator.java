package edu.hillel.springmvclesson29.util;

import edu.hillel.springmvclesson29.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class InitialProductListGenerator {

    private final List<Product> products = new ArrayList<>();
    private final Random rnd = new Random();

    public InitialProductListGenerator(int productsCount) {
        generate(productsCount);
    }

    public List<Product> getInitialProducts() {
        return products;
    }

    public List<Product> getRandomProductList(int productsCount) {
        final List<Product> tempProductList = new ArrayList<>(products);
        Collections.shuffle(tempProductList, new Random(System.currentTimeMillis()));
        final List<Product> resultList = tempProductList.subList(0, productsCount);
        resultList.sort(Comparator.comparingInt(Product::getId));
        return resultList;
    }

    private void generate(int productsCount) {
        IntStream.rangeClosed(1, productsCount).forEach(i -> {
            products.add(new Product(i, "Product-" + i, getRandomDouble()));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private double getRandomDouble() {
        final double MIN_PRODUCT_COST = 0.99;
        final double MAX_PRODUCT_COST = 9999.99;
        final double randomValue = MIN_PRODUCT_COST + (MAX_PRODUCT_COST - MIN_PRODUCT_COST) * rnd.nextDouble();
        return Math.round(randomValue * 100.0) / 100.0;
    }
}
