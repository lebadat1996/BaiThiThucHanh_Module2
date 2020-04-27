import java.io.Serializable;
import java.util.Scanner;

public class Phone implements Serializable {
    private String numberPhone;
    private String Name;
    private String Address;
    private String facebook;
    private String Email;

    public Phone() {

    }

    public Phone(String numberPhone, String name, String address, String facebook, String email) {
        this.numberPhone = numberPhone;
        Name = name;
        Address = address;
        this.facebook = facebook;
        Email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void EnterInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter name: ");
        this.Name = scanner.nextLine();
        System.out.print("\nEnter NumberPhone: ");
        this.numberPhone = scanner.nextLine();
        System.out.print("\nEnter Address: ");
        this.Address = scanner.nextLine();
        System.out.print("\nEnter Email: ");
        this.Email = scanner.nextLine();
        System.out.print("\nEnter Facebook: ");
        this.facebook = scanner.nextLine();
    }

    public void ShowInfo() {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s",
                this.Name, this.numberPhone, this.Address, this.Email, this.facebook);
        System.out.println();
    }
}
