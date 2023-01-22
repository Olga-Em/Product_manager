package ru.netology.product.manager;

import ru.netology.product.Product;

public class ProductRepository {

    private Product[] product = new Product[0];

    public Product[] getProduct() {
        return product;
    }

    public void save(Product prod) {
        Product[] tmp = new Product[product.length + 1];
        for (int i = 0; i < product.length; i++) {
            tmp[i] = product[i];
        }
        tmp[tmp.length - 1] = prod;
        product = tmp;
    }

    public Product[] removerById(int id) {
        Product[] tmp = new Product[product.length - 1];
        int copyToIndex = 0;
        for (Product prod : product) {
            if (prod.getId() != id) {
                tmp[copyToIndex] = prod;
                copyToIndex++;
            }
        }
        product = tmp;
        return tmp;
    }
}
