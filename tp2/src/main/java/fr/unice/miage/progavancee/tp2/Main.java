package fr.unice.miage.progavancee.tp2;

import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author Chido
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
      public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        
        int a = 5;
        Class cl = int.class;
        System.out.println(cl);
        
        //System.out.println(new GenericToString().toString(2, 1));
          
        System.out.println(new GenericToString().toString(new Point(12,24), 1));
        
        Polygon pol = new Polygon(new int[]{10, 20, 30}, new int[]{20,30, 40}, 3);
        pol.getBounds();
        
        Polygon ps[] = {pol, pol, pol};
        System.out.println(new GenericToString().toString(pol, 3));
        
        System.out.println(new GenericToString().toString(ps, 5));
    }
    
}
