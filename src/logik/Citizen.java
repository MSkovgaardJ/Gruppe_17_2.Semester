package logik;

/**
 *
 * @author Morten Skovgaard
 */

public class Citizen
{
    
   private Citizen contactPerson;
   private String phoneNumber;
   private String firstName;
   private String lastName;
   private int SSN;
   private String address;
   private String city;
   private int postalNumber;

    public Citizen getContactPerson()
    {
        
        return contactPerson;
    }

    public String getPhoneNumber()
    {
        
        return phoneNumber;
    }

    public String getFirstName()
    {
        
        return firstName;
    }

    public String getLastName()
    {
        
        return lastName;
    }

    public int getSSN()
    {
        
        return SSN;
    }

    public String getAddress()
    {
        
        return address;
    }

    public String getCity()
    {
        
        return city;
    }

    public int getPostalNumber()
    {
        
        return postalNumber;
    }

    public void setContactPerson(Citizen contactPerson)
    {
        this.contactPerson = contactPerson;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setSSN(int SSN)
    {
        this.SSN = SSN;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setPostalNumber(int postalNumber)
    {
        this.postalNumber = postalNumber;
    }
}
