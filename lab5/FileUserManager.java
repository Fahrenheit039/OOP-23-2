import java.util.ArrayList;
import java.util.Scanner;

class FileUserManager implements IUserManager {

    User currentUser;
    boolean status;

    public FileUserManager(FileUserRepository FUR){
        status = false;
        currentUser = FUR.users.get(0);
    }

    @Override
    public boolean auth(FileUserRepository FUR) {
        try {
            if (!isAuth()) {
                Scanner scanner;
                String login = null, password = null;
                while(true){
                    scanner = new Scanner(System.in);
                    System.out.println("\nAuthentication");

                    System.out.print("login : ");
                    login = scanner.nextLine();
                    if (login.equals("exit")) break;

                    System.out.print("password : ");
                    password = scanner.nextLine();
                    if (password.equals("exit")) break;
                    System.out.println();

                    int index = FUR.isExist(login, password);
                    if (index > -1) {
                        status = true;
                        currentUser = FUR.get(index);
                        System.out.println("You are successfully logged in");
                        return true;
                    }
                }
                return false;
            } else System.out.println("You are already logged in");
            return true;
        } catch (Exception e) {
            System.out.println("auth Exception: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean logout(FileUserRepository FUR) {
        try {
            status = false;
            currentUser = FUR.users.get(0);
            return true;
        } catch (Exception e) {
            System.out.println("logout Exception: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean isAuth() {
        try {
            return status;
        } catch (Exception e) {
            System.out.println("isAuth Exception: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean registration(FileUserRepository FUR) {
        try {
            Scanner scanner;
            while(true){
                scanner = new Scanner(System.in);
                System.out.println("\nRegistration");

                System.out.print("Enter your name : ");
                String name = scanner.nextLine();
                if (name.equals("exit")) break;

                System.out.print("login : ");
                String login = scanner.nextLine();
                if (login.equals("exit")) break;

                System.out.print("password : ");
                String pass1 = scanner.nextLine();
                if (pass1.equals("exit")) break;

                System.out.print("confirm password : ");
                String pass2 = scanner.nextLine();
                if (pass2.equals("exit")) break;
                System.out.println();

                if (pass1.equals(pass2))
                    return FUR.add(new User(name, login, pass1));
                else System.out.println("Something went wrong. try again");
            }
            return false;
        } catch (Exception e) {
            System.out.println("registration Exception: " + e.getMessage());
            return false;
        }
    }

}

