package homework13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть коефіцієнт a: ");
        double a = scanner.nextDouble();
        System.out.print("Введіть коефіцієнт b: ");
        double b = scanner.nextDouble();
        System.out.print("Введіть коефіцієнт c: ");
        double c = scanner.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double[] roots = equation.solve();
        if (roots.length == 2) {
            System.out.println("Рівняння ax^2 + bx + c = 0 має корені:");
            System.out.println("x1 = " + roots[0]);
            System.out.println("x2 = " + roots[1]);
        } else if (roots.length == 1) {
            System.out.println("Рівняння ax^2 + bx + c = 0 має єдиний корінь:");
            System.out.println("x = " + roots[0]);
        } else {
            System.out.println("Рівняння ax^2 + bx + c = 0 не має дійсних коренів.");
        }
    }
}






