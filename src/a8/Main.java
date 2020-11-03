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





/*
        boolean enter = false;
        while(enter == false){
            System.out.println("Enter password:");
            String master = scanner.next();
            if(passwordManager.checkMasterPassword(master)){
                enter = true;
            }
        }
        boolean exit = false;
        while(exit == false){
            String input = scanner.next();
            if(input.equals("New password")){
                String website = scanner.next();
                String password = scanner.next();
                passwordManager.put(website,password);
                System.out.print("New password added");
            }
            else if(input.equals("Get password")){

            }
            else if(input.equals("Delete account")){

            }
            else if(input.equals("Check duplicate password")){

            }
            else if(input.equals("Get accounts")){

            }
            else if(input.equals("Generate random password")){

            }

        }

 */
        // your code below
    }
}
