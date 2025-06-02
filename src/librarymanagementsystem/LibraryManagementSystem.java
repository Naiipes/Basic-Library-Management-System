/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem;

import java.util.Scanner;

/**
 *
 * @author naiipes
 */
public class LibraryManagementSystem 
{
    private static Scanner scanner = new Scanner(System.in);
    //private static Library library = new Library();
    
    //feel free to change any part of this code
    //NB: this code is incomplete. It's just to give you a quick start on the main menu of the library.
    
    public static void main(String[] args)
    {   
        Book[] bookList = new Book[50];
        
        Member[] memberList = new Member[50];
        
        while (true)
        {
            System.out.println("Library Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Available Books");
            System.out.println("6. List Borrowed Books");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice)
            {
                case 1:
                    //logic to add your book here.
                    
                    if(bookList.length > 50)
                    {
                        System.out.println("Sorry, our shelves are full");
                    }
                    else
                    {   
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();
                        
                        Book book = new Book(isbn, author, title);
                        book.addBook(book, bookList);
                    }
                    
                    //you can for example call a function or some function within a class, etc.
                    break;
                case 2:
                    //call some function here.
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    
                    Member member = new Member(name, id);
                    member.addMember(member, memberList);
                  
                    break;
                case 3:
                    //call some function here.
                    
                    System.out.println("Enter ID");
                    String idToBorrow = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbnToBorrow = scanner.nextLine();
                    
                    bookList[0].borrowBook(isbnToBorrow, idToBorrow, bookList);
                    
                    break;
                case 4:
                    //call some function here.
                    System.out.print("Enter ISBN: ");
                    String isbnToReturn = scanner.nextLine();
                    bookList[0].returnBook(isbnToReturn, bookList);
                    
                    break;
                case 5:
                    //call some function here.
                    bookList[0].displayAvailableBooks(bookList);
                    
                    break;
                case 6:
                    //call some function here.
                    bookList[0].displayCheckedOutBooks(bookList);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
