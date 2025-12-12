package OdevSekiz.Department;

import java.util.ArrayList;
import java.util.List;

public class Department {

    String departmentName;
    Personnel teamLeader;
    List<Personnel> personnelList = new ArrayList<>();
    List<AssignedTasks> assignedTasks = new ArrayList<>();

    public Department(String departmentName, Personnel teamLeader) {
        this.departmentName = departmentName;
        this.teamLeader = teamLeader;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' + "\n" +
                ", teamLeader=" + teamLeader + "\n" +
                ", personnelList=" + personnelList + "\n" +
                ", assignedTasks=" + assignedTasks + "\n" +
                '}';
    }

    public void addPersonnel(Personnel personnel){
        personnelList.add(personnel);
    }

    public void removePersonnelById(int id){
        personnelList.removeIf(personnel -> personnel.getId() == id);
    }

    public void changeTeamLeader(Personnel teamLeader){
        this.teamLeader = teamLeader;
        System.out.println("New team leader: " + teamLeader.toString());
    }

    public void changePersonnel(Personnel newPersonnel, int removedId){
        personnelList.removeIf(personnel -> personnel.getId() == removedId);
        this.personnelList.add(newPersonnel);

        System.out.println("Added personnel: " + newPersonnel + " removedId: " + removedId) ;

    }

    public void addAssignedTask(List<AssignedTasks> tasks){
        assignedTasks.addAll(tasks);
    }

    public void removeAssignedTask(AssignedTasks assignedTask){
        assignedTasks.remove(assignedTask);
        System.out.println("Removed assignedTask: " + assignedTask);
    }

    public void toggleTaskStatus(List<AssignedTasks> assignedTasks, String taskName) {

        for (AssignedTasks task : assignedTasks) {
            if (task.getAssignedTaskName().equals(taskName)) {
                if (task.getAssignedTaskStatus() == TaskStatus.TO_DO){
                    task.setAssignedTaskStatus(TaskStatus.COMPLETED);
                }else {
                    task.setAssignedTaskStatus(TaskStatus.TO_DO);
                }

                System.out.println("The task is updated: " + taskName
                        + " → New Status: " + task.getAssignedTaskStatus());
                return;
            }
        }
        System.out.println("There is no task named: " + taskName);

    }


}
