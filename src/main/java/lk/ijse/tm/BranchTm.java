package lk.ijse.tm;

public class BranchTm {
    private String name;
    private String contact;
    private String address;

    private String adminName;

    public BranchTm() {
    }

    public BranchTm(String name, String contact, String address, String adminName) {
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.adminName = adminName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
