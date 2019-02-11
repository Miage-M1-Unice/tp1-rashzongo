package fr.unice.miage.progavancee.tp1;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Chido
 */
public class Exercice1Filter1 implements FileFilter {
    
    private String exp;

    public Exercice1Filter1 (String exp) {
        this.exp = exp;
    }

    @Override
    public boolean accept (File file) {
        if(file.isFile() && file.getName().contains(exp) || file.isDirectory()){
            return true;
        }
        return false;
    }

   
    
}
