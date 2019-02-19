package fr.unice.miage.progavancee.tp1.exercice1.b;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Chido
 */
public final class Main {
    
    public static void main(String[] args) throws IOException{
        String exp = "java";
        String root = ".";
        FileVisitor visitor = new MyFileVisitor(exp);
        Files.walkFileTree(Paths.get(root), visitor);
    }
} 
