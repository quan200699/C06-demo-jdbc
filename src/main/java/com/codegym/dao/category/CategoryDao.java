package com.codegym.dao.category;

import com.codegym.dao.DBConnection;
import com.codegym.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements ICategoryDao {
    private Connection connection = DBConnection.getConnection();

    @Override
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * from category");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }

    @Override
    public boolean save(Category category) {
        return false;
    }

    @Override
    public boolean update(int id, Category category) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Category findById(int id) {
        return null;
    }
}
