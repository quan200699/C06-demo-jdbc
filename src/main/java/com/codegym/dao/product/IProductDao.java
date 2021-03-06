package com.codegym.dao.product;

import com.codegym.dao.IGeneralDao;
import com.codegym.model.Product;

import java.util.List;

public interface IProductDao extends IGeneralDao<Product> {
    List<Product> findProductByName(String name);

    List<Product> findProductByCategoryId(int categoryId);

    boolean updateProductAmountAfterUserBuy(int id, int amount); //amount là số lượng sản phẩm còn lại trong kho sau khi được mua
}
