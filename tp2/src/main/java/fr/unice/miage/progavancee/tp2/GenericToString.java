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
    
    
    public String toString(Object obj, int prof) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Class cl = obj.getClass();
        StringBuilder res = new StringBuilder();
        //if (cl.isPrimitive()) {
            //res.append("=").append(obj);
        //}
        //else {
            res.append(obj.getClass().getName()).append("[");
            res.append(this.attributeslisting(cl.getDeclaredFields(), cl, obj, prof));
            res.append(this.attributeslisting(cl.getSuperclass().getDeclaredFields(), cl.getSuperclass(), obj, prof));
            res.append("]");
        //}
        return res.toString();
    }
    
    //listing attr class ensuite super classe
    
    /**
     *
     * @param classe
     * @return
     */
    public List<Field> getAllFields(Class classe) {
        ArrayList<Field> res  = new ArrayList();
        res.addAll(Arrays.asList(classe.getDeclaredFields()));
        if(classe.getSuperclass() != Object.class && classe.getSuperclass() != null) {
            res.addAll(Arrays.asList(classe.getSuperclass().getDeclaredFields()));
        }
        return res;
    }
    
    String attributeslisting(Field attrs[], Class cl, Object obj, int prof) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
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
                    for(int i = 0; i < size; i++){
                        //res.append(toString(Array.get(field.get(obj), i)));
                        res.append(Array.get(field.get(obj), i)).append(", ");
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
