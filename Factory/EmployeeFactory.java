public class EmployeeFactory {

    public Employee createEmployee(String type) {
        switch (type) {
            case "FULLTIME":
                return new FullTimeEmployee();

            case "PARTTIME":
                return new PartTimeEmployee();

            case "INTERN":
                return new Intern();

            default:
                return null;
        }
    }

    public static void main(String[] args) {
        EmployeeFactory factory = new EmployeeFactory();

        Employee e1 = factory.createEmployee("FULLTIME");
        System.out.println(e1.getRole());

        Employee e2 = factory.createEmployee("INTERN");
        System.out.println(e2.getRole());
    }
}

interface Employee {
    String getRole();
}


class FullTimeEmployee implements Employee {
    public String getRole() {
        return "Full-Time Employee";
    }
}

class PartTimeEmployee implements Employee {
    public String getRole() {
        return "Part-Time Employee";
    }
}

class Intern implements Employee {
    public String getRole() {
        return "Intern";
    }
}
