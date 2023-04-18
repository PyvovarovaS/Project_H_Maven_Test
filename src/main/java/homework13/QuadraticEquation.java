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

    public void solve() {
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("Рівняння ax^2 + bx + c = 0 має корені:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
        } else if (discriminant == 0) {
            double x1 = -b / (2 * a);
            System.out.println("Рівняння ax^2 + bx + c = 0 має єдиний корінь:");
                System.out.println("x = " + x1);
        } else {
                System.out.println("Рівняння ax^2 + bx + c = 0 не має дійсних коренів.");
        }
    }
    public double getX1() {
        double discriminant = b * b - 4 * a * c;
        if (discriminant >= 0) {
            return (-b + Math.sqrt(discriminant)) / (2 * a);
        } else {
            return Double.NaN;
        }
    }
    public double getX2() {
        double discriminant = b * b - 4 * a * c;
        if (discriminant >= 0) {
            return (-b - Math.sqrt(discriminant)) / (2 * a);
        } else {
            return Double.NaN;
        }
    }
}
