package com.codegym.dao.product;

import com.codegym.dao.DBConnection;
import com.codegym.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from product");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                String image = resultSet.getString("image");
                Product product = new Product(id, name, description, price, image);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean save(Product product) {
        boolean isCreated = false;
        try {
            PreparedStatement statement = connection.prepareStatement("insert into product (name, description, price, image,category_id) value (?,?,?,?,?)");
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getImage());
            statement.setInt(5, product.getCategoryId());
            isCreated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isCreated;
    }

    @Override
    public boolean update(int id, Product product) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        try {
            CallableStatement callableStatement = connection.prepareCall("call delete_product_by_id(?)");
            callableStatement.setInt(1, id);
            isDeleted = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from product where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                String image = resultSet.getString("image");
                product = new Product(id, name, description, price, image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findProductByName(String name) {
        // select * from product where name like %name%;
        // select * from product where name like %?%; => sai
        // select * from product where name like ?
        // => truyền name => cộng chuỗi name = % + name + %
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from product where name like ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");
                String image = resultSet.getString("image");
                Product product = new Product(id, name1, description, price, image);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
