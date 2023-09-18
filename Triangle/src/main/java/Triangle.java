import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first side: ");
        int a = sc.nextInt();


        System.out.print("Enter second side: ");
        int b = sc.nextInt();

        System.out.print("Enter third side: ");
        int c = sc.nextInt();
        sc.close();
        if ((a + b > c && b + c > a && a + c > b)
                || (b + a > c && a + c > b && b + c > a)
                || (c + a > b && a + b > c && c + b > a)) {
            System.out.println("Triangle is valid.");

            if (a == b && b == c) {
                System.out.println("Equilateral Triangle");
            } else if (a == b || b == c || a == c) {
                System.out.println("Isosceles Triangle");
            } else {
                System.out.println("Scalene Triangle");
            }
        } else {
            System.out.println("Triangle is invalid.");
        }
    }
}