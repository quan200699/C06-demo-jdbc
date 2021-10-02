package com.codegym.model;

public class Orders {
    private int id;

    private int productId;

    private String createDate;

    private int amount;

    public Orders() {
    }

    public Orders(int id, int productId, String createDate, int amount) {
        this.id = id;
        this.productId = productId;
        this.createDate = createDate;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
