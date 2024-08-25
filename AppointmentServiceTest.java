import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;

public class AppointmentServiceTest {
    private AppointmentService service = new AppointmentService();

    @Test
    public void testAddAppointment() {
        String appointmentId = "1234567890";
        Date appointmentDate = new Date();
        String description = "Valid Description under 50 chars";
        
        Appointment appointment = new Appointment(appointmentId, appointmentDate, description);
        service.addAppointment(appointment);
        
        assertEquals(appointment, service.getAppointment(appointmentId));
    }

    @Test(expected = IllegalArgumentException.class) 
    public void testAddAppointmentDuplicate() {
        String appointmentId = "1234567890";
        Date appointmentDate = new Date();
        String description = "Valid Description under 50 chars";

        Appointment appointment = new Appointment(appointmentId, appointmentDate, description);
        service.addAppointment(appointment);
        service.addAppointment(appointment); // should throw exception
    }
    
    @Test
    public void testDeleteAppointment() {
        String appointmentId = "1234567890";
        Date appointmentDate = new Date();
        String description = "Valid Description under 50 chars";
        
        Appointment appointment = new Appointment(appointmentId, appointmentDate, description);
        service.addAppointment(appointment);
        
        service.deleteAppointment(appointmentId);
        
        assertNull(service.getAppointment(appointmentId));
    }
}