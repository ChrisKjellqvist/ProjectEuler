package problems90AndUp;

public class Problem144V2 {
    public static double slopeAtPoint(double x, double y) {
        return (-4 * x) / y;
    }

    public static Point findIntersection(Line a, Line b) {
        double x = (b.b - a.b) / (a.slope - b.slope);
        Point answer = new Point(x, a.getValue(x));
        return answer;
    }

    public static Point findIntersectionWithEllipse(Line a, Point blacklist) {
        double x = QF(4 + a.slope * a.slope, 2 * a.slope * a.b, a.b * a.b - 100);
        Point answer = new Point(x, a.getValue(x));
        if (isTooClose(answer.x, blacklist.x) && isTooClose(answer.y, blacklist.y)) {
            x = QF2(4 + a.slope * a.slope, 2 * a.slope * a.b, a.b * a.b - 100);
            answer = new Point(x, a.getValue(x));
        }
        return answer;
    }

    public static boolean isTooClose(double a, double b) {
        return Math.abs(a - b) < .001;
    }

    public static double QF(double a, double b, double c) {
        double x = (-b - Math.sqrt(b * b - 4 * (a * c))) / (2 * a);
        return x;
    }

    public static double QF2(double a, double b, double c) {
        double x = (-b + Math.sqrt(b * b - 4 * (a * c))) / (2 * a);
        return x;
    }

    public static Point findNextPoint(Point a, Point b) {
        double refSlope = slopeAtPoint(b.x, b.y);

        Line normal = new Line(1 / (-refSlope), b);
        Point intersection = findIntersection(new Line(refSlope, a), normal);

        double difX = a.x - intersection.x;
        double difY = a.y - intersection.y;
        Point reflection = new Point(intersection.x - difX, intersection.y - difY);
        Point nextPoint = findIntersectionWithEllipse(new Line(reflection, b), b);
        return nextPoint;
    }

    static boolean foundExit(Point pResult) {
        return pResult.y > 0 && Math.abs(pResult.x) <= 0.01;
    }

    public static void main(String[] args) {
        Point a = new Point(0, 10.1);
        Point b = new Point(1.4, -9.6);
        int count = 0;
        final long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            while (!foundExit(b)) {
                Point newPoint = findNextPoint(a, b);
                a = b;
                b = newPoint;
                count++;
            }
        }
        final long t2 = System.currentTimeMillis();
        System.out.println("Chris' Version");
        System.out.println(count);
        System.out.println(t2 - t1);
    }

    static class Point {
        double x;
        double y;

        public Point(double X, double Y) {
            x = X;
            y = Y;
        }
    }

    static class Line {
        double slope;
        double b;

        public Line(Point a, Point B) {
            slope = (a.y - B.y) / (a.x - B.x);
            b = -slope * a.x + a.y;
        }

        public Line(double m, Point a) {
            slope = m;
            b = (-m) * a.x + a.y;
        }

        public void setSlope(double m) {
            slope = m;
        }

        public void setB(double B) {
            b = B;
        }

        public double getValue(double x) {
            return slope * x + b;
        }
    }
}