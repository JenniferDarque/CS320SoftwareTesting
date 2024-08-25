// Define a class named Task
public class Task {
    // Declare a final string variable for taskId
    private final String taskId;
    // Declare string variables for name and description 
    private String name;
    private String description;

    // Define a constructor to create a new Task object.
    // If taskId, name, or description are null or exceed a certain length, it throws an InvalidArgumentException
    public Task(String taskId, String name, String description) {
      if(taskId == null || taskId.length() > 10 || name == null || name.length() > 20 || description == null || description.length() > 50) {
          throw new IllegalArgumentException("Invalid argument");
      }

      // Assign passed values to the class's variables
      this.taskId = taskId;
      this.name = name;
      this.description = description;
    }

    // Define Getter for taskId
    public String getTaskId() {
        return taskId;
    }

    // Define Getter for name
    public String getName() {
        return name;
    }

    // Define Setter for name considering length constraint
    public void setName(String name) {
       if(name != null && name.length() <= 20){
           this.name = name;
       }
    }

    // Define Getter for description
    public String getDescription() {
        return description;
    }

    // Define Setter for description considering length constraint
    public void setDescription(String description) {
        if(description != null && description.length() <= 50){
           this.description = description;
        }
    }
}