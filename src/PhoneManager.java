import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneManager {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Phone> phoneList = new ArrayList<>();
        int Choose;
        do {
            System.out.print("----Quản lý chức năng hiển thị danh bạ----");
            System.out.print("\nChức năng chọn theo số (để tiếp tục)");
            System.out.print("\n1. EnterInfo ");
            System.out.print("\n2. ShowInfo ");
            System.out.print("\n3. Them moi ");
            System.out.print("\n4. cap nhat");
            System.out.print("\n5. Xoa");
            System.out.print("\n6. Tim kiem");
            System.out.print("\n7. Ghi vao File ");
            System.out.print("\n8. Doc File ");
            System.out.print("\n9. Exit ");
            System.out.print("\nNhap choose: ");
            Choose = scanner.nextInt();
            switch (Choose) {
                case 1:
                    EnterInfo(scanner, phoneList);
                    break;
                case 2:
                    ShowInfo(phoneList);
                    break;
                case 3:
                    Add(phoneList);
                    break;
                case 4:
                    Edit(scanner, phoneList);
                    break;
                case 5:
                    Remove(scanner, phoneList);
                    break;
                case 6:
                    Search(scanner, phoneList);
                    break;
                case 7:
                    WriterProduct(phoneList);
                    break;
                case 8:
                    ReadProduct(phoneList);
                    break;
                case 9:
                    System.exit(1);
                default:
                    System.out.print("Ban da nhap sai");
                    break;
            }
        } while (Choose != 10);
    }

    private static void EnterInfo(Scanner scanner, List<Phone> phoneList) {
        System.out.print("Enter  so danh ba: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            Phone phone = new Phone();
            phone.EnterInfo();
            phoneList.add(phone);
        }
        return;
    }

    private static void ShowInfo(List<Phone> phoneList) {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s",
                "Ten", "Phone", "dia chi", "gmail", "facebook");
        System.out.println();
        for (Phone phone : phoneList) {
            phone.ShowInfo();
        }
        return;
    }

    private static void Add(List<Phone> phoneList) {
        System.out.println("Them moi: ");
        Phone phone = new Phone();
        phone.EnterInfo();
        phoneList.add(phone);
        return;
    }

    private static void Edit(Scanner scanner, List<Phone> phoneList) {
        scanner.nextLine();
        System.out.print("\nenter name: ");
        String name = scanner.nextLine();
        for (int i = 0; i < phoneList.size(); i++) {
            if (name.equals(phoneList.get(i).getName())) {
                System.out.print("Name Edit: ");
                String nameEdit = scanner.nextLine();
                phoneList.get(i).setName(nameEdit);
                System.out.print("Address Edit: ");
                String addressEdit = scanner.nextLine();
                phoneList.get(i).setAddress(addressEdit);
                System.out.print("phone Edit: ");
                String phoneEdit = scanner.nextLine();
                phoneList.get(i).setNumberPhone(phoneEdit);
                System.out.print("Email Edit: ");
                String EmailEdit = scanner.nextLine();
                phoneList.get(i).setEmail(EmailEdit);
                System.out.print("Facebook Edit: ");
                String faceEdit = scanner.nextLine();
                phoneList.get(i).setEmail(faceEdit);
            }
        }
        return;
    }

    private static void Remove(Scanner scanner, List<Phone> phoneList) {
        scanner.nextLine();
        Phone phone1 = null;
        System.out.print("Enter name remove: ");
        String nameDanhba = scanner.nextLine();
        for (int i = 0; i < phoneList.size(); i++) {
            if (nameDanhba.equals(phoneList.get(i).getName())) {
                phone1 = phoneList.get(i);
                break;
            }
        }
        if (phone1 != null) {
            phoneList.remove(phone1);
        }
        return;
    }

    private static void Search(Scanner scanner, List<Phone> phoneList) {
        scanner.nextLine();
        System.out.print("Enter the Name Danh Ba to search: ");
        String nameDanhBa = scanner.nextLine();
        for (int i = 0; i < phoneList.size(); i++) {

            if (nameDanhBa.equals(phoneList.get(i).getName())) {
                phoneList.get(i).ShowInfo();
            }
        }
    }

    private static void WriterProduct(List<Phone> phoneList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("Hello1.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(phoneList);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ReadProduct(List<Phone> phoneList) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream("Hello1.txt");
            ois = new ObjectInputStream(fis);
            Object obj = null;
            obj = ois.readObject();
            System.out.println(obj.toString());
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}