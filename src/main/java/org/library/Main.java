package org.library;

import services.LibraryServices;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException{
        boolean exit = false;


        while(!exit){
            Main.initDataFromJson();
            Main.menu();

            String choose = input.nextLine();

            switch (choose){
                case "1":
                    LibraryServices.displayAllBooks(true);
                    break;
                case "2":
                    LibraryServices.displayAllMembers();
                    break;
                case "3":
                    LibraryServices.borrowBook();
                    break;
                case "4":
                    LibraryServices.returnBook();
                    break;
                case "5":
                    LibraryServices.displayAllTransactions();
                    break;
                case "6":
                    exit = true;
                    break;
                default:
                    System.out.println("Incorrect choose");

            }
        }

    }

    public static void initDataFromJson(){
        LibraryServices.saveDataJson();
    }

    public static void menu(){
        System.out.println("===============================");
        System.out.println("            LIBRARY            ");
        System.out.println("===============================");
        System.out.println("1. List of book");
        System.out.println("2. List of member");
        System.out.println("3. Borrow book");
        System.out.println("4. Refund book");
        System.out.println("5. Transactions");
        System.out.println("6. exit");
        System.out.println("===============================");
        System.out.print("> choose an option: ");
    }
}