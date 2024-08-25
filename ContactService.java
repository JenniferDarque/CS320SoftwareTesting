import java.util.ArrayList;


public class ContactService {
	// List to store our contact objects

    private ArrayList<Contact> contacts;

    public ContactService() {
        //Initialize the contacts list
        contacts = new ArrayList<>();
    }
 // Method to add contact to the list
    public boolean addContact(Contact contact) {
    	// Loop over each contact and compare IDs
        // If contact ID already exists in the list, return false
        for (Contact contactList : contacts) {
            if (contactList.getContactID().equals(contact.getContactID())) {
                return false;
            }
        }
     // If ID is unique, add contact object to the contact list and return true
        contacts.add(contact);
        return true;
    }
 // Method to remove contact from the list
    public boolean deleteContact(String string) {
    	// Iterate over each contact and compare IDs
        // If contact ID matches the given string, remove that contact and return true
        for (Contact contactList : contacts) {
            if (contactList.getContactID().equals(string)) {
                contacts.remove(contactList);
                return true;
            }
        }
     // If no matching contact ID found, return false
        return false;
    }



    // Method to update contact information
    public boolean updateContact(String contactID, String firstName, String lastName, String phoneNumber,
            String address) {
    	// Look for the contact in the contact list using contactID
        for (Contact contactList : contacts) {
           
            if (contactList.getContactID().equals(contactID)) {
            	if (!firstName.equals("")) {
                	contactList.setFirstName(firstName);
            	}
            	if (!lastName.equals("") && !(lastName.length() > 10)) {
                    contactList.setLastName(lastName);
                }
                if (!phoneNumber.equals("") && (phoneNumber.length() == 10)) {
                    contactList.setPhoneNumber(phoneNumber);
                }
                if (!address.equals("") && !(address.length() > 30)) {
                    contactList.setAddress(address);
                }
                return true;
            }
        }
        //else return false
        return false;
    }
}
