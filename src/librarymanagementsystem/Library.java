package librarymanagementsystem;

public class Library
{
    protected Book[] bookList = new Book[50];
    protected Member[] memberList = new Member[50];
    private String borrowerID;

    public void addBook(Book book)
    {
        for(int i = 0; i < bookList.length; i++)
        {
            if(bookList[i] == null)
            {
                bookList[i] = book;
                break;
            }
        }
    }

    public void addMember(Member member)
    {
        for(int i = 0; i < memberList.length; i++)
        {
            if(memberList[i] == null)
            {
                memberList[i] = member;
                break;
            }
        }
        System.out.println("Member added");
    }

    public void borrowBook(String isbn, String id)
    {
        boolean idFound = false;

        for(int i = 0; i < memberList.length; i++)
        {
            if(memberList[i] != null && memberList[i].getId().equals(id))
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

        for(int i = 0; i < bookList.length; i++)
        {
            if(bookList[i] != null && bookList[i].getISBN().equalsIgnoreCase(isbn))
            {
                if(bookList[i].isBorrowed)
                {
                    System.out.println("Book already borrowed by " + borrowerID);
                }
                else
                {
                    System.out.println("Book borrowed successfully");
                    bookList[i].isBorrowed = true;
                    borrowerID = id;
                }
            }
        }

    }

    public void returnBook(String isbn)
    {
        for(int i = 0; i < bookList.length; i++)
        {
            if(bookList[i] != null && !bookList[i].isBorrowed && bookList[i].getISBN().equals(isbn))
            {
                System.out.println("Time travelling might have occurred");
            }
            else if(bookList[i] != null && bookList[i].isBorrowed && bookList[i].getISBN().equals(isbn))
            {
                System.out.println("Book returned");
                bookList[i].isBorrowed = false;
                borrowerID = null;
            }
        }
    }


    public void displayAvailableBooks()
    {
        int bookCount = 1;

        for(int i = 0; i < bookList.length; i++)
        {
            if(bookList[i] != null && !bookList[i].isBorrowed)
            {
                System.out.println("Book[" + bookCount + "]: ");
                System.out.println(bookList[i].toString());
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

        for(int i = 0; i < bookList.length; i++)
        {
            if(bookList[i] != null && bookList[i].isBorrowed)
            {
                System.out.println("Book[" + bookCount + "]: ");
                System.out.println(bookList[i].toString());
                bookCount++;
            }
        }

        if(bookCount == 1)
        {
            System.out.println("No borrowed books available");
        }
    }


}
