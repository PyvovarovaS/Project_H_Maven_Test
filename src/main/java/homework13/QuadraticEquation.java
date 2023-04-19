package homework13;

public class QuadraticEquation {
    private final double a;
    private final double b;
    private final double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] solve() {
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[]{x1, x2};
        } else if (discriminant == 0) {
            double x1 = -b / (2 * a);
            return new double[]{x1, x1};
        } else {
            return new double[]{};
        }
    }
    public double getX1() {
        double[] roots = solve();
        if (roots.length >= 1) {
            return roots[0];
        } else {
            return Double.NaN;
        }
    }
    public double getX2() {
        double[] roots = solve();
        if (roots.length == 2) {
            return roots[1];
        } else {
            return Double.NaN;
        }
    }
}
