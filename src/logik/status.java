/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logik;

/**
 *
 * @author Morten Skovgaard
 */
public enum status
{
   OPEN("Open"), CLOSED("Closed"), INPROGRESS("In progress"), WAITING("Waiting");
   
   private String statusString;
    
   
   status(String statusString)
    {
        this.statusString = statusString;
    }
}
