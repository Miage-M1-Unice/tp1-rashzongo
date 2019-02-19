package fr.unice.miage.progavancee.tp1.exercice1.a;

import java.io.File;

/**
 *
 * @author Chido
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String rep = ".";
        String exp = "java";
        ListFiles exo1 = new ListFiles();
        exo1.printFile(new File(rep), exp);
    }
    
}
