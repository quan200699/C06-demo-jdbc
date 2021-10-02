package com.codegym.service.product;

import com.codegym.model.Product;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IProductService extends IGeneralService<Product> {
    List<Product> findProductByName(String name);

    List<Product> findProductByCategoryId(int categoryId);

    boolean updateProductAmountAfterUserBuy(int id, int amount); //amount là số lượng sản phẩm còn lại trong kho sau khi được mua
}
