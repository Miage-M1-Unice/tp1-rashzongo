package fr.unice.miage.progavancee.tp1;

import java.io.File;

/**
 *
 * @author Chido
 */
public class Main1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String rep = ".";
        String exp = "java";
        Exercice1 exo1 = new Exercice1();
        exo1.printFile(new File(rep), exp);
    }
    
}
