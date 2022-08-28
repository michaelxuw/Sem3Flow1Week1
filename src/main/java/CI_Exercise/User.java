package CI_Exercise;

public class User {
    String fname;
    String lname;
    String pw;
    String phone;
    String address;
    int id;

    public User(String fname, String lname, String pw, String phone, String address, int id) {
        this.fname = fname;
        this.lname = lname;
        this.pw = pw;
        this.phone = phone;
        this.address = address;
        this.id = id;
    }

    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}
