package fr.unice.miage.progavancee.tp1.exercice1.b;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author Chido
 */
public class MyFileVisitor extends SimpleFileVisitor<Path> {
    private String exp;
    
    MyFileVisitor (String exp) {
        this.exp = exp;
    }
    
    @Override
    public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) {
        if(file.getFileName().toString().contains(exp)) {
            System.out.println(file);
        }
        return FileVisitResult.CONTINUE;
    }
    
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        //System.out.println("Processing directory:" + dir);
        return FileVisitResult.CONTINUE;
    }
}
