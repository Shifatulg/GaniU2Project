public class LinearEquation {

    private double x1;
    private double x2;
    private double y1;
    private double y2;
    public LinearEquation(double firstX, double secondX, double firstY, double secondY) {
        x1 = firstX;
        x2 = secondX;
        y1 = firstY;
        y2 = secondY;
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    public double yIntercept() {

        return roundedToHundredth(-1 * (slope() * x1 - y1));
    }
    public double slope() {
        return roundedToHundredth((y2 - y1) / (x2 - x1));
    }

    public String equation() {
        String fEquation = "y = ";
        if ((y2 - y1) == (int) (y2 - y1)) {
            int changeY = (int) (y2 - y1);
        }
        if ((x2 - x1) == (int) (x2 - x1)) {
            int changex = (int) (x2 - x1);
        }
        if (x2 == x1) {
            return "The equation of this line between these points is: x = " + x1;
        }
        else if (y2 == y1) {
            return "The equation of this line bewteen these points is: y = " + y1;
        }
        if ((y2 - y1) / (x2 - x1) < 0) {
            fEquation += "-";
        }
        if ((int)(y2 - y1) / (x2 - x1) == (y2 - y1) / (x2 - x1)) {
            if ((y2 - y1) / (x2 - x1) == 1 || (y2 - y1) / (x2 - x1) == -1) {
                fEquation += "";
            } else {
                fEquation += Math.abs() + "/" + Math.abs(x2 - x1);
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
        return "The equation of this line between these points is: " + fEquation;
    }

    public String coordinateForX(double x) {
        double y = slope() * x + yIntercept();
        return "The points on the line is (" + x + ", " + roundedToHundredth(y) + ")";
    }
    public String lineInfo() {
        if (x2 == x1) {
            return "The equation of this line between these points is: x = " + x1;
        }
            String info = "";
        info += "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2
 + ")";
        info += "\n" + equation();
        info += "\nThe slope of this line is : " + slope();
        info += "\nThe y-intercept of this line is: " + yIntercept();
        info += "\nThe distance between these points is " + distance();
        return info;
    }
    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
}