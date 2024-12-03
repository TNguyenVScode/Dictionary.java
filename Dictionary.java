import java.util.Scanner;

public class Dictionary {

    // Simple node structure for the binary search tree
    static class Node {
        int key; // Primary key
        String firstName, lastName, email, phone;
        Node left, right;

        public Node(int key, String firstName, String lastName, String email, String phone) {
            this.key = key;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.phone = phone;
            this.left = null;
            this.right = null;
        }
    }

    // Root node
    private Node root;

    public Dictionary() {
        root = null;
    }

    // Add a record
    public void add(int key, String firstName, String lastName, String email, String phone) {
        root = addRecursive(root, key, firstName, lastName, email, phone);
        System.out.println("Record added!");
    }

    private Node addRecursive(Node node, int key, String firstName, String lastName, String email, String phone) {
        if (node == null) {
            return new Node(key, firstName, lastName, email, phone);
        }

        if (key < node.key) {
            node.left = addRecursive(node.left, key, firstName, lastName, email, phone);
        } else if (key > node.key) {
            node.right = addRecursive(node.right, key, firstName, lastName, email, phone);
        }
        return node;
    }

    // Delete a record
    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node node, int key) {
        if (node == null) {
            System.out.println("Record not found.");
            return null;
        }

        if (key < node.key) {
            node.left = deleteRecursive(node.left, key);
        } else if (key > node.key) {
            node.right = deleteRecursive(node.right, key);
        } else {
            System.out.println("Record deleted.");
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            node.key = findMin(node.right).key;
            node.right = deleteRecursive(node.right, node.key);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Modify a record
    public void modify(int key, String field, String newValue) {
        Node node = search(root, key);
        if (node == null) {
            System.out.println("Record not found.");
            return;
        }
        if (field.equalsIgnoreCase("firstname")) {
            node.firstName = newValue;
        } else if (field.equalsIgnoreCase("lastname")) {
            node.lastName = newValue;
        } else if (field.equalsIgnoreCase("email")) {
            node.email = newValue;
        } else if (field.equalsIgnoreCase("phone")) {
            node.phone = newValue;
        } else {
            System.out.println("Invalid field.");
            return;
        }
        System.out.println("Record updated!");
    }

    // Lookup records
    public void lookup(String order) {
        if (order.equalsIgnoreCase("preorder")) {
            preOrder(root);
        } else if (order.equalsIgnoreCase("inorder")) {
            inOrder(root);
        } else if (order.equalsIgnoreCase("postorder")) {
            postOrder(root);
        } else {
            System.out.println("Invalid traversal order.");
        }
    }

    private void preOrder(Node node) {
        if (node != null) {
            printNode(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            printNode(node);
            inOrder(node.right);
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            printNode(node);
        }
    }

    // Search a record
    private Node search(Node node, int key) {
        if (node == null || node.key == key) {
            return node;
        }
        if (key < node.key) {
            return search(node.left, key);
        }
        return search(node.right, key);
    }

    // Print record details
    private void printNode(Node node) {
        System.out.println("Key: " + node.key + ", Name: " + node.firstName + " " + node.lastName +
                ", Email: " + node.email + ", Phone: " + node.phone);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Record");
            System.out.println("2. Delete Record");
            System.out.println("3. Modify Record");
            System.out.println("4. Lookup Records");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter key: ");
                int key = scanner.nextInt();
                scanner.nextLine();
                System.out.print("First Name: ");
                String firstName = scanner.nextLine();
                System.out.print("Last Name: ");
                String lastName = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Phone: ");
                String phone = scanner.nextLine();
                dictionary.add(key, firstName, lastName, email, phone);

            } else if (choice == 2) {
                System.out.print("Enter key to delete: ");
                int key = scanner.nextInt();
                dictionary.delete(key);

            } else if (choice == 3) {
                System.out.print("Enter key to modify: ");
                int key = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Field to modify (firstname, lastname, email, phone): ");
                String field = scanner.nextLine();
                System.out.print("Enter new value: ");
                String newValue = scanner.nextLine();
                dictionary.modify(key, field, newValue);

            } else if (choice == 4) {
                System.out.print("Enter traversal order (preorder, inorder, postorder): ");
                scanner.nextLine();
                String order = scanner.nextLine();
                dictionary.lookup(order);

            } else if (choice == 5) {
                System.out.println("Exiting program.");
                break;

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
