package Model.Entities;

public class Node {
    public Customer data;
    public Node next;

    public Node(Customer data) {
        this.data = data;
        this.next = null;
    }
}
