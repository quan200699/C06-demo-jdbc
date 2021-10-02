package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Orders;
import com.codegym.model.Product;
import com.codegym.service.category.CategoryService;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.orders.IOrderService;
import com.codegym.service.orders.OrderService;
import com.codegym.service.product.IProductService;
import com.codegym.service.product.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    private ICategoryService categoryService = new CategoryService();
    private IOrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                showProductCreate(request, response);
                break;
            }
            case "delete": {
                showDeleteForm(request, response);
                break;
            }
            case "buy": {
                showFormBuyProduct(request, response);
                break;
            }
            default: {
                showProductList(request, response);
                break;
            }
        }
    }

    private void showFormBuyProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product currentProduct = productService.findById(id);
        RequestDispatcher dispatcher;
        if (currentProduct == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/product/buy.jsp");
            request.setAttribute("product", currentProduct);
        }
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        //localhost:8080?action=delete&id=1
        int id = Integer.parseInt(request.getParameter("id"));
        Product oldProduct = productService.findById(id);
        RequestDispatcher dispatcher;
        if (oldProduct == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("/product/delete.jsp");
            request.setAttribute("product", oldProduct);
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        try {
            List<Category> categories = categoryService.getAll();
            request.setAttribute("categories", categories);
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) {
        //Kiểm tra nếu parameter name tìm kiếm mà khác null => thì gọi hàm search
        // = null => thì gọi hàm show list
        String name = request.getParameter("q");
        List<Product> products;
        if (name == null || name.equals("")) {
            products = productService.getAll();
        } else {
            products = productService.findProductByName(name);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/list.jsp");
        request.setAttribute("products", products);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                addProduct(request, response);
                break;
            }
            case "delete": {
                deleteProduct(request, response);
                break;
            }
            case "buy": {
                buyProduct(request, response);
                break;
            }
        }
    }

    private void buyProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/buy.jsp");
        if (product.getAmount() < amount) {
            request.setAttribute("message", "hết hàng");
            dispatcher.forward(request, response);
        } else {
            Orders order = new Orders();
            order.setAmount(amount);
            order.setProductId(id);
            orderService.save(order);
            productService.updateProductAmountAfterUserBuy(id, product.getAmount() - amount);
            request.setAttribute("message", "Mua thành công");
            request.setAttribute("product", product);
            dispatcher.forward(request, response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String image = request.getParameter("image");
        int categoryId = Integer.parseInt(request.getParameter("category"));
        Product product = new Product(name, description, price, image);
        product.setCategoryId(categoryId);
        boolean isCreated = productService.save(product);
        String message = "";
        if (isCreated) {
            message = "Create success!";
        } else {
            message = "create fail!";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product/create.jsp");
        request.setAttribute("message", message);
        List<Category> categories = categoryService.getAll();
        request.setAttribute("categories", categories);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
