package logic;

import common.ICitizen;

/**
 *
 * @author Morten Skovgaard
 */
public class Citizen implements ICitizen {
    private ICitizen contactPerson;
    private int phoneNumber;
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
    public int getPhoneNumber() {
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
        return postalNumber;
    }

    @Override
    public void setContactPerson(ICitizen contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Override
    public void setPhoneNumber(int phoneNumber) {
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
}
