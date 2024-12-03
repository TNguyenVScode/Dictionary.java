import java.util.Scanner;

public class DictionaryTraverse {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Record");
            System.out.println("2. Delete Record");
            System.out.println("3. Modify Record");
            System.out.println("4. Lookup Record");
            System.out.println("5. Print All Records");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addRecord(bst);
                    break;
                case 2:
                    deleteRecord(bst);
                    break;
                case 3:
                    modifyRecord(bst);
                    break;
                case 4:
                    lookupRecord(bst);
                    break;
                case 5:
                    printAll(bst);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void addRecord(BinarySearchTree bst) {
        System.out.print("Enter key: ");
        int key = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter state: ");
        String state = scanner.nextLine();
        System.out.print("Enter zip: ");
        String zip = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        bst.add(key, firstName, lastName, address, city, state, zip, email, phone);
    }

    private static void deleteRecord(BinarySearchTree bst) {
        System.out.print("Enter key to delete: ");
        int key = scanner.nextInt();
        bst.delete(key);
    }

    private static void modifyRecord(BinarySearchTree bst) {
        System.out.print("Enter key to modify: ");
        int key = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter field to modify (firstname, lastname, address, city, state, zip, email, phone): ");
        String field = scanner.nextLine();
        System.out.print("Enter new value: ");
        String newValue = scanner.nextLine();
        bst.modify(key, field, newValue);
    }

    private static void lookupRecord(BinarySearchTree bst) {
        System.out.print("Enter key to lookup: ");
        int key = scanner.nextInt();
        DictionaryNode node = bst.search(bst.getRoot(), key);
        if (node != null) {
            System.out.println("Record found: ");
            System.out.println("Key: " + node.key);
            System.out.println("First Name: " + node.firstName);
            System.out.println("Last Name: " + node.lastName);
            System.out.println("Address: " + node.address);
            System.out.println("City: " + node.city);
            System.out.println("State: " + node.state);
            System.out.println("Zip: " + node.zip);
            System.out.println("Email: " + node.email);
            System.out.println("Phone: " + node.phone);
        } else {
            System.out.println("Record not found.");
        }
    }

    private static void printAll(BinarySearchTree bst) {
        System.out.println("Records in-order:");
        printInOrder(bst.getRoot());
    }

    private static void printInOrder(DictionaryNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println("Key: " + node.key + ", First Name: " + node.firstName + ", Last Name: " + node.lastName);
            printInOrder(node.right);
        }
    }
}
