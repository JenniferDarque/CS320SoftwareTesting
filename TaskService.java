// Import packages
import java.util.HashMap;
import java.util.Map;

// Define TaskService class
public class TaskService {
    // A HashMap to store tasks, where the key is the task's id and the value is the task object
	private final Map<String, Task> tasks = new HashMap<>();

    // Function to add a new task. If a task already exists with the same id it will throw an exception.
    public Task addTask(String id, String name, String description) {
        Task newTask = new Task(id, name, description);
        if(tasks.putIfAbsent(id, newTask) != null) {
            throw new IllegalArgumentException("Task with given ID already exists");
        }
        return newTask;
    }
    // Function to get all tasks
    public Map<String, Task> getTasks() {
        return tasks;
    }

    // Function to delete a task based on id. If the id doesn't exist, it will throw an exception.
    public void deleteTask(String id) {
        if(tasks.remove(id) == null) {
            throw new IllegalArgumentException("No task with given ID to delete");
        }
    }

    // Function to update the details of a task based on id. If the id doesn't exist, it will throw an exception.
    public void updateTask(String id, String name, String description) {
        Task task = tasks.get(id);
        if(task == null) {
            throw new IllegalArgumentException("No task with given ID to update");
        }
        // Call the setters of the Task class to update the name and description of the task
        task.setName(name);
        task.setDescription(description);
    }
}