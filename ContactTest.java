import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class ContactTest {
	
	 @BeforeEach
	    void clearIds() {
	        Contact.ids.clear();
	    }

    // Test: Contact ID cannot have more than 10 characters
    @Test
    @DisplayName("Contact ID cannot have more than 10 characters")
    void testContactIDMoreThanTenCharacters() {
        // Throw IllegalArgumentException if Contact ID is more than 10 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "0123456789", "123 St.");
        });

        // Validate error message
        String expectedMessage = "Contact ID cannot have more than 10 characters";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Test: First Name cannot have more than 10 characters
    @Test
    @DisplayName("First Name is either null or more than 10 characters")
    void testFirstNameMoreThanTenCharacters() {
        // Throw IllegalArgumentException if First Name is more than 10 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789", "JohnJacobJR", "Doe", "0123456789", "123 St.");
        });

        // Validate error message
        String expectedMessage = "First Name is either null or more than 10 characters";
        String actualMessage = exception.getMessage();      
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Test: First Name cannot be null
    @Test
    @DisplayName("First Name is either null or more than 10 characters")
    void testFirstNameNullCharacters() {
        // Throw IllegalArgumentException if First Name is null
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789", null, "Doe", "0123456789", "123 St.");
        });

        // Validate error message
        String expectedMessage = "First Name is either null or more than 10 characters";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Test: Last Name cannot have more than 10 characters
    @Test
    @DisplayName("Last Name is either null or more than 10 characters")
    void testLastNameMoreThanTenCharacters() {
        // Throw IllegalArgumentException if Last Name is more than 10 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789", "John", "Jinglehimer", "0123456789", "123 St.");
        });

        // Validate error message
        String expectedMessage = "Last Name is either null or more than 10 characters";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Test: Last Name cannot be null
    @Test
    @DisplayName("Last Name is either null or more than 10 characters")
    void testLastNameNullCharacters() {
        // Throw IllegalArgumentException if Last Name is null
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789", "John", null, "0123456789", "123 St.");
        });

        // Validate error message
        String expectedMessage = "Last Name is either null or more than 10 characters";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Test: Phone Number must be exactly 10 digits
    @Test
    @DisplayName("Phone Number is either null or not exactly 10 digits")
    void testPhoneNumberMoreTenCharacters() {
        // Throw IllegalArgumentException if Phone Number is more than 10 digits
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789", "John", "Doe", "110123456789", "123 St.");
        });

        // Validate error message
        String expectedMessage = "Phone Number is either null or not exactly 10 digits";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Test: Phone Number must be exactly 10 digits
    @Test
    @DisplayName("Phone Number is either null or not exactly 10 digits")
    void testPhoneNumberLessTenCharacters() {
        // Throw IllegalArgumentException if Phone Number is less than 10 digits
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789", "John", "Doe", "3456789", "123 St.");
        });

        // Validate error message
        String expectedMessage = "Phone Number is either null or not exactly 10 digits";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Test: Phone Number cannot be null
    @Test
    @DisplayName("Phone Number is either null or not exactly 10 digits")
    void testPhoneNumberNullCharacters() {
        // Throw IllegalArgumentException if Phone Number is null
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789", "John", "Doe", null, "123 St.");
        });

        // Validate error message
        String expectedMessage = "Phone Number is either null or not exactly 10 digits";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Test: Address cannot have more than 30 characters
    @Test
    @DisplayName("Address is either null or more than 30 characters")
    void testAddressMoreThanThirtyCharacters() {
        // Throw IllegalArgumentException if Address is more than 30 characters
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789", "John", "Doe", "0123456789", "123456 123456 123456 123456 123456 123 Street");
        });

        // Validate error message
        String expectedMessage = "Address is either null or more than 30 characters";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Test: Address cannot be null
    @Test
    @DisplayName("Address is either null or more than 30 characters")
    void testAddressNullCharacters() {
        // Throw IllegalArgumentException if Address is null
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123456789", "John", "Doe", "0123456789", null);
        });

        // Validate error message
        String expectedMessage = "Address is either null or more than 30 characters";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}