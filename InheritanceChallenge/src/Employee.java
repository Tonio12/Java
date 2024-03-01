class Employee extends Worker {
    private long employeeId;
    private String hireDate;

    private static int employeeNum = 1;

    public Employee(String name, String birthDate, String hireDate) {
        super(name, birthDate);
        this.employeeId = employeeNum++;
        this.hireDate = hireDate;
    }
}
