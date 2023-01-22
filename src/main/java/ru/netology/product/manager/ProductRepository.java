package ru.netology.product.manager;

import ru.netology.product.Product;
import ru.netology.product.exception.AlreadyExistsException;
import ru.netology.product.exception.NotFoundException;

public class ProductRepository {

    private Product[] products = new Product[0];

    public Product[] getProduct() {
        return products;
    }

    public Product[] save(Product prod) {

        if(findById(prod.getId()) != null) {
            throw new AlreadyExistsException(prod.getId());
        }

        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = prod;
        products = tmp;
        return tmp;
    }

    public Product[] removerById(int idRemove) {

        if (findById(idRemove) == null) {
            throw new NotFoundException(idRemove);
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product prod : products) {
            if (prod.getId() != idRemove) {
                tmp[copyToIndex] = prod;
                copyToIndex++;
            }
        }
        products = tmp;
        return tmp;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product[] findAll() {
        return products;
    }
}
