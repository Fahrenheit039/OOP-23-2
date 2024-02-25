import java.util.Scanner;

class App extends Launcher {

    private static boolean check(){
        return FUM.isAuth();
    }

    public static void main() {

//        App app = new App();
        if ( !check() ) {
            System.out.println("Please log in to run the Application");
            return;
        }
        System.out.printf("\nWelcome to guessing game!\nYou are enter as %s!\n", FUM.currentUser.getName());

        boolean game = true;
        Scanner in;
        int inputInt;

        //borders
        int a = 1, b = 100;

        while(game){

            System.out.print("Who will guess the next number? 1 - player \\ 2 - computer \\ 3 - for exit : ");
            in = new Scanner(System.in);
            inputInt = in.nextInt();

            boolean solved;
            int count, x;
            int tmp_a, tmp_b;

            switch (inputInt) {

                case 1:
                    System.out.printf("guess a number from %d to %d\n", a, b);

                    solved = false;
                    count = 0; x = 0;
                    tmp_a = a; tmp_b = b;

                    while(!solved){
                        x = tmp_a + (int)(Math.random() * (tmp_b - tmp_a + 1));
                        count++;

                        System.out.printf("Is the correct answer? : %d  \\ 1 - less \\ 2 - found! \\ 3 - more \\\\ ", x);

                        in = new Scanner(System.in);
                        inputInt = in.nextInt();

                        switch(inputInt){
                            case 1:
                                tmp_b = x;
                                break;
                            case 2:
                                solved = true;
                                break;
                            case 3:
                                tmp_a = x;
                                break;

                            default:
                                System.out.println("Something went wrong. try again");
                                break;
                        }

                        if (tmp_b - tmp_a == 2) {
                            x = tmp_a + 1;
                            solved = true;
                            break;
                        }
                    }
                    System.out.printf("player's number %d found in %d attempts.\n", x, count);
                    break;
                case 2:
                    System.out.printf("the computer guessed a number from %d to %d. try to guess it.\n", a, b);

                    solved = false;
                    count = 0; x = a + (int)(Math.random()*b);;
                    tmp_a = a; tmp_b = b;

                    while(!solved){
                        in = new Scanner(System.in);
                        inputInt = in.nextInt();
                        count++;

                        if (inputInt < x) System.out.println("The correct answer is more.");
                        else if (inputInt > x) System.out.println("The correct answer is less.");
                        else {
                            System.out.println("correct answer found!");
                            solved = true;
                        }
                    }
                    System.out.printf("player's number %d found in %d attempts.\n", x, count);
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Something went wrong. try again");
                    break;

            }


        }


    }


}
