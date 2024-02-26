import os.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        System.out.println("cross-platform simulator");

        Factory factory = os.pick();

        ArrayList<Object> controls = new ArrayList<>();
        for (Method method : factory.getClass().getDeclaredMethods()) {
            if (Math.random() > 0.33) {
                Object temp = method.invoke(factory); //.getClass().getMethods();
                controls.add(temp);
                for (Method tmpMethod : temp.getClass().getDeclaredMethods())
                    tmpMethod.invoke(temp);
//                controls.add((Control) method.invoke(factory));
            }
        }
        

    }

}