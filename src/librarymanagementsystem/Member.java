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
    
    public void addMember(Member member, Member[] list)
    {
        for(int i = 0; i < list.length; i++)
        {
            if(list[i] == null)
            {
                list[i] = member;
                break;
            }
        }
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getId(){
        return id;
    }
}
