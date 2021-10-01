package com.codegym.dao;

import com.codegym.model.Product;

import java.util.List;

public interface IProductDao extends IGeneralDao<Product> {
    List<Product> findProductByName(String name);
}
