/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem;

/**
 *
 * @author naiipes
 */

public class Book 
{
    private String ISBN;
    private String author;
    private String title;
    protected boolean isBorrowed;
    
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

    public String getAuthor()
    {
        return author;
    }

    public String getTitle()
    {
        return title;
    }
    

}
