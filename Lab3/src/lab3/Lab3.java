/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;
import static java.lang.Math.sqrt;
import java.util.Scanner;
import static lab3.Point3d.srav;
/**
 *
 * @author spiva_000
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Scanner in = new Scanner(System.in);
    Point3d one = new Point3d();
    Point3d two = new Point3d(1,2,3);
    Point3d three = new Point3d();
    System.out.println("Input X");
    three.setX(in.nextDouble());
    System.out.println("Input Y");
    three.setY(in.nextDouble());
    System.out.println("Input Z");
    three.setZ(in.nextDouble());
    if (srav(one,two) || srav(two,three) || srav(one,three))
            System.out.println("Error");
        else
            computeArea(one,two,three);
    }
    
    public static double computeArea(Point3d a, Point3d b, Point3d c) 
    {
        double x = Point3d.distanceTo(a, b);
        double y = Point3d.distanceTo(b, c);
        double z = Point3d.distanceTo(a, c);
        double f = (x+y+z)/2;
        f = sqrt(f*(f-x)*(f-y)*(f-z));
        System.out.println("Square = " + f);
        return f;
    }
}
