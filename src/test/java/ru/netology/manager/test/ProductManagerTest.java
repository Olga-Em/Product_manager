package ru.netology.manager.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.product.manager.ProductManager;
import ru.netology.product.manager.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(1, "book1", 100, "author1");
    Book book2 = new Book(2, "book2", 200, "author2");
    Book book3 = new Book(3, "book2", 300, "author2");

    Smartphone smartphone1 = new Smartphone(4, "Galaxy", 600, "Samsung");
    Smartphone smartphone2 = new Smartphone(5, "Iphone", 800, "Apple");


    @Test
    public void searchForOneProduct() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("book1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNonExistentProduct() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {};
        Product[] actual = manager.searchBy("book4");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTwoProduct() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book2, book3};
        Product[] actual = manager.searchBy("book2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removerByIdTest() {

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book2, book3};
        Product[] actual = repo.removerById(1);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchForSmartphone() {

        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("Iphone");

        Assertions.assertArrayEquals(expected, actual);
    }

}
