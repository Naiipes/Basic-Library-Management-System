/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem;

/**
 *
 * @author naiipes
 */


// TO-DO
// Add Library class. Move all the methods in Book to Library
// Create an array of Book and Member in Library
// Find a way to keep track of the member's ID after borrowing a book 

public class Book 
{
    private String ISBN;
    private String author;
    private String title;
    private boolean isBorrowed;
    private String borrowerID;
    
    public Book(String ISBN, String author, String title)
    {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
    }
    
    @Override
    public String toString()
    {
        return "Title: " + title + 
                "\nAuthor: " + author +
                "\nISBN: " + ISBN;
    }
    
    public String getISBN()
    {
        return ISBN;
    }
    
    public void addBook(Book book, Book[] list)
    {
        for(int i = 0; i < list.length; i++)
        {
            if(list[i] == null)
            {
                list[i] = book;
                break;
            }
        }
    }
    
    public boolean searchBook(String isbn, Book[] list)
    {
        for(int i = 0; i < list.length; i++)
        {
            if(isbn.equalsIgnoreCase(list[i].getISBN()))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public void borrowBook(String isbn, String id, Book[] list)
    {
        for(int i = 0; i < list.length; i++)
        {
            if(list[i] != null && list[i].getISBN().equalsIgnoreCase(isbn))
            {
                if(list[i].isBorrowed)
                {
                    System.out.println("Book already borrowed by " + borrowerID);
                }
                else
                {
                    System.out.println("Book borrowed succesfully");
                    this.isBorrowed = true;
                    borrowerID = id;
                }
            }
        }
        
    }
    
    public void returnBook(String isbn, Book[] list)
    {
        for(int i = 0; i < list.length; i++)
        {
            if(list[i] != null && list[i].isBorrowed == false)
            {
                System.out.println("Time travelling might have occured");
            }
            else if(list[i] != null && list[i].isBorrowed == true)
            {
                System.out.println("Book returned");
                isBorrowed = false;
                borrowerID = null;
            }
        }
    }
    
    public void displayAvailableBooks(Book[] list)
    {   
        int bookCount = 1;
        
        for(int i = 0; i < list.length; i++)
        {
            if(list[i] != null && list[i].isBorrowed == false)
            {   
                System.out.println("Book[" + bookCount + "]: ");
                System.out.println(list[i].toString());
                bookCount++;
            }
            
        }
        
        if(bookCount == 1)
        {
            System.out.println("No books available");
        }
    }
    
    public void displayCheckedOutBooks(Book[] list)
    {   
        int bookCount = 1;
        
        for(int i = 0; i < list.length; i++)
        {
            if(list[i] != null && list[i].isBorrowed == true)
            {   
                System.out.println("Book[" + bookCount + "]: ");
                System.out.println(list[i].toString());
                bookCount++;
            }
        }
        
        if(bookCount == 1)
        {
            System.out.println("No borrowed books available");
        }
    }
}
