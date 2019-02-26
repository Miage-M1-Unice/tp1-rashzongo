package fr.unice.miage.progavancee.tp3;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author Chido
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
        URL[] urls = {new URL("file://C:\\Users\\rsoul\\Desktop\\Cours\\master1\\ProgAvancee\\tp1-rashzongo\\tp3")};
        URLClassLoader ucl = new URLClassLoader(urls);
        ucl.loadClass("fr.unice.miage.progavancee.tp2.Main");
        System.out.println(ucl.);
    }
    
}
