package fr.unice.miage.progavancee.tp1;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Chido
 */
public class Exercice1 {
    FileFilter filter = new FileFilter() {
        private String exp;

        @Override
        public boolean accept (File file) {
            return file.isFile() && file.getName().contains(exp) || file.isDirectory();
        }
    };
    
    protected void printFile(File file, String exp) {
        
        if(!file.isDirectory())
            System.out.println(file);
        /*else
            for(File f : file.listFiles(new Exercice1Filter1(exp)))
                printFile(f, exp);*/
        
        for(File f : file.listFiles(filter))
                printFile(f, exp);
        
    }
    
    class Exercice1Filter2 implements FileFilter {
        
        private String exp;

        public Exercice1Filter2 (String exp) {
            this.exp = exp;
        }

        @Override
        public boolean accept (File file) {
            return file.isFile() && file.getName().contains(exp) || file.isDirectory();
        }
    }
}
