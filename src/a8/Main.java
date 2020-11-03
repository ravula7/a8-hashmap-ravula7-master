package a8;


import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,String> passwordManager = new PasswordManager<>();
        passwordManager.put("facebook", "no");
        passwordManager.put("facebook","again");
        passwordManager.put("webkinz", "what");
        passwordManager.put("insta", "never");
        System.out.println(passwordManager.size());
        System.out.println(passwordManager.remove("insta"));
        System.out.println(passwordManager.remove("facebook"));
        System.out.println(passwordManager.remove("webkinz"));
       /* Account account1 = new Account("facebook","no");
        Account account2 = new Account("webkinz","yes");
        Account account3 = new Account("facebook","again");
        Account account4 = new Account("facebook","okay");
        */





        // your code below
    }
}
