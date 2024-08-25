import java.util.*;

public class AppointmentService {
	  private Map<String, Appointment> appointments = new HashMap<>();

	    public void addAppointment(Appointment appointment) {
	        if (appointments.containsKey(appointment.getAppointmentId())) {
	            throw new IllegalArgumentException("Appointment with this ID already exists");
	        }
	        appointments.put(appointment.getAppointmentId(), appointment);
	    }

	    public void deleteAppointment(String appointmentId) {
	        appointments.remove(appointmentId);
	    }
	    public Appointment getAppointment(String appointmentId) {
	        return appointments.get(appointmentId);
	    }
}
