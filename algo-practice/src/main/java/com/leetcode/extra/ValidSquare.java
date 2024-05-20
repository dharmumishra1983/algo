package com.leetcode.extra;

/**
 * AN: 593
 * Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.
 * <p>
 * The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.
 * <p>
 * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: true
 * Example 2:
 * <p>
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
 * Output: false
 */
public class ValidSquare {
    private boolean isRightAngled(int[] p1, int[] p2, int[] p3) {
        //length of height
        int distA = dist(p1, p2);
        //length of base
        int distB = dist(p1, p3);
        if (distA == 0 || distB == 0 || distA != distB) {
            // triangle is not isoceles
            return false;
        }
        // length of hypotenuse
        int distC = dist(p2, p3);
        // remember a^2 + b^2 = c^2 in a right angled triangle
        return distC == distA + distB;
    }

    private int dist(int[] p1, int[] p2) {
        // dist = x^2 + y^2
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    private boolean isSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // a square when split diagonally is two isoceles right angled triangles
        return isRightAngled(p1, p2, p3) && isRightAngled(p4, p3, p2);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return isSquare(p1, p2, p3, p4) || isSquare(p1, p2, p4, p3) || isSquare(p1, p3, p4, p2);

    }

    public static void main(String[] args) {
        ValidSquare vs=new ValidSquare();
        System.out.println(vs.validSquare(new int[]{0,0},new int[]{1,1},new int[]{1,0},new int[]{0,12}));
    }

}
