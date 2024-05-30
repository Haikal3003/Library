package entity;

import utils.Utils;


public class Transactions {
    private long id;
    private String date;
    private int idMember;
    private int idBook;
    private int status;

    public Transactions(String date, int idMember, int idBook, int status) {
        this.id = Utils.generateRandomId();
        this.date = date;
        this.idMember = idMember;
        this.idBook = idBook;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
