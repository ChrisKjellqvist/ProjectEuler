package problems90AndUp;

public class Problem144 {
    static Point intersectWithOval(Point p2, Point p3) {
        double slope = findSlope(p2, p3);
        double b = p2.y - p2.x * slope;
        double aSq = slope * slope + 4.0;
        double bSq = 2 * slope * b;
        double cSq = b * b - 100;
        double xPos = ((-bSq) + Math.sqrt((bSq * bSq) - (4.0 * aSq * cSq)))
                / (2.0 * aSq);
        double xNeg = ((-bSq) - Math.sqrt((bSq * bSq) - (4.0 * aSq * cSq)))
                / (2.0 * aSq);
        double xProper = xPos;
        if (Math.abs(xPos - p2.x) < Math.abs(xNeg - p2.x)) {
            xProper = xNeg;
        }
        double yProper = slope * xProper + b;
        return new Point(xProper, yProper);
    }

    static double findSlope(Point p1, Point p2) {
        return (p2.y - p1.y) / (p2.x - p1.x);
    }

    public static void main(String args[]) {
        Point p1 = new Point(0.0, 10.1);
        Point p2 = new Point(1.4, -9.6);
        int counter = 0;
        final long t1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            while (!foundExit(p2)) {
                Point p3 = mirror(p1, p2);
                Point pResult = intersectWithOval(p2, p3);
                p1 = p2;
                p2 = pResult;
                counter++;
            }
        }
        final long t2 = System.currentTimeMillis();
        System.out.println("Original Version");
        System.out.println("Counter is at: " + counter);
        System.out.println(t2 - t1);
    }

    private static Point mirror(Point p1, Point p2) {
        double sTangent = tangentSlope(p2); // On oval
        double slopePerpendicularToTangent = perpendicularLineSlope(sTangent);
        Vector v = toVector(p1, p2);
        Vector reflectionLine = new Vector();
        double arbitraryLength = 10.0;
        reflectionLine.x = arbitraryLength;
        reflectionLine.y = reflectionLine.x * slopePerpendicularToTangent;
        // y=mx+b
        Vector l = reflectionLine;
        /*
		 * courtesy of
		 * http://en.wikipedia.org/wiki/Reflection_%28mathematics%29#
		 * Reflection_across_a_line_in_the_plane and
		 * http://en.wikipedia.org/wiki
		 * /Specular_reflection#Direction_of_reflection
		 */
        Vector reflection = l.multiply(v.dot(l) / l.dot(l)).multiply(2.0)
                .subtract(v);
        return new Point(reflection.x + p2.x, reflection.y + p2.y);
    }

    static boolean foundExit(Point pResult) {
        return pResult.y > 0 && Math.abs(pResult.x) <= 0.01;
    }

    static double tangentSlope(Point pointOnOval) {
        return -4.0 * pointOnOval.x / pointOnOval.y;
    }

    static double perpendicularLineSlope(double slope) {
        return -1.0 / slope;
    }

    static double dotProduct(Point p1, Point p2) {
        return p1.x * p2.x + p1.y * p2.y;
    }

    static Vector toVector(Point p1, Point p2) {
        return new Vector(p1, p2);
    }

    static class Point {
        double x;
        double y;

        Point() {
        }

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "[" + x + ", " + y + "]";
        }
    }

    static class Vector {
        double x;
        double y;

        Vector(Point p1, Point p2) {
            x = p2.x - p1.x;
            y = p2.y - p1.y;
        }

        public Vector() {
        }

        Vector add(Vector v) {
            Vector result = new Vector();
            result.x = x + v.x;
            result.y = y + v.y;
            return result;
        }

        Vector subtract(Vector v) {
            Vector result = new Vector();
            result.x = x - v.x;
            result.y = y - v.y;
            return result;
        }

        Vector multiply(double value) {
            Vector result = new Vector();
            result.x = x * value;
            result.y = y * value;
            return result;
        }

        double dot(Vector v) {
            return x * v.x + y * v.y;
        }
    }
}