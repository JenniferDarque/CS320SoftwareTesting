
// Import necessary packages
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// Define a testing class named TaskServiceTest
public class TaskServiceTest {

    // Declare an instance of TaskService
    private TaskService taskService;

    // Instantiate TaskService before each test using @Before annotation
    @Before
    public void setup() {
        taskService = new TaskService();
    }

    // Test if a task gets added correctly
    @Test
    public void testAddTask() {
        Task newTask = taskService.addTask("1", "Test", "This is a test");
        // Check that the task is not null, and the task's parameters are correctly set
        assertNotNull(newTask);
        assertEquals("1", newTask.getTaskId());
        assertEquals("Test", newTask.getName());
        assertEquals("This is a test", newTask.getDescription());
    }

    // Test if service throws exception when adding a task with existing id
    @Test(expected = IllegalArgumentException.class)
    public void testAddTaskWithExistingId() {
        taskService.addTask("1", "Test", "This is a test");
        taskService.addTask("1", "Another task", "This is another test");
    }

    // Test if service correctly deletes a task
    @Test
    public void testDeleteTask() {
        taskService.addTask("1", "Test", "This is a test");
        taskService.deleteTask("1");

        // Check that the task with id "1" does not exist in the tasks data
        assertFalse(taskService.getTasks().containsKey("1"));
    }

    // Test if service throws exception when deleting a non-existing task
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonExistingTask() {
        taskService.deleteTask("1");
    }

    // Test if service correctly updates a task
    @Test
    public void testUpdateTask() {
        taskService.addTask("1", "Test", "This is a test");
        taskService.updateTask("1", "Updated Test", "This is an updated test");

        Task updatedTask = taskService.getTasks().get("1");

        // Check that the task is correctly updated
        assertNotNull(updatedTask);
        assertEquals("1", updatedTask.getTaskId());
        assertEquals("Updated Test", updatedTask.getName());
        assertEquals("This is an updated test", updatedTask.getDescription());
    }

    // Test if service throws exception when updating a non-existing task
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNonExistingTask() {
        taskService.updateTask("1", "Updated Test", "This is an updated test");
    }
}