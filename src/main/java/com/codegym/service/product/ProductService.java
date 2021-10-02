package com.codegym.service.product;

import com.codegym.dao.category.CategoryDao;
import com.codegym.dao.category.ICategoryDao;
import com.codegym.dao.product.IProductDao;
import com.codegym.dao.product.ProductDao;
import com.codegym.model.Category;
import com.codegym.model.Product;

import java.util.List;

public class ProductService implements IProductService {
    private IProductDao productDao = new ProductDao();
    private ICategoryDao categoryDao = new CategoryDao();

    @Override
    public List<Product> getAll() {
        List<Product> products = productDao.getAll();
        for (Product product: products) {
            Category category = categoryDao.findById(product.getCategoryId());
            product.setCategory(category);
        }
        return products;
    }

    @Override
    public boolean save(Product product) {
        return productDao.save(product);
    }

    @Override
    public boolean update(int id, Product product) {
        return productDao.update(id, product);
    }

    @Override
    public boolean delete(int id) {
        return productDao.delete(id);
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public List<Product> findProductByName(String name) {
        name = "%" + name + "%";
        return productDao.findProductByName(name);
    }

    @Override
    public List<Product> findProductByCategoryId(int categoryId) {
        return productDao.findProductByCategoryId(categoryId);
    }

    @Override
    public boolean updateProductAmountAfterUserBuy(int id, int amount) {
        return productDao.updateProductAmountAfterUserBuy(id, amount);
    }
}
