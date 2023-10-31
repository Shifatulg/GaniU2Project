import java.util.Scanner;
public class LinearEquation {

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private Scanner scan;
    public LinearEquation(int firstX, int firstY, int secondX, int secondY) {
        x1 = firstX;
        x2 = secondX;
        y1 = firstY;
        y2 = secondY;
        scan = new Scanner(System.in);
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public double yIntercept() {

        return roundedToHundredth(-1 * (slope() *  x1 - y1));
    }
    public double slope() {
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }

    public String equation() {
        String fEquation = "y = ";
        if (x2 == x1) {
            return "x= " + x1;
        } else if (y2 == y1) {
            return "y = " + y1;
        }
        if ((double)(y2 - y1) / (x2 - x1) < 0) {
            fEquation += "-";
        }
        if (Math.abs((double)(y2 - y1) / (x2 - x1)) == 1) {
            fEquation += "";
        } else if ((y2 - y1) % (x2 - x1) == 0) {
            fEquation += Math.abs((y2 - y1) / (x2 - x1));
        } else {
            fEquation += Math.abs(y2 - y1);
            if (x2 - x1 != 1) {
                fEquation += "/" + Math.abs(x2 - x1);
            }
        }

        fEquation += "x ";
        if (yIntercept() == 0) {
            fEquation += "";
        } else if (yIntercept() < 0) {
            fEquation += "- " + Math.abs(yIntercept());
        } else {
            fEquation += "+ " + Math.abs(yIntercept());
        }
        return fEquation;
    }

    public String coordinateForX(double x) {
        double y = slope() * x + yIntercept();
        return "The points on the line is (" + x + ", " + roundedToHundredth(y) + ")\n\n";
    }

    public String lineInfo() {
        String info = "";
        info += "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2
                + ")";
        info += "\nThe equation of this line between these points is: " + equation();
        info += "\nThe slope of this line is : " + slope();
        info += "\nThe y-intercept of this line is: " + yIntercept();
        info += "\nThe distance between these points is " + distance();
        if (x2 == x1) {
            info = "\nThis is a vertical line and the equation is: x = " + x1 + "\n";
        }
        return info;
    }

    public boolean iterate() {
        if (x2 == x1) {
            return false;
        }
        return true;
    }
    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}