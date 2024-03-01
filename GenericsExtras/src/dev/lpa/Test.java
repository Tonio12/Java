package dev.lpa;

import dev.lpa.model.LPAStudent;
import dev.lpa.util.QueryList;

import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        QueryList<LPAStudent> lpaStudents= new QueryList<>();
        for(int i = 0; i < 5; i++){
            lpaStudents.add(new LPAStudent());
        }

        System.out.println("Ordered");
        lpaStudents.sort(Comparator.naturalOrder());
        printStudents(lpaStudents);

        QueryList<LPAStudent> queryList= new QueryList<>();
        for(int i = 0; i < 25; i++){
            queryList.add(new LPAStudent());
        }
        printStudents(queryList);

        var matches =  queryList.getMatches("percentcomplete", "50").getMatches("course", "python");

        System.out.println("Matches");
        printStudents(matches);

        System.out.println("Sorted Matches");
        matches.sort(new LPAStudentComparator());
        printStudents(matches);

        System.out.println("Ordered");
        matches.sort(null);
        printStudents(matches);
    }

    public static void printStudents(List<?> students){
        for(var s : students){
            System.out.println(s);
        }
    }
}
