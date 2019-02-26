package fr.unice.miage.progavancee.tp2;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Chido
 */
public class GenericToString {
    
    public String toString(Object obj) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        return this.toString(obj, 1);
    }
    
    
    public String toString(Object obj, int prof) 
            throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        
        Class cl = obj.getClass();
        StringBuilder res = new StringBuilder();
        if (cl.isArray()) {
            //res.append("=").append(toString(obj, prof));
        }
        else {
            res.append(obj.getClass().getName()).append("[");
            res.append(this.attributeslisting(cl.getDeclaredFields(), cl, obj, prof));
            res.append(this.attributeslisting(cl.getSuperclass().getDeclaredFields(), cl.getSuperclass(), obj, prof));
            res.append("]");
        }
        return res.toString();
    }
    
    String attributeslisting(Field attrs[], Class cl, Object obj, int prof) 
            throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        
        StringBuilder res = new StringBuilder();
        for(Field f : attrs) {
                Field field = cl.getDeclaredField(f.getName());
                field.setAccessible(true);
                
                res.append(f.getName()).append("=");
                
                if( f.getType().isPrimitive() ) {
                    res.append(field.get(obj));
                }
                else if(f.getType().isArray()) {
                    int size = Array.getLength(field.get(obj));
                    res.append("{");
                    //System.out.println(field.get(obj).getClass().getComponentType());
                    for(int i = 0; i < size; i++){
                        if(field.get(obj).getClass().getComponentType().isPrimitive()) {
                            res.append(Array.get(field.get(obj), i));
                        }
                        else {
                            res.append(toString(Array.get(field.get(obj), i), (prof-1)));
                        }
                        res.append(", ");
                    }
                    res.append("}");
                }
                else if(prof > 1) {
                    res.append(toString(field.get(obj), (prof - 1)));
                }
                else {
                    res.append(field.get(obj).getClass().getName());
                }
                res.append("; ");
            }
        return res.toString();
    }
}
