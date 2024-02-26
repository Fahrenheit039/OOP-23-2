import os.*;
import os.windows.windowsFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        System.out.println("cross-platform simulator");

        Factory factory = os.pick();
//        Factory factory = new windowsFactory();

        ArrayList<Object> controls = new ArrayList<>();
//        Object tmp1 = factory.getClass().getDeclaredMethods();
        for (Method method : factory.getClass().getDeclaredMethods()) {
//            if (method.getReturnType().getName().indexOf("controls") > -1)
//            {
//                System.out.println(method);
//                double tmp = Math.random();
//                System.out.println("before = "+ tmp+ " \\ after = " + Math.round(tmp));
//                if (tmp > 0.33) {
                    Object temp = method.invoke(factory); //.getClass().getMethods();
                    controls.add(temp);
                    for (Method tmpMethod : temp.getClass().getDeclaredMethods()){
//                        tmpMethod.setAccessible(true);
                        tmpMethod.invoke(temp);
//                        System.out.println(tmpMethod);
                    }
                    int b=1;
//                }
//                controls.add((Control) method.invoke(factory));
//            }
        }

        int a=1;
        

    }

}