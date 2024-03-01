public class TextBlock {
    public static void main(String[] args) {
        System.out.println("Print bullet list\n"
                                +"\t• First Bullet\n" +
                                        "\t\t• Second bullet");

        String textBlock = """
                Print Bullet List
                    • First Bullet
                        • Second bullet""";

        System.out.println(textBlock);
    }
}
