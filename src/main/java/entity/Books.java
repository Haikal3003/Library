package entity;

import utils.Utils;

import java.util.List;

public class Books {
    private int idBook;
    private String title;
    private String author;
    private String description;
    private List<String> categories;
    private int qty;
    private boolean booked;

    public Books(String title, String author, String description, List<String> categories, int qty) {
        this.idBook = Utils.generateRandomId();
        this.title = title;
        this.author = author;
        this.description = description;
        this.categories = categories;
        this.qty = qty;
        this.booked = false;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isBooked() {
        return booked;
    }

    public boolean setBooked(boolean booked) {
        this.booked = booked;
        return booked;
    }
}
