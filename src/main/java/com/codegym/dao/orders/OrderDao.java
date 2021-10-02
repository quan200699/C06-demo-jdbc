package com.codegym.dao.orders;

import com.codegym.dao.DBConnection;
import com.codegym.model.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDao implements IOrderDao {
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Orders> getAll() {
        return null;
    }

    @Override
    public boolean save(Orders orders) {
        boolean isCreated = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into orders(product_id, create_date, amount) value (?, ?, ?)");
            preparedStatement.setInt(1, orders.getProductId());
            preparedStatement.setString(2, orders.getCreateDate());
            preparedStatement.setInt(3, orders.getAmount());
            isCreated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isCreated;
    }

    @Override
    public boolean update(int id, Orders orders) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Orders findById(int id) {
        return null;
    }
}
