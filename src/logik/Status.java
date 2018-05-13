package logik;

/**
 *
 * @author Morten Skovgaard
 */

public enum Status
{
   OPEN("Open"), CLOSED("Closed"), INPROGRESS("In progress"), WAITING("Waiting");
   private String statusString;
   
   Status(String statusString)
   {
       this.statusString = statusString;
   }
}
