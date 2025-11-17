package bai1;

/**
 * Class to solve quadratic equations
 * Equation: ax^2 + bx + c = 0
 */
public class QuadraticEquation {
    
    /**
     * Solves quadratic equation ax^2 + bx + c = 0
     * @param a coefficient of x^2
     * @param b coefficient of x
     * @param c constant term
     * @return String containing the solution
     */
    public String giaiPT2(int a, int b, int c) {
        // Case 1: Not a quadratic equation (a = 0)
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    return "Phuong trinh vo so nghiem (Infinite solutions)";
                } else {
                    return "Phuong trinh vo nghiem (No solution)";
                }
            } else {
                // Linear equation: bx + c = 0
                double x = -c / (double) b;
                return "Phuong trinh bac nhat co nghiem: x = " + x;
            }
        }
        
        // Case 2: Quadratic equation
        double delta = b * b - 4 * a * c;
        
        if (delta < 0) {
            return "Phuong trinh vo nghiem (No real solution, delta < 0)";
        } else if (delta == 0) {
            double x = -b / (2.0 * a);
            return "Phuong trinh co nghiem kep: x1 = x2 = " + x;
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2.0 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2.0 * a);
            return "Phuong trinh co 2 nghiem phan biet: x1 = " + x1 + ", x2 = " + x2;
        }
    }
    
    // Test the method
    public static void main(String[] args) {
        QuadraticEquation qe = new QuadraticEquation();
        
        // Test cases
        System.out.println("Test 1 - (1, -3, 2): " + qe.giaiPT2(1, -3, 2));
        System.out.println("Test 2 - (1, -2, 1): " + qe.giaiPT2(1, -2, 1));
        System.out.println("Test 3 - (1, 0, 1): " + qe.giaiPT2(1, 0, 1));
        System.out.println("Test 4 - (0, 2, -4): " + qe.giaiPT2(0, 2, -4));
    }
}
