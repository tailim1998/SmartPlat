package my.edu.tarc.user.smartplat;

public class Resident {
    private String Name;
    private String Contact;
    private String Email;
    private String Address;

    public Resident() {
    }

    public Resident(String name, String contact, String email, String address) {
        Name = name;
        Contact = contact;
        Email = email;
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
