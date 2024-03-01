package toniolearnsjava.school;

public class Main {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");
        Student tim  = new Student("AU",  2019, 30,"M", true, jmc, pymc);
        System.out.println(tim);

        tim.watchLecture("JMC", 10,5, 2019);
        tim.watchLecture("PYMC", 7, 7, 2020);
        System.out.println(tim);
    }
}
