public class SalariedEmployee extends Employee{
    private double anualSalary;
    private boolean isRetired;


    public SalariedEmployee(String name, String birthDate, String hireDate, double anualSalary) {
        super(name, birthDate, hireDate);
        this.anualSalary = anualSalary;
    }

    public void  retire(){
        super.terminate(endDate);
    }
}
