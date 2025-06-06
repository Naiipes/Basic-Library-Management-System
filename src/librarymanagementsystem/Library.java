package librarymanagementsystem;

import java.util.*;

public class Library
{
    protected List<Book> bookList;
    protected List<Member> memberList;
    private String borrowerID;
    
    public Library()
    {
        bookList = new ArrayList<Book>();
        memberList = new ArrayList<Member>();
    }

    public void addBook(Book book) // Easier way to approach this would be creating a counter 
    {   
        bookList.add(book);
        System.out.println("Book added");
    }

    public void addMember(Member member)
    {
        memberList.add(member);
        System.out.println("Member added");
    }

    public void borrowBook(String isbn, String id)
    {
        boolean idFound = false;

        for(int i = 0; i < memberList.size(); i++)
        {
            if(memberList.get(i) != null && memberList.get(i).getId().equals(id))
            {
                idFound = true;
                break;
            }
        }

        if(!idFound)
        {
            System.out.println("ID not found, please try again...");
            return;
        }

        for(int i = 0; i < bookList.size(); i++)
        {
            if(bookList.get(i) != null && bookList.get(i).getISBN().equalsIgnoreCase(isbn))
            {
                if(bookList.get(i).isBorrowed)
                {
                    System.out.println("Book already borrowed by " + borrowerID);
                }
                else
                {
                    System.out.println("Book borrowed successfully");
                    bookList.get(i).isBorrowed = true;
                    borrowerID = id;
                }
            }
        }

    }

    public void returnBook(String isbn)
    {
        for(int i = 0; i < bookList.size(); i++)
        {
            if(bookList.get(i) != null && !bookList.get(i).isBorrowed && bookList.get(i).getISBN().equals(isbn))
            {
                System.out.println("Time travelling might have occurred");
            }
            else if(bookList.get(i) != null && bookList.get(i).isBorrowed && bookList.get(i).getISBN().equals(isbn))
            {
                System.out.println("Book returned");
                bookList.get(i).isBorrowed = false;
                borrowerID = null;
            }
        }
    }


    public void displayAvailableBooks()
    {
        int bookCount = 1;

        for(int i = 0; i < bookList.size(); i++)
        {
            if(bookList.get(i) != null && !bookList.get(i).isBorrowed)
            {
                System.out.println("Book[" + bookCount + "]: ");
                System.out.println(bookList.get(i).toString());
                bookCount++;
            }

        }

        if(bookCount == 1)
        {
            System.out.println("No books available");
        }
    }

    public void displayCheckedOutBooks()
    {
        int bookCount = 1;

        for(int i = 0; i < bookList.size(); i++)
        {
            if(bookList.get(i) != null && bookList.get(i).isBorrowed)
            {
                System.out.println("Book[" + bookCount + "]: ");
                System.out.println(bookList.get(i).toString());
                bookCount++;
            }
        }

        if(bookCount == 1)
        {
            System.out.println("No borrowed books available");
        }
    }


}
