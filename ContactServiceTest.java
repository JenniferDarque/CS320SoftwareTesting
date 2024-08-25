// Imports the necessary testing packages
import static org.junit.Assert.*;
import org.junit.Test;

public class ContactServiceTest {

    // Tests the addition of a contact to the contact service
    @Test
    public void testAdd() {
        // Initializes a new instance of ContactService
        ContactService cs = new ContactService();
        // Initializes a new contact
        Contact test1 = new Contact("1413252", "Jane", "Doe", "4444444444", "123 First St.");
        // Tests if the contact was added correctly
        assertEquals(true, cs.addContact(test1));
    }
    
    // Tests the deletion of a contact from the contact service
    @Test
    public void testDelete() {
        // Initializes a new instance of ContactService
        ContactService cs = new ContactService();

        // Initializes multiple new contacts
        Contact test1 = new Contact("1413252", "Jane", "Doe", "4444444444", "123 St.");
        Contact test2 = new Contact("1309403", "Peter", "Parker", "2187123404", "123 St.");
        Contact test3 = new Contact("9752319", "Peter", "Parker", "9215501793", "123 St.");
        Contact test4 = new Contact("9752319", "Peter", "Parker", "9215501793", "111 St.");

        // Adds contacts to the contact service
        cs.addContact(test1);
        cs.addContact(test2);
        cs.addContact(test3);
        cs.addContact(test4);

        // Tests if the contact was deleted correctly
        assertEquals(true, cs.deleteContact("1309403"));
        // Tests if the function returns false when attempting to delete a non-existing contact
        assertEquals(false, cs.deleteContact("1309404"));
        // Tries to delete a contact that has just been deleted, should return false
        assertEquals(false, cs.deleteContact("1309403"));
    }

    // Tests the updating of a contact in the contact service
    @Test
    public void testUpdate() {
        // Initializes a new instance of ContactService
        ContactService cs = new ContactService();

        // Initializes contact IDs for testing
        String testId1 = "1413252";
        String testId2 = "1309403";
        String testId3 = "9752319";
        
        // Initializes new contacts
        Contact test1 = new Contact(testId1, "Jane", "Doe", "4444444444", "123 Street");
        Contact test2 = new Contact(testId2, "Peter", "Parker", "2187123404","123 Street");
        Contact test3 = new Contact(testId3, "Jim", "Rhodes", "9215501793", "123 Street");

        // Adds contacts to the contact service
        cs.addContact(test1);
        cs.addContact(test2);
        cs.addContact(test3);

        // Updating an existing contact and checking if the operation was successful
        boolean result = cs.updateContact(testId1, "Janet", "Doe", "4444444445", "124 Street");
        assertTrue(result);
        
        // Attempting to update a non-existing contact and checking if the operation failed as expected
        result = cs.updateContact("1234567", "Tim", "Cook", "9999999999", "Technology Park");
        assertFalse(result);
        
        // Attempting to update a contact with invalid data and checking if the operation failed as expected
        result = cs.updateContact(null, "Peter", "Parker", "2187123404", "123 very very ver long address Street");
        assertFalse(result);
    }
}