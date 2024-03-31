package ru.netology.javaqa.Homework13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(1, "book", 100);
    Product product2 = new Product(2, "pullover", 1000);
    Product product3 = new Product(3, "game", 5000);
    Product product4 = new Product(4, "ghost", 20);

    @Test
    public void deleteNonExistentProduct() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });
    }

    @Test
    public void deleteExistingProduct() {

        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        repo.removeById(1);

        Product[] expected = {product2, product3, product4};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
}
