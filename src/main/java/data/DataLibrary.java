package data;

import entity.Books;
import entity.Members;
import entity.Transactions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataLibrary {
    public static List<Books> dataBooks(){
        List<Books> books = new ArrayList<>();

        books.add(new Books("Crime and Punishment", "Fyodor Dostoevsky", "A psychological novel exploring the mental anguish and moral dilemmas of a poor ex-student who plans to kill a pawnbroker.", Arrays.asList("Fiction", "Classic", "Psychological"), 3));
        books.add(new Books("Moby-Dick", "Herman Melville", "A novel about the voyage of the whaling ship Pequod.", Arrays.asList("Fiction", "Adventure"), 2));
        books.add(new Books("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "The first novel in the Harry Potter series.", Arrays.asList("Fiction", "Fantasy", "Young Adult"), 4));
        books.add(new Books("The Lord of the Rings", "J.R.R. Tolkien", "An epic high-fantasy novel.", Arrays.asList("Fiction", "Fantasy"), 3));
        books.add(new Books("The Chronicles of Narnia", "C.S. Lewis", "A series of seven fantasy novels.", Arrays.asList("Fiction", "Fantasy", "Children's"), 2));

        return books;
    }

    public static List<Members> dataMembers(){
        return new ArrayList<>();

    }

   public static List<Transactions> dataTransactions(){
        return new ArrayList<>();
   }

}
