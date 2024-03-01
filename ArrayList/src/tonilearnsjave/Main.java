package tonilearnsjave;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int option = 0;
        ArrayList<String> groceryList = new ArrayList<>();

        do{
            System.out.println("Actions  Available:");
            System.out.println("0 - to shutdown");
            System.out.println("1 - to add item(s) to list(comma delimited list)");
            System.out.println("2 - to remove item(s) from list(comma delimited list)");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0 -> {
                    System.out.println("Shut  Down");
                }
                case 1 -> {
                    System.out.println("Enter List of item separated by a comma");
                    String addedItems = scanner.nextLine();
                    String[] itemsToAdd = addedItems.split(",");
                    if(groceryList.containsAll(Arrays.asList(itemsToAdd))) {
                        System.out.println("Item(s) Already Added Grocery List");
                    }else {
                        groceryList.addAll(List.of(itemsToAdd));
                    }
                }
                case 2 -> {
                    System.out.println("Enter List of item separated by a comma");
                    String removedItems = scanner.nextLine();
                    String[] itemsToRemove = removedItems.split(",");
                    groceryList.removeAll(List.of(itemsToRemove));
                }
                default -> {
                    System.out.println("Shut  Down");
                    option = 0;
                }
            }
            groceryList.sort(Comparator.naturalOrder());
            System.out.println(groceryList);
        }while (option != 0);
    }
}
