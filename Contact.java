/** 
Jennifer Swinton
Module 3 
July 2024**/
import java.util.HashSet;
/*
 Defining Contact Class 
 */
public class Contact {
    static HashSet<String> ids = new HashSet<String>(); 
    
	 // Declaring instance variables for Contact
    String contactID;
    String firstName;
    String lastName;
    String phoneNumber;
    String address;
    
 // Contact constructor
      public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        super();  // calls the constructor of the superclass
        // using setters to initialize instance variables
        setContactID(contactID);
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setAddress(address);
    }
      // Getter method for contact ID
    public String getContactID() {
        return contactID;
    }
 // Setter method for Contact ID with validation
    public void setContactID(String contactID) {
        if (contactID.length() > 10) {
            throw new IllegalArgumentException("Contact ID cannot have more than 10 characters");
        }

        if (ids.contains(contactID)) {
            throw new IllegalArgumentException("Contact ID must be unique");
        } else {
            ids.add(contactID);  // add ContactID to HashSet
            this.contactID = contactID;
        }
    }
 // Getter method for First Name
    public String getFirstName() {
        return firstName;
    }
 // Setter method for First Name with validation
    public void setFirstName(String firstName) {
	if (firstName == null ||firstName.length() > 10) {
	throw new IllegalArgumentException("First Name is either null or more than 10 characters");
       	 }

        this.firstName = firstName;
    }
 // Getter method for Last Name
    public String getLastName() {
        return lastName;
    }
 // Setter method for Last Name with validation
    public void setLastName(String lastName) {
if (lastName == null || lastName.length() > 10) {
throw new IllegalArgumentException("Last Name is either null or more than 10 characters");
        }

        this.lastName = lastName;
    }
    // Getter method for Phone Number
    public String getPhoneNumber() {
        return phoneNumber;
    }
 // Setter method for Phone Number with validation
    public void setPhoneNumber(String phoneNumber) {
  if (phoneNumber == null || phoneNumber.length() != 10) {
 throw new IllegalArgumentException("Phone Number is either null or not exactly 10 digits");
        }

        this.phoneNumber = phoneNumber;
    }
 // Getter method for Address
    public String getAddress() {
        return address;
    }
 // Setter method for address with validation
    public void setAddress(String address) {
if (address == null || address.length() > 30) {
throw new IllegalArgumentException("Address is either null or more than 30 characters");
       }

        this.address = address;
    }
    //  toString method to print object state
    @Override
    public String toString() {
        return "Contact [contactID=" + contactID + ", firstName=" + firstName + ", lastName=" + lastName
               + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
    }
    
}
