package ru.netology.product.manager;

import ru.netology.product.Product;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product prod) {
        repo.save(prod);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product prod : repo.getProduct()) {
            if (matches(prod, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = prod;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
