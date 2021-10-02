package com.codegym.service.orders;

import com.codegym.dao.orders.IOrderDao;
import com.codegym.dao.orders.OrderDao;
import com.codegym.model.Orders;

import java.util.List;

public class OrderService implements IOrderService {
    private IOrderDao orderDao = new OrderDao();

    @Override
    public List<Orders> getAll() {
        return null;
    }

    @Override
    public boolean save(Orders orders) {
        return orderDao.save(orders);
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
