package fr.unice.miage.progavancee.tp1.exercice1.a;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Chido
 */
public class ListFiles {
        
    protected void printFile(File file, String exp) {
        
        if(!file.isDirectory())
            System.out.println(file);
        /*else
            for(File f : file.listFiles(new ListFilesFilter1(exp)))
                printFile(f, exp);*/
        else {
            //ListFilesFilter1 filter =  new ListFilesFilter1(exp);
            //ListFilesFilter2 filter =  new ListFilesFilter2(exp);
            FileFilter filter = new FileFilter() {
                @Override
                public boolean accept (File file) {
                    return file.isFile() && file.getName().contains(exp) || file.isDirectory();
                }
            };
            for(File f : file.listFiles(filter))
                printFile(f, exp);
        }
        
        
    }
    
    class ListFilesFilter2 implements FileFilter {
        
        private String exp;

        public ListFilesFilter2 (String exp) {
            this.exp = exp;
        }

        @Override
        public boolean accept (File file) {
            return file.isFile() && file.getName().contains(exp) || file.isDirectory();
        }
    }
}
