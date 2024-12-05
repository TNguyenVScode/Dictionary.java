import java.util.Scanner;

public class BinarySearchTree {
    // Used to get user input
    private static Scanner scanner = new Scanner(System.in);
    
    // Root node of the binary search tree
    private DictionaryNode root;

    // Constructor for the BST
    public BinarySearchTree() {
        this.root = null; 
    }

    public DictionaryNode getRoot() {
        return root;
    }

    // Adding a new record 
    public void add(int key, String firstName, String lastName, String address, String city, String state, String zip, String email, String phone) {
        root = addRecursive(root, key, firstName, lastName, address, city, state, zip, email, phone);
    }

    // Recursive method 
    private DictionaryNode addRecursive(DictionaryNode node, int key, String firstName, String lastName, String address, String city, String state, String zip, String email, String phone) {
        if (node == null) { 
            return new DictionaryNode(key, firstName, lastName, address, city, state, zip, email, phone);
        }

        // If the new key is smaller, go left
        if (key < node.key) {
            node.left = addRecursive(node.left, key, firstName, lastName, address, city, state, zip, email, phone);
        } 
        // If the new key is larger, go right
        else if (key > node.key) {
            node.right = addRecursive(node.right, key, firstName, lastName, address, city, state, zip, email, phone);
        }
        // If key is equal, do nothing 
        return node;
    }

    // Deleting a record from the tree based on the key
    public void delete(int key) {
        root = deleteRecursive(root, key); 
    }

    // Recursive helper for deletion
    private DictionaryNode deleteRecursive(DictionaryNode node, int key) {
        if (node == null) { 
            System.out.println("Record not found.");
            return null;
        }

        // Search for the key
        if (key < node.key) {
            node.left = deleteRecursive(node.left, key); // Go left
        } else if (key > node.key) {
            node.right = deleteRecursive(node.right, key); // Go right
        } else {
            // Key found, now handle the case:
            // If the node has one or no children
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // If the node has two children, find the smallest value in the right subtree
            node.key = findMin(node.right).key;
            // Replace the node's key and delete the smallest value in the right subtree
            node.right = deleteRecursive(node.right, node.key);
        }
        return node;
    }

    // Helper method to find the smallest key in a subtree
    private DictionaryNode findMin(DictionaryNode node) {
        while (node.left != null) { 
            node = node.left;
        }
        return node; 
    }

    // Modify an existing record 
    public void modify(int key, String field, String newValue) {
        // Find the node with the key
        DictionaryNode node = search(root, key);
        if (node == null) { // If not found, let the user know
            System.out.println("Record not found.");
            return;
        }

        // Update the correct field 
        switch (field.toLowerCase()) {
            case "firstname":
                node.firstName = newValue;
                break;
            case "lastname":
                node.lastName = newValue;
                break;
            case "address":
                node.address = newValue;
                break;
            case "city":
                node.city = newValue;
                break;
            case "state":
                node.state = newValue;
                break;
            case "zip":
                node.zip = newValue;
                break;
            case "email":
                node.email = newValue;
                break;
            case "phone":
                node.phone = newValue;
                break;
            default: // If the user enters a field that doesn't exist
                System.out.println("Invalid field.");
                return;
        }
        System.out.println("Record updated!"); 
    }

    // Search for a record in the tree
    public DictionaryNode search(DictionaryNode node, int key) {
        // If node is null or key matches, return it
        if (node == null || node.key == key) {
            return node;
        }
        // Go left or right depending on the key
        if (key < node.key) {
            return search(node.left, key);
        }
        return search(node.right, key);
    }

    // Print all records in the tree 
    public void printAll() {
        printInOrder(root);
    }

    // Helper method for in-order traversal
    private void printInOrder(DictionaryNode node) {
        if (node != null) {
            printInOrder(node.left); // Go left
            System.out.println("Key: " + node.key + ", Name: " + node.firstName + " " + node.lastName);
            printInOrder(node.right); // Go right
        }
    }

    // Node class representing a single record
    public static class DictionaryNode {
        int key;
        String firstName, lastName, address, city, state, zip, email, phone;
        DictionaryNode left, right; 

        // Constructor for a node
        public DictionaryNode(int key, String firstName, String lastName, String address, String city, String state, String zip, String email, String phone) {
            this.key = key;
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.city = city;
            this.state = state;
            this.zip = zip;
            this.email = email;
            this.phone = phone;
            this.left = null;
            this.right = null; 
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(); 

        // Infinite loop for the menu 
        while (true) {
            // Print menu options
            System.out.println("\nMenu:");
            System.out.println("1. Add Record");
            System.out.println("2. Delete Record");
            System.out.println("3. Modify Record");
            System.out.println("4. Lookup Record");
            System.out.println("5. Print All Records");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            // Handle user choice
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
                    System.out.println("Goodbye!"); // Exit the program
                    return;
                default: // Handle invalid options
                    System.out.println("Invalid option.");
            }
        }
    }

    // Helper method to add a record 
    private static void addRecord(BinarySearchTree bst) {
        System.out.print("Enter key: ");
        int key = scanner.nextInt();
        scanner.nextLine(); // Consume newline
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

    // Helper method to delete a record
    private static void deleteRecord(BinarySearchTree bst) {
        System.out.print("Enter key to delete: ");
        int key = scanner.nextInt();
        bst.delete(key);
    }

    // Helper method to modify a record
    private static void modifyRecord(BinarySearchTree bst) {
        System.out.print("Enter key to modify: ");
        int key = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter field to modify(firstname, lastname, address, city, state, zip, email, phone): ");
        String field = scanner.nextLine();
        System.out.print("Enter new value: ");
        String newValue = scanner.nextLine();
        bst.modify(key, field, newValue);
    }

    //helper method
    private static void lookupRecord(BinarySearchTree bst) {
        System.out.print("Enter key to lookup: ");
        int key = scanner.nextInt();
        DictionaryNode node = bst.search(bst.getRoot(), key);
        if (node != null) { //if found
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
        } else { //if not found
            System.out.println("Record not found.");
        }
    }

    // Helper method to print all records
    private static void printAll(BinarySearchTree bst) {
        System.out.println("Records in-order:");
        bst.printAll();
    }
}

