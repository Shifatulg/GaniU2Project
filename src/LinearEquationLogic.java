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
        double parameter_1 = Double.parseDouble(coord1.substring(1,coord1.indexOf(",")));
        double parameter_2 = Double.parseDouble(coord1.substring(coord1.indexOf(",") + 1, coord1.length() - 1));
        double parameter_3 = Double.parseDouble(coord2.substring(1,coord2.indexOf(",")));
        double parameter_4 = Double.parseDouble(coord2.substring(coord2.indexOf(",")+ 1, coord2.length() - 1));
        coords = new LinearEquation(parameter_1, parameter_3, parameter_2, parameter_4);
    }

    private void methodCall() {
        System.out.println(coords.lineInfo());
        System.out.print("Enter a value for x: ");
        double choice = scan.nextDouble();
        System.out.println(coords.coordinateForX(choice));
    }

    private void reiterate() {
        String answer;
        scan.nextLine();
        while (true) {
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
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
