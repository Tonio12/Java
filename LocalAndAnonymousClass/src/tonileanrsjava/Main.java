package tonileanrsjava;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

record Employee(String firstName, String lastName, String hireDate){}

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>(List.of
                (new Employee("Joseph", "Nelson", "November 2022"),
                        new Employee("Hubert", "Nelson", "June 2015"),
                        new Employee("Charlotte", "Ollenu", "January 2000"),
                        new Employee("Rasheeda", "Mohammed", "October 2016"),
                        new Employee("Amed", "Zakari", "July 2012"),
                        new Employee("Zinedine", "Quaye", "December 2012")));

        employeeData(employeeList);
    }

    public static void employeeData(List<Employee> employees) {
        class EmployeeData {
            private final String fullName;
            private int yearsWorked;

            static private final int CURRENT_YEAR = LocalDate.now().getYear();

            public EmployeeData(Employee employee) {
                this.fullName = employee.firstName() + " " + employee.lastName();
                this.yearsWorked = CURRENT_YEAR - getYearStartedAsInt(employee.hireDate());
            }
            private int getYearStartedAsInt(String yearStarted) {
                return Integer.parseInt(yearStarted.split(" ")[1]);
            }

            @Override
            public String toString() {
                return fullName + " Worked for " + yearsWorked + " years. ";
            }

            Comparator<EmployeeData> c4 = new Comparator<>() {
                @Override
                public int compare(EmployeeData o1, EmployeeData o2) {
                    return o1.fullName.compareTo(o2.fullName);
                }
            };
        }

        var list = new ArrayList<EmployeeData>();
        for(var element  : employees){
            list.add(new EmployeeData(element));
        }
        for(var employee : list){
            System.out.println(employee);
        }
    }

}
