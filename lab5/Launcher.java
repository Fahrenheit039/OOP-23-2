import java.util.Scanner;

class Launcher {
    static FileUserRepository FUR;
    static FileUserManager FUM;
    public Launcher(){
        this.FUR = new FileUserRepository();
        this.FUM = new FileUserManager(FUR);
    }

    private static void menu(){
        System.out.println("\nCommand list:");
        if (!FUM.isAuth()) {
            System.out.println("\"auth\" for authentication");
            System.out.println("\"register\" for registration to");
        }
        if (FUM.isAuth()) {
            System.out.println("\"logout\" to change user");
            System.out.println("\"app\" to run Application");
        }
        System.out.println("\"exit\" for exit");
    }

    ////////////////////////////////////////
    public static void main(String[] args) {

        System.out.printf("\nWelcome to the App Launcher\n");

        Launcher launcher = new Launcher();

        menu();

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while ( !command.equals("exit") ) {
            switch (command) {
                case("auth"): FUM.auth(FUR); break;
                case("register"): FUM.registration(FUR); break;

                case("logout"): FUM.logout(FUR); break;
                case("app"): App.main(); break;

                case "exit": return;
                default:break;
            }
            menu();
            System.out.print("next command : ");
            scanner = new Scanner(System.in);
            command = scanner.nextLine();
        }


    }


}

