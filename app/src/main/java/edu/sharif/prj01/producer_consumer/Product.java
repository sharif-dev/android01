package edu.sharif.prj01.producer_consumer;

/**
 * @Author: MahdiHS
 * @Date: 06/02/2019
 */
public class Product {
    private long id;

    private Product(long id) {
        this.id = id;
    }

    static Product create() {
        return new Product(Utils.generateProductId());
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() +
                '}';
    }
}
