public class Main {
    public static void main(String[] args) {
        ConctructorChallenge costumer = new ConctructorChallenge("Tonio", 1000, "toni@mail.com");

        System.out.println("name: "+ costumer.getName());
        System.out.println("limit: "+ costumer.getLimit());
        System.out.println("address: "+ costumer.getAddress());

        ConctructorChallenge costumer2 = new ConctructorChallenge();

        System.out.println(" ");
        System.out.println("name: "+ costumer2.getName());
        System.out.println("limit: "+ costumer2.getLimit());
        System.out.println("address: "+ costumer2.getAddress());

        ConctructorChallenge costumer3 = new ConctructorChallenge("tonitonio", "toni@mail.com");

        System.out.println(" ");
        System.out.println("name: "+ costumer3.getName());
        System.out.println("limit: "+ costumer3.getLimit());
        System.out.println("address: "+ costumer3.getAddress());
    }
}
