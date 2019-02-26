package fr.unice.miage.progavancee.tp2;

import java.lang.reflect.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chido
 */

public class AnalyseurDeClasse {
    
    public static void analyseClasse(String nomClasse) {
        // Récupération d'un objet de type Class correspondant au nom passé en paramètres
        Class cl = getClasse(nomClasse);
        
        afficheEnTeteClasse(cl);
        
        System.out.println("//Attributs");
        afficheAttributs(cl);
        
        System.out.println("//Constructeurs");
        afficheConstructeurs(cl);
        
        System.out.println("//Méthodes");
        afficheMethodes(cl);
        
        // L'accolade fermante de fin de classe !
        System.out.println("}");
    }
    
    
    /**
     * Retourne la classe dont le nom est passé en paramètre
     * @param nomClasse
     * @return
     */
    public static Class getClasse(String nomClasse){
        try {
            return Class.forName(nomClasse);
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(AnalyseurDeClasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Cette méthode affiche par ex "public class Toto extends Tata implements Titi, Tutu {"
     * @param cl
     */
    public static void afficheEnTeteClasse(Class cl) {
        //  Affichage du modifier et du nom de la classe
        System.out.print(Modifier.toString(cl.getModifiers()));
        System.out.print(" class ");
        System.out.print(cl.getName());
        
        // Récupération de la superclasse si elle existe (null si cl est le type Object)
        Class supercl = cl.getSuperclass();
        
        // On ecrit le "extends " que si la superclasse est non nulle et
        if(supercl != null && supercl != Object.class) {
            System.out.print(" extends " + supercl.getName());
        }
        
        // Affichage des interfaces que la classe implemente
        Class interfaces[] = cl.getInterfaces();
        if(interfaces.length != 0) {
            System.out.print(" implements ");
            for( Class c : interfaces) {
                System.out.print(c.getName() + ", ");
            }
        }
        // Enfin, l'accolade ouvrante !
        System.out.println(" { \n");
    }
    
    public static void afficheAttributs(Class cl) {
        Field attrs[] = cl.getDeclaredFields();
        for(Field f : attrs) {
            System.out.print(Modifier.toString(f.getModifiers()) + " ");
            System.out.print(f.getType() + " ");
            System.out.println(f.getName());
        }
        System.out.println();
    }
    
    public static void afficheConstructeurs(Class cl) {
        Constructor constructeurs[] = cl.getConstructors();
        for(Constructor c : constructeurs) {
            System.out.print(Modifier.toString(c.getModifiers()) + " ");
            System.out.print(c.getName());
            System.out.print("(");
            Type params[] = c.getParameterTypes();
            for(Type p : params){
                System.out.print(p.getTypeName() + ", ");
            }
            System.out.println(")");
        }
        System.out.println();
    }
    
    public static void afficheMethodes(Class cl) {
        Method methods[] = cl.getDeclaredMethods();
        for(Method m : methods) {
            System.out.print(Modifier.toString(m.getModifiers()) + " ");
            System.out.print(m.getReturnType().getName() + " ");
            System.out.print(m.getName());
            System.out.print("(");
            Type params[] = m.getParameterTypes();
            for(Type p : params){
                System.out.print(p.getTypeName() + ", ");
            }
            System.out.println(")");
        }
        System.out.println();
    }
    
    public static String litChaineAuClavier() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
        /*boolean ok = false;
        
        while(!ok) {
            try {
                System.out.print("Entrez le nom d'une classe (ex : java.util.Date): ");
                String nomClasse = litChaineAuClavier();
                
                analyseClasse(nomClasse);
                
                ok = true;
            } catch(ClassNotFoundException e) {
                System.out.println("Classe non trouvée.");
            }catch(IOException e) {
                System.out.println("Erreur d'E/S!");
            }
        }*/
        analyseClasse("java.awt.Point");
    }
}