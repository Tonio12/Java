package dev.lpa;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainFinalChallenge {

    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass", 50);
        Course jmc= new Course("JMC", "Java Masterclass", 100);
        Course jgames = new Course("JGAME", "Creating games in Java");

        int currentYear = LocalDate.now().getYear();
        List<Student> students = Stream
                .generate(() -> Student.getRandomStudent(jmc, pymc, jgames))
                .filter(s -> s.getYearEnrolled() >= (currentYear - 4))
                .limit(10000)
                .toList();

       students.stream()
               .flatMap(s -> s.getEngagementMap().values().stream())
               .collect(Collectors.groupingBy(CourseEngagement::getCourseCode, Collectors.counting()))
               .forEach((k, v)->System.out.println(k + " " + v));

       students.stream()
               .collect(Collectors.groupingBy(s -> s.getEngagementMap().size(), Collectors.counting()))
               .forEach((k,v) -> System.out.println(k+ " " + v));

        students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(CourseEngagement::getCourseCode,
                        Collectors.averagingDouble(CourseEngagement::getPercentComplete)))
                .forEach((k,v) -> System.out.println(k + " " + v));

        students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(CourseEngagement::getCourseCode,
                        Collectors.groupingBy(CourseEngagement::getLastActivityYear,Collectors.counting())))
                .forEach((k,v) -> System.out.println(k + " " + v));





    }
}
