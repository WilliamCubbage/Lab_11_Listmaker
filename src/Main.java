import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        final String menu = "A - Add, D - Delete, P - Print, Q - Quit";
        boolean done = false;
        String cmd = "";

        do {
            displayList();
            cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();


            switch (cmd) {
                case "A":
                    String newItem = SafeInput.getNonZeroLenString(console, "Enter an item to add: ");           // Prompt the user for a list item
                    list.add(newItem);                                                                                  // Make sure that it is not an empty string
                    break;                                                                                              // Add it to the list

                case "D":
                    if (!list.isEmpty()) {                                                                                                       // Prompt the user for the number of the item to delete
                        int index = SafeInput.getRangedInt(console, "Enter the number of the item you wish to delete: ", 1, list.size());
                        list.remove(index - 1);
                    }
                    else {
                        displayList();                                                               // Translate the number to an index by subtracting 1
                    }
                                                                                                                        // Remove the item from the list
                    break;
                case "P":
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(console, "Are you sure you want to quit?"))
                    {
                        done = true;
                    }
                    break;

            }
            System.out.println("cmd is " + cmd);

        } while (!done);
    }//END OF MAIN

    private static void displayList() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%3d%35s", i + 1, list.get(i));
            }
        }
        else
            System.out.println("+++           List is empty            +++");
        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
    }
}