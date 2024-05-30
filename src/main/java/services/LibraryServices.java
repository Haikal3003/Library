package services;

import data.DataLibrary;
import entity.Books;
import entity.Members;
import entity.Transactions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import utils.Utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LibraryServices {
    public static final List<Books> dataBooks = DataLibrary.dataBooks();
    public static final List<Members> dataMembers = DataLibrary.dataMembers();
    public static final List<Transactions> dataTransactions = DataLibrary.dataTransactions();

    public static final String path = "C:/Users/ATHLON GOLD/OneDrive/Desktop/Kuliah/OOP/Library_Management(A11)/Library/src/main/java/json/";

    public static final Scanner input = new Scanner(System.in);

//    Books services
    @SuppressWarnings("unchecked")
    public static void displayAllBooks(boolean backToMenuInput){
        Utils.clearScreen();
        JSONArray bookList = Utils.readJsonFile(path + "books.json");

        System.out.println("===============================");
        System.out.println("         List of book          ");
        System.out.println("===============================");

        bookList.forEach(book -> {
            JSONObject bookObj = (JSONObject) book;
            System.out.println("id book: #" + bookObj.get("idBook"));
            System.out.println("title: " + bookObj.get("title"));
            System.out.println("author: " + bookObj.get("author"));
            System.out.println("description: " + bookObj.get("description"));
            System.out.print("categories: ");
            System.out.print(String.join(", ", (JSONArray) bookObj.get("categories")) + ".");
            System.out.println("\nqty: " + bookObj.get("qty"));
            System.out.println("booked: " + bookObj.get("booked"));
            System.out.println("===============================");
        });
        
        Utils.backToMenu(input, backToMenuInput);

    }

    public static void borrowBook() {
        Utils.clearScreen();
        addMember();
        displayAllBooks(false);

        System.out.print("> Choose book by id: #");
        int chooseBookById = input.nextInt();
        input.nextLine();


        for (Books book : dataBooks) {
            int idBook = book.getIdBook();
            int currentQty = book.getQty();

            if (idBook == chooseBookById) {
                if (currentQty > 0) {
                    book.setBooked(true);
                    book.setQty(currentQty - 1);

                    Members lastMember = dataMembers.get(dataMembers.size() - 1);

                    Date date = new Date();

                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                    String formatedDate = formatter.format(date);
                    Transactions transaction = new Transactions(formatedDate, lastMember.getIdMember(), idBook, 0);

                    System.out.println("===============================");
                    System.out.println("          Transaction          ");
                    System.out.println("===============================");
                    System.out.println("id: " + transaction.getId());
                    System.out.println("date: " + transaction.getDate());
                    System.out.println("idMember: " + transaction.getIdMember());
                    System.out.println("idBook: " + transaction.getIdBook());
                    System.out.println("status: " + transaction.getStatus());
                    System.out.println("===============================");


                    dataTransactions.add(transaction);

                    Utils.backToMenu(input, true);
                } else {
                    System.out.println("book empty");
                }
            }
        }
    }

    public static void returnBook() throws InterruptedException{
        Utils.clearScreen();

        System.out.println("===============================");
        System.out.println("          Return Book          ");
        System.out.println("===============================");
        System.out.print("> Enter your id member: ");
        int idMember = input.nextInt();
        input.nextLine();

        for(Transactions transaction : dataTransactions){
            if(transaction.getIdMember() == idMember && transaction.getStatus() == 0){
                System.out.println("===============================");
                System.out.println("         Transactions          ");
                System.out.println("===============================");
                System.out.println("id: " + transaction.getId());
                System.out.println("date: " + transaction.getDate());
                System.out.println("idMember: " + transaction.getIdMember());
                System.out.println("idBook: " + transaction.getIdBook());
                System.out.println("status: " + transaction.getStatus());
                System.out.println("===============================");
                System.out.print("Enter id book to return: ");
                int bookId = input.nextInt();
                input.nextLine();

                if(transaction.getIdBook() == bookId){
                    for(Books book : dataBooks){
                        if(book.getIdBook() == bookId){
                            book.setBooked(false);
                            book.setQty(book.getQty() + 1);
                        }
                    }

                    transaction.setStatus(1);
                    System.out.println("Return book with id transaction: " + transaction.getId() + " successfully!") ;

                    Utils.backToMenu(input, true);

                }
            }else if(transaction.getIdMember() != idMember){
                System.out.println("===============================");
                System.out.println(" No member with id: " + idMember);
                System.out.println("===============================");

                Thread.sleep(2500);

                returnBook();
            }

        }
        

    }


    //    Members services
    @SuppressWarnings("unchecked")
    public static void displayAllMembers() {
        Utils.clearScreen();
        JSONArray memberList = Utils.readJsonFile(path + "members.json");

        System.out.println("===============================");
        System.out.println("      Library member info      ");
        System.out.println("===============================");

        if(memberList.isEmpty()){
            System.out.println("           No members          ");
            System.out.println("===============================");

        }else{
            memberList.forEach(member -> {
                JSONObject memberObj = (JSONObject) member;
                System.out.println("idMember: #" + memberObj.get("idMember") );
                System.out.println("name: " + memberObj.get("name"));
                System.out.println("phone: " + memberObj.get("phone"));
                System.out.println("email: " + memberObj.get("email"));
                System.out.println("address: " + memberObj.get("address"));
                System.out.println("===============================");
            });

        }

        Utils.backToMenu(input, true);
    }

    public static void addMember() {
        Utils.clearScreen();

        System.out.println("===============================");
        System.out.println("   Enter member detail first   ");
        System.out.println("===============================");
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter phone number: ");
        String phone = input.nextLine();
        System.out.print("Enter email: ");
        String email = input.nextLine();
        System.out.print("Enter address: ");
        String address = input.nextLine();

        Members members = new Members(name, phone, email, address);

        dataMembers.add(members);
    }

//    Transactions services
    public static void displayAllTransactions() {
        Utils.clearScreen();

        JSONArray transactionList = Utils.readJsonFile(path + "transactions.json");

        System.out.println("===============================");
        System.out.println("         Transactions          ");
        System.out.println("===============================");

        if(transactionList.isEmpty()){
            System.out.println("        No Transactions        ");
            System.out.println("===============================");
        }else{
            for(Object transaction : transactionList){
                JSONObject transactionObj = (JSONObject) transaction;

                System.out.println("id: " + transactionObj.get("id"));
                System.out.println("Date: " + transactionObj.get("date"));
                System.out.println("idMember: " + transactionObj.get("idMember"));
                System.out.println("idBook: " + transactionObj.get("idBook"));
                System.out.println("status: " + transactionObj.get("status"));
                System.out.println("===============================");

            }
        }

       Utils.backToMenu(input, true);
    }

//    Save data
    public static void saveDataJson() {
        Utils.writeJsonFile(path + "books.json", dataBooks);
        Utils.writeJsonFile(path + "members.json", dataMembers);
        Utils.writeJsonFile(path + "transactions.json", dataTransactions);
    }
}
