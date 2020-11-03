package a8;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> passwordManager = new PasswordManager<>();
        System.out.println("Enter Master Password: ");
        String enteredPassword = scanner.nextLine();
        System.out.println(passwordManager.checkMasterPassword(enteredPassword));




        // your code below
    }
}
