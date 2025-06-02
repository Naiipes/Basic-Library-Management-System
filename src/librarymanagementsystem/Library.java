package librarymanagementsystem;

public class Library
{
    protected Book[] bookList = new Book[50];
    protected Member[] memberList = new Member[50];
    private String borrowerID;
    private int count;

    public int getCount()
    {
        return count;
    }

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
        count++;
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
    }

    public boolean searchBook(String isbn)
    {
        for(int i = 0; i < bookList.length; i++)
        {
            if(isbn.equalsIgnoreCase(bookList[i].getISBN()))
            {
                return true;
            }
        }

        return false;
    }

    public void borrowBook(String isbn, String id)
    {
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
                    System.out.println("Book borrowed succesfully");
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
            if(bookList[i] != null && bookList[i].isBorrowed == false)
            {
                System.out.println("Time travelling might have occured");
            }
            else if(bookList[i] != null && bookList[i].isBorrowed == true)
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
            if(bookList[i] != null && bookList[i].isBorrowed == false)
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
            if(bookList[i] != null && bookList[i].isBorrowed == true)
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
