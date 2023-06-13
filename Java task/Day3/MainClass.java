interface Employee {
    void calculateSalary();
}

interface Manager extends Employee {
    void approveLeave();
}

class TeamLead implements Manager {
    private String name;

    public TeamLead(String name) {
        this.name = name;
    }

    @Override
    public void calculateSalary() {
        System.out.println("Calculating salary for Team Lead: " + name);
    }

    @Override
    public void approveLeave() {
        System.out.println("Approving leave for Team Lead: " + name);
    }
}

public class MainClass {
    public static void main(String[] args) {
        TeamLead teamLead = new TeamLead("John Doe");
        teamLead.calculateSalary();
        teamLead.approveLeave();
    }
}
