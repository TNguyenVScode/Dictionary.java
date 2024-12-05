// This class stores data
public class DictionaryNode {
    
    // Fields to store the data for a record
    int key; // A unique identifier for the record
    String firstName; 
    String lastName; 
    String address; 
    String city; 
    String state; 
    String zip; 
    String email; 
    String phone; 

    // References to the left and right child nodes in the binary search tree
    DictionaryNode left; 
    DictionaryNode right; 

    // Constructor to initialize a new node with the given data
    public DictionaryNode(
            int key, 
            String firstName, 
            String lastName,
            String address, 
            String city, 
            String state, 
            String zip, 
            String email, 
            String phone
    ) 
    {
        // Assigning the input values to the respective fields
        this.key = key; 
        this.firstName = firstName; 
        this.lastName = lastName; 
        this.address = address; 
        this.city = city; 
        this.state = state; 
        this.zip = zip; 
        this.email = email; 
        this.phone = phone; 

        // Initialize the left and right child to null since this node doesn't have children yet
        this.left = null;
        this.right = null;
    }
}
