package OdevSekiz.Department;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Personnel> personnelList = new ArrayList<>();
        int removedPersonnel = 0;
        Personnel teamLead_development = null;
        List<AssignedTasks> tasks = new ArrayList<>();


        //create personnel list
        personnelList.add(new Woman("Duygu", "D", 1980));
        personnelList.add(new Woman("Ayşe", "K", 1985));
        personnelList.add(new Woman("Zeynep", "A", 1990));
        personnelList.add(new Woman("Sinem", "T", 1992));
        personnelList.add(new Woman("Buse", "Y", 1995));
        personnelList.add(new Man("Ali", "K", 1978));
        personnelList.add(new Man("Okan", "Y", 1982));
        personnelList.add(new Man("Ömer", "C", 1987));
        personnelList.add(new Man("Emre", "S", 1991));
        personnelList.add(new Man("Can", "M", 1994));

        for (Personnel p : personnelList) {
            if (p.getId() == 1001) {
                teamLead_development = p;
                break;
            }
        }

        Department development = new Department("Development",teamLead_development);

        //fill development personnel array list
        for (Personnel p : personnelList) {
            if (p.getId() % 2 == 0 ) {
                development.addPersonnel(p);
            }
        }

        tasks.add(new AssignedTasks("Login", TaskStatus.TO_DO));
        tasks.add(new AssignedTasks("Payment", TaskStatus.TO_DO));
        tasks.add(new AssignedTasks("Report", TaskStatus.TO_DO));
        tasks.add(new AssignedTasks("BugFix", TaskStatus.TO_DO));
        tasks.add(new AssignedTasks("Deploy", TaskStatus.TO_DO));

        development.addAssignedTask(tasks);

        personnelList.add(new Woman("Derin", "D", 1990));

        for (Personnel p : personnelList) {
            if (p.getName().equals("Ayşe")) {
                 removedPersonnel = p.getId();
            }
        }

        development.changePersonnel(personnelList.getLast(),removedPersonnel);
        System.out.println(development.personnelList);

        development.removeAssignedTask(tasks.get(tasks.size()-1));

        development.toggleTaskStatus(tasks, "BugFix");

        for (Personnel p : personnelList) {
            if (p.calculateRemainingYears() > 30 ) {
                System.out.println("Remaining Retirement Year for " + p.getName() + " " + p.getSurname() + " = "  + p.calculateRemainingYears());
            }
        }

        development.changeTeamLeader(development.personnelList.get(2));





















/*
        TeamLeader teamLeader1 = new TeamLeader("ayse", "d",1980, "f");
        TeamLeader teamLeader2 = new TeamLeader("ali","k", 1985, "m");



        Department qa = new Department("qa", teamLeader1 );
        Department dev = new Department("dev", teamLeader2 );



        List<AssignedTasks> assignedTasks = new ArrayList<>();

        // dev TASKS
        dev.assignedTasks.add(new AssignedTasks("Implement user login API", false));
        dev.assignedTasks.add(new AssignedTasks("Refactor payment service", false));
        dev.assignedTasks.add(new AssignedTasks("Fix null pointer bug in Order module", false));
        dev.assignedTasks.add(new AssignedTasks("Optimize database queries for Product module", false));
        dev.assignedTasks.add(new AssignedTasks("Write unit tests for NotificationService", false));

        // qa TASKS
        qa.assignedTasks.add(new AssignedTasks("Create test cases for user registration", false));
        qa.assignedTasks.add(new AssignedTasks("Perform regression testing on checkout flow", false));
        qa.assignedTasks.add(new AssignedTasks("Validate API responses for booking module", false));
        qa.assignedTasks.add(new AssignedTasks("Prepare performance test scenarios", false));
        qa.assignedTasks.add(new AssignedTasks("Verify UI design changes in dashboard page", false));


       System.out.println(dev.toString());
       System.out.println(qa.toString());



*/

    }
}
