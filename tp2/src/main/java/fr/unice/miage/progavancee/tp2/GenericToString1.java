package fr.unice.miage.progavancee.tp2;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 *
 * @author Chido
 */
public class GenericToString1 {
    
    public String toString(Object obj, int prof) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Class cl = obj.getClass();
        StringBuilder res = new StringBuilder();
        res.append(obj.getClass()).append("[");
        Field attrs[] = cl.getDeclaredFields();
        for(Field f : attrs) {
            Field field = cl.getDeclaredField(f.getName());
            field.setAccessible(true);
            System.out.println("*******" + f.getName() + " "+ field.get(obj).getClass().isPrimitive());
            //System.out.println("*******" + field.get(obj).getClass());
            if (!field.get(obj).getClass().isPrimitive() && prof > 1) {
                toString(field.get(obj), (prof - 1));
            }
            
            if (!field.get(obj).getClass().isArray()) {
                res.append(f.getName()).append("=").append(field.get(obj)).append("; ");
            }
            else {
                Object items[] = (Object[]) field.get(obj);
                System.out.println("*****" + items.toString());
                res.append(f.getName()).append("=").append(Arrays.toString(items)).append("; ");
            }
        }
        res.append("]");
        return res.toString();
    }
    
}
