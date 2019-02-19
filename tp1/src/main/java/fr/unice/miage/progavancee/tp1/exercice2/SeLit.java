package fr.unice.miage.progavancee.tp1.exercice2;

import java.io.File;  
import java.io.FileNotFoundException;   
import java.util.Scanner;

/**
 *
 * @author Chido
 */
public class SeLit {  
   void lecture(Scanner source) {  
  
       while(source.hasNextLine()) {  
           String s = source.nextLine();          
           System.out.println("LU : " + s);  
           // A modifier  
       }  
   }  
  
   static public void main(String[] args) {   
      // A compléter       
   }  
}
