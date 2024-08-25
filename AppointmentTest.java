import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.*;

public class AppointmentTest {
    
    @Test
    public void testAppointmentClass() {
        String inputAppointmentId = "1234567890";
        Date inputAppointmentDate = new Date();
        String inputDescription = "This is a valid description under 50 chars";

        Appointment appointment = new Appointment(inputAppointmentId, inputAppointmentDate, inputDescription);
        
        assertEquals(inputAppointmentId, appointment.getAppointmentId());
        assertEquals(inputAppointmentDate, appointment.getAppointmentDate());
        assertEquals(inputDescription, appointment.getDescription());
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void testAppointmentIdNull() {
        new Appointment(null, new Date(), "Valid Description");
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testAppointmentIdOverLength() {
        new Appointment("12345678901", new Date(), "Valid Description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDateInPast() {
        new Appointment("1234567890", new Date(new Date().getTime() - (1000 * 60 * 60 * 24)), "Valid Description");
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void testDescriptionOverLength() {
        new Appointment("1234567890", new Date(), "This description is definitely over the fifty character limit");
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void testDescriptionNull() {
        new Appointment("1234567890", new Date(), null);
    }
}