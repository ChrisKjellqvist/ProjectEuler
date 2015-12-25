package problems90AndUp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem102 {
    static class Point {
        double x;
        double y;

        public Point(double X, double Y) {
            x = X;
            y = Y;
        }

        public boolean is(Point a) {
            return this.x == a.x && this.y == a.y;
        }

    }

    public static boolean containsOrigin(Point p1, Point p2, Point p3) {
        Line[] lines = new Line[3];
        lines[0] = new Line(p1, p2);
        lines[1] = new Line(p2, p3);
        lines[2] = new Line(p3, p1);
        boolean[] conditions = new boolean[4];
        for (int i = 0; i < 3; i++) {
            if (lines[i].b > 0) {
                conditions[0] = true;
                i += 3;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (lines[i].b < 0) {
                i += 3;
                conditions[1] = true;
            }
        }
        for (int i = 0; i < 3; i++) {
            double inter = lines[i].xIntercept();
            if (inter < 0 && lines[i].containsX(inter)) {
                conditions[2] = true;
                i += 5;
            }
        }
        for (int i = 0; i < 3; i++) {
            double inter = lines[i].xIntercept();
            if (inter > 0 && lines[i].containsX(inter)) {
                conditions[3] = true;
                i += 5;
            }
        }
        return conditions[0] && conditions[1] && conditions[2] && conditions[3];
    }

    public static double doProblem() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input_files/p102_triangles.txt"));
        double j = 0;
        while (sc.hasNextLine()) {
            Point[] points = new Point[3];
            String[] list = sc.nextLine().split(",");

            for (int i = 0; i < 3; i++) {
                double x = Integer.parseInt(list[i * 2]);
                double y = Integer.parseInt(list[i * 2 + 1]);
                points[i] = new Point(x, y);
            }
            if (containsOrigin(points[0], points[1], points[2])) {
                j++;
            }
        }
        sc.close();
        return j;
    }

    static class Line {
        Point p1;
        Point p2;
        double[] xRange = new double[2];
        double slope;
        double b;

        public Line(Point P1, Point P2) {
            p1 = P1;
            p2 = P2;
            double temp = (p2.x - p1.x);
            if (temp == 0) {
                temp = 0.00001;
            }

            slope = (p2.y - p1.y) / temp;
            b = -1 * slope * (p1.x) + p1.y;
            xRange[0] = Math.min(p1.x, p2.x);
            xRange[1] = Math.max(p1.x, p2.x);
        }

        public double xIntercept() {
            return (-b) / slope;
        }

        public boolean containsX(double a) {
            if (a > xRange[1])
                return false;
            return a >= xRange[0];
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(doProblem());
    }
}