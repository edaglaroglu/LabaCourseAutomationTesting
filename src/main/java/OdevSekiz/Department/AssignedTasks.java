package OdevSekiz.Department;

public class AssignedTasks {

    private String assignedTaskName;
    private TaskStatus assignedTaskStatus;


    public AssignedTasks(String assignedTaskName, TaskStatus assignedTaskStatus) {
        this.assignedTaskName = assignedTaskName;
        this.assignedTaskStatus = assignedTaskStatus;
    }

    public String getAssignedTaskName() {
        return assignedTaskName;
    }

    public void setAssignedTaskName(String assignedTaskName) {
        this.assignedTaskName = assignedTaskName;
    }

    public TaskStatus getAssignedTaskStatus() {
        return assignedTaskStatus;
    }

    public void setAssignedTaskStatus(TaskStatus assignedTaskStatus) {
        this.assignedTaskStatus = assignedTaskStatus;
    }

    @Override
    public String toString() {
        return "AssignedTasks{" + "\n" +
                "assignedTaskName='" + assignedTaskName + '\'' + "\n" +
                ", assignedTaskStatus=" + assignedTaskStatus + "\n" +
                '}';
    }
}


