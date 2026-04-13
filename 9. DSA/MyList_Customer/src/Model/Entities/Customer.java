package Model.Entities;

public class Customer {
    String id;
    String name;
    String dob;
    String address;

    public Customer(String address, String dob, String name, String id) {
        this.address = address;
        this.dob = dob;
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name;
    }
}

