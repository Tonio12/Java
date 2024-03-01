package tonilearnsjava;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTasks("all");
        Set<Task> annTasks = TaskData.getTasks("ann");
        Set<Task> bobTasks = TaskData.getTasks("bob");
        Set<Task> carolsTasks = TaskData.getTasks("carol");
//        sortAndPrint(tasks);

        var allTasks = getUnion(List.of(annTasks,bobTasks,carolsTasks,tasks));
        sortAndPrint(allTasks);

        var assignedTasks = getUnion(List.of(annTasks,bobTasks,carolsTasks));
        sortAndPrint("Assigned Tasks",assignedTasks, null);

        var tasksToBeAssigned = getDifference(allTasks, assignedTasks);
        sortAndPrint("Unassigned Tasks",tasksToBeAssigned, null);

        var tasksAssignedToMultipleEmployees = getUnion(List.of(
                getIntersect(annTasks,carolsTasks),
                getIntersect(annTasks,bobTasks),
                getIntersect(bobTasks,carolsTasks)
        ));
        sortAndPrint("Tasks Assigned To Multiple Employees",tasksAssignedToMultipleEmployees, null);
    }

    private static void sortAndPrint(Collection<Task> collection) {
        sortAndPrint("All Tasks", collection, null);
    }

    private static void sortAndPrint(String header, Collection<Task> collection,
                                     Comparator<Task> sorter) {

        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);
    }

    private static Set<Task> getUnion(List<Set<Task>> tasks){
        Set<Task> union = new HashSet<>();
        for(var task : tasks){
            union.addAll(task);
        }
        return union;
    }

    private  static Set<Task> getIntersect(Set<Task> a, Set<Task>b){
        Set<Task> intersect = new HashSet<>(a);
        intersect.retainAll(b);
        return intersect;
    }

    private static Set<Task> getDifference(Set<Task> a, Set<Task> b){
        Set<Task>  result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }
}
