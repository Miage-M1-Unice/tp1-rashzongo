package fr.unice.miage.progavancee.tp1.exercice1.a;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Chido
 */
public class ListFilesFilter1 implements FileFilter {
    
    private String exp;

    public ListFilesFilter1 (String exp) {
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
