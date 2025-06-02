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
    private static Library library = new Library();
    
    //feel free to change any part of this code

    public static void main(String[] args)
    {
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
                    if(library.bookList.length > 50)
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
                        library.addBook(book);
                    }
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    
                    Member member = new Member(name, id);
                    library.addMember(member);
                    break;
                case 3:
                    System.out.println("Enter ID");
                    String idToBorrow = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbnToBorrow = scanner.nextLine();
                    
                    library.borrowBook(isbnToBorrow, idToBorrow);
                    break;
                case 4:
                    //call some function here.
                    System.out.print("Enter ISBN: ");
                    String isbnToReturn = scanner.nextLine();
                    library.returnBook(isbnToReturn);
                    
                    break;
                case 5:
                    library.displayAvailableBooks();
                    break;
                case 6:
                    library.displayCheckedOutBooks();
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
