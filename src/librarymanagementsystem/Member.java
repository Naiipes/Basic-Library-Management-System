/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagementsystem;

/**
 *
 * @author naiipes
 */
public class Member 
{
    private String name;
    private String id;
    
    public Member(String name, String id)
    {
        this.name = name;
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    
    public String getId(){
        return id;
    }
}
