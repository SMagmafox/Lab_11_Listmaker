import java.util.ArrayList;
import java.util.Scanner;


public class main2

{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        boolean quit = false;

        while (!quit)
        {
            printMenu();
            String command = SafeInput.getRegExString(in,"Choose an option","[AaDdIiPpQq]");

            switch (command.toUpperCase())
            {
                case "A":
                    addItem(in);
                    break;
                case "D":
                    deleteItem(in);
                    break;
                case "I":
                    insertItem(in);
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    quit = confirmQuit(in);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        System.out.println("Goodbye!");
        in.close();
    }

    private static void printMenu() {

    }

    {
        if (list.isEmpty())
        {
            System.out.println("List is empty.");
        }
        else
        {
            for (int C=0; C<list.size();C++)
            {
                System.out.println((C+1) + ". " + list.get(C));
            }
        }

        System.out.println("\nMenu Options:");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem(Scanner in)
    {
        String newItem = SafeInput.getNonZeroLenString(in,"Enter the item to add");
        list.add(newItem);
        System.out.println("Item added.");
    }

    private static void deleteItem(Scanner in)
    {
        int listLength = list.size();
        if(list.isEmpty()) {
            System.out.println("Nothing to delete.");
            return;
        }
        else {
            int newItem = SafeInput.getRangedInt(in,"Enter the position of the item to delete",1,10);
            list.remove(newItem-1);
            System.out.println("Item deleted.");
        }
    }

    private static void insertItem(Scanner in)
    {
        String newItem = SafeInput.getNonZeroLenString(in,"Enter the item to insert");
        int insertAt = SafeInput.getRangedInt(in,"Enter the position to insert after",0,list.size());
        list.add(insertAt-1,newItem);
        System.out.println("Item inserted.");
    }

    private static void printList()
    {
        if(list.isEmpty())
            System.out.println("List is empty.");
        else
        {
            System.out.println("Current list:");
            for(int i=0;i<list.size();i++)
                System.out.println((i+1)+". "+list.get(i));
        }
    }

    private static boolean confirmQuit(Scanner in)
    {
        return SafeInput.getYNConfirm(in,"Are you sure you want to quit?");
    }

    private static ArrayList<String> list = new ArrayList<>();
}//end of class