package org.echocat.kata.java.part1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) throws IOException  {
        CsvReader reader = new CsvReader();

        List<Author> authors = reader.readAuthors();
        List<Book> books = reader.readBooks();
        List<Magazine> magazines = reader.readMagazines();
        List<TitleIsbnAuthor> booksAndMagazinesSort = new ArrayList<>();
        booksAndMagazinesSort.addAll(books);
        booksAndMagazinesSort.addAll(magazines);


        ConsolePrinter printer = new ConsolePrinter();

        printer.print("\nBooks:\n" + books);
        printer.print("\nMagazines:\n" + magazines);
        printer.print("\nAuthors:\n" + authors);

        Sort sort = new Sort();
        sort.sortBooksAndMagazinesByTitle(booksAndMagazinesSort);
        printer.print("\nSorted books and magazines\n" + booksAndMagazinesSort);

        SearchBookService searchBookService = new SearchBookService();
        SearchMagazineService searchMagazineService = new SearchMagazineService();
        // подумай чи може в тебе бути 1 сервіс наприклад: SearchService
        // де буде в тебе в 2 методи: searchByIsbn, searchByAuthor які приймають ліст booksAndMagazinesSort 
        // та відповідно параметр пошуку(isbn or author).
        Scanner in = new Scanner(System.in);
        printer.print("\nEnter isbn to search\n");
        String isbn = in.nextLine();
        printer.print("\nEnter the author to search\n");
        String author = in.nextLine();

        Book bookByIsbnResults = searchBookService.searchByIsbn(books,isbn);
        printer.print("\nFound book by isbn\n" + bookByIsbnResults);

        Magazine magazineByIsbnResults = searchMagazineService.searchByIsbn(magazines,isbn);
        printer.print("\nFound magazine by isbn\n" + magazineByIsbnResults);


        List<Book> bookByAuthorResults = searchBookService.searchByAuthor(books,author);
        printer.print("\nFound book by author\n" + bookByAuthorResults);

        List<Magazine> magazineByAuthorResults = searchMagazineService.searchByAuthor(magazines,author);
        printer.print("\nFound magazine by author\n" + magazineByAuthorResults);
        in.close();

    }
}
