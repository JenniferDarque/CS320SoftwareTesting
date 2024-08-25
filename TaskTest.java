// Import necessary libraries
import org.junit.Assert;
import org.junit.Test;

// Define a class for testing called TaskTest
public class TaskTest {

    // Test if the IllegalArgumentException is thrown when the taskId is null
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_NullTaskId() {
        new Task(null, "Test Name", "Test Description");
    }

    // Test if the IllegalArgumentException is thrown when the taskId is too long
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_LongTaskId() {
        new Task("12345678901", "Test Name", "Test Description");
    }

    // Test if the IllegalArgumentException is thrown when the name is null
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_NullName() {
      new Task("123", null, "Test Description");
    }

    // Test if the IllegalArgumentException is thrown when the name is too long
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_LongName() {
      new Task("123", "This is a very very very long name... more than 20 chars", "Test Description");
    }

    // Test if the IllegalArgumentException is thrown when the description is null
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_NullDescription() {
      new Task("123", "Test Name", null);
    }

    // Test if the IllegalArgumentException is thrown when the description is too long
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_LongDescription() {
      new Task("123", "Test Name",
          "This is a very very very very very Long description....more than fifty characters");
    }

    // Test if the getters are working correctly
    @Test
    public void testGetters() {
      Task task = new Task("123", "Test Name", "Test Description");
      Assert.assertEquals("123", task.getTaskId());
      Assert.assertEquals("Test Name", task.getName());
      Assert.assertEquals("Test Description", task.getDescription());
    }

    // Test if the setters are working correctly for valid input
    @Test
    public void testSetters_Valid() {
        Task task = new Task("123", "Test Name", "Test Description");
        task.setDescription("New Description");
        task.setName("New Name");

        Assert.assertEquals("New Description", task.getDescription());
        Assert.assertEquals("New Name", task.getName());
    }

}