import java.util.Scanner;

import static java.lang.Double.parseDouble;

public class LinearEquationLogic {

    private LinearEquation coords;
    private Scanner scan;
    private boolean Continue;

    public LinearEquationLogic() {
        coords = null;
        scan = new Scanner(System.in);
        Continue = true;
    }

    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        while (Continue) {
            initialize();
            methodCall();
            reiterate();
        }
    }

    private void initialize() {
        System.out.print("Enter Coordinate 1: ");
        String coord1 = scan.nextLine();
        System.out.print("Enter Coordinate 2: ");
        String coord2 = scan.nextLine();
        int parameter_1 = Integer.parseInt(coord1.substring(1,coord1.indexOf(",")));
        int parameter_2 = Integer.parseInt(coord1.substring(coord1.indexOf(",") + 1, coord1.length() - 1));
        int parameter_3 = Integer.parseInt(coord2.substring(1,coord2.indexOf(",")));
        int parameter_4 = Integer.parseInt(coord2.substring(coord2.indexOf(",")+ 1, coord2.length() - 1));
        coords = new LinearEquation(parameter_1, parameter_3, parameter_2, parameter_4);
    }

    private void methodCall() {
        System.out.println(coords.lineInfo());
        if (coords.iterate()) {
          System.out.print("Enter a value for x: ");
          double choice = scan.nextDouble();
          System.out.print(coords.coordinateForX(choice));
        }
    }

    private void reiterate() {
        String answer;
        while (true) {
            scan.nextLine();
            System.out.println("Would you like to enter another pair of coordinates? y/n: ");
            answer = scan.nextLine();
            answer = answer.toLowerCase();
            if (answer.equals("n")) {
                Continue = false;
            } else if (answer.equals("y")) {
                Continue = true;
            } else {
                System.out.println("Invalid option, try again!");
                continue;
            }
            break;
        }
    }
}
