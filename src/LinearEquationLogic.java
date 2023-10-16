import java.util.Scanner;
public class LinearEquationLogic {

    private LinearEquation coords;
    private Scanner scan;
    public LinearEquationLogic() {
        coords = null;
        scan = new Scanner(System.in);
    }

    public void start() {

    }

    private void initialize() {
        System.out.print("Enter Coordinate 1: ");
        String coord1 = scan.nextLine();
        System.out.print("Enter Coordinate 2: ");
        String coord2 = scan.nextLine();
    }
}
