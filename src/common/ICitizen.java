package common;

import logik.Citizen;

/**
 *
 * @author magnusm
 */
<<<<<<< HEAD

public interface ICitizen
{
=======
public interface ICitizen {

    public ICitizen getContactPerson();

    public String getPhoneNumber();

    public String getFirstName();

    public String getLastName();

    public int getSSN();

    public String getAddress();

    public String getCity();

    public int getPostalNumber();

    public void setContactPerson(ICitizen contactPerson);

    public void setPhoneNumber(String phoneNumber);

    public void setFirstName(String firstName);

    public void setLastName(String lastName);

    public void setSSN(int SSN);

    public void setAddress(String address);

    public void setCity(String city);

    public void setPostalNumber(int postalNumber);
>>>>>>> UI
    
    public ICitizen clone();

}
