package org.espressootr.unittest.mock;

import java.util.Date;
 
public class Person
{
    public int age; 
    public String name; 
    public int weight; 
    public Date birthDate; 
    
    
    @Override 
    public String toString()
    {
      StringBuilder sb = new StringBuilder();
      sb.append("age:").append(age);
      sb.append("\n");
      
      sb.append("name:").append(name);
      sb.append("\n");
      
      sb.append("weight:").append(weight);
      sb.append("\n");

      sb.append("birthDate:").append(birthDate);
      sb.append("\n");
      
      
      
      sb.append("\n");
      
    
      
      return sb.toString();
      
    }
}
