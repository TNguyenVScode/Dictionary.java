public class DictionaryNode {
    int key;
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String email;
    String phone;
    DictionaryNode left;
    DictionaryNode right;

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
