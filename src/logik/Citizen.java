package logik;

import common.ICitizen;

/**
 *
 * @author Morten Skovgaard
 */
<<<<<<< HEAD

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
        
=======
public class Citizen implements ICitizen {

    private ICitizen contactPerson;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private int SSN;
    private String address;
    private String city;
    private int postalNumber;

    @Override
    public ICitizen getContactPerson() {
        return contactPerson;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public int getSSN() {
        return SSN;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public int getPostalNumber() {
>>>>>>> UI
        return postalNumber;
    }

    @Override
    public void setContactPerson(ICitizen contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setPostalNumber(int postalNumber) {
        this.postalNumber = postalNumber;
    }
<<<<<<< HEAD
=======

    @Override
    public ICitizen clone() {
        ICitizen clone = new Citizen();
        clone.setAddress(address);
        clone.setCity(city);
        clone.setContactPerson(contactPerson);
        clone.setFirstName(firstName);
        clone.setLastName(lastName);
        clone.setPhoneNumber(phoneNumber);
        clone.setPostalNumber(postalNumber);
        clone.setSSN(SSN);
        return clone;
    }
>>>>>>> UI
}
