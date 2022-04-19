import java.util.Scanner;

/**
 * WelcomeScreen class to start the program and return to welcome screen if needed
 * @author Mohammed Hany Fattoh
 * Date: 6/9/2021
 */

public class WelcomeScreen {
    /**
     * Constructor to start the welcome screen of the program
     */
    WelcomeScreen(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to GoFo.GOFO!");
        System.out.println("What do you Want to do!\n1- Sign in\n2- Register\n3- Exit");
        int answer = input.nextInt();
        String name, email, password, location;
        int type;
        List list = new List();
        double startBalance;
        switch (answer) {
            case 1 : {
                System.out.print("Enter your Email: ");
                email = input.next();
                System.out.print("Enter your password: ");
                password = input.next();
                list.signIn(email, password);
                break;
            }
            case 2 : {
                System.out.print("Enter your name: ");
                name = input.next();
                System.out.print("Enter your Email: ");
                email = input.next();
                System.out.print("Enter your password: ");
                password = input.next();
                System.out.print("Enter your location: ");
                location = input.next();

                System.out.print("Enter your start balance: ");
                startBalance = input.nextDouble();
                if (startBalance < 0) {
                    System.out.println("Error: Wrong value");
                    System.exit(0);
                }
                System.out.println("Register as -> 1- Player \t 2- Playground Owner");
                type = input.nextInt();
                User s = new User(name, email, password, location, type, startBalance);
                list.addUser(type, s);
                break;
            }
            case 3 : System.exit(0);
            default : {
                System.out.println("Error: Wrong answer");
                WelcomeScreen welcomeScreen = new WelcomeScreen();
                break;
            }
        }
    }
}



