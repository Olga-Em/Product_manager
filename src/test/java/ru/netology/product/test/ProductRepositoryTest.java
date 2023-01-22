package ru.netology.product.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;
import ru.netology.product.exception.AlreadyExistsException;
import ru.netology.product.exception.NotFoundException;
import ru.netology.product.manager.ProductManager;
import ru.netology.product.manager.ProductRepository;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();

    Book book1 = new Book(1, "book1", 100, "author1");
    Book book2 = new Book(2, "book2", 200, "author2");
    Book book3 = new Book(3, "book2", 300, "author2");

    Smartphone smartphone1 = new Smartphone(4, "Galaxy", 600, "Samsung");
    Smartphone smartphone2 = new Smartphone(5, "Iphone", 800, "Apple");
    Smartphone smartphone3 = new Smartphone(2, "Iphone2", 900, "Apple");

    @Test
    public void removeByCorrectIdTest() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone2);

        Product[] expected = {book2, smartphone2};
        Product[] actual = repo.removerById(1);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIncorrectIdTest() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone2);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removerById(10);
        });
    }

    @Test
    public void addProductWithUniqueId() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone2);

        Product[] expected = {book1, book2, smartphone2, smartphone1};
        Product[] actual = repo.save(smartphone1);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addProductWithSameId() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone2);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(smartphone3);
        });
    }

}
