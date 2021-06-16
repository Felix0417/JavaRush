package com.javarush.task.task21.task2102;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
*/

public class Solution {
    public static void main(String[] args) {
        int classModifiers = Solution.class.getModifiers();
        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();
        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
        // Эх...велосипеды с квадратными колесами)
        boolean result = false;
        if (Modifier.isAbstract(specificModifier)){
            result = Modifier.isAbstract(allModifiers);
        }else if (Modifier.isFinal(specificModifier)){
            result = Modifier.isFinal(allModifiers);
        }else if (Modifier.isInterface(specificModifier)){
            result = Modifier.isInterface(allModifiers);
        }else if (Modifier.isNative(specificModifier)){
            result = Modifier.isNative(allModifiers);
        }else if (Modifier.isPrivate(specificModifier)){
            result = Modifier.isPrivate(allModifiers);
        }else if (Modifier.isProtected(specificModifier)){
            result = Modifier.isProtected(allModifiers);
        }else if (Modifier.isPublic(specificModifier)){
            result = Modifier.isPublic(allModifiers);
        }else if (Modifier.isStatic(specificModifier)){
            result = Modifier.isStatic(allModifiers);
        }else if (Modifier.isStrict(specificModifier)){
            result = Modifier.isStrict(allModifiers);
        }else if (Modifier.isSynchronized(specificModifier)){
            result = Modifier.isSynchronized(allModifiers);
        }else if (Modifier.isTransient(specificModifier)){
            result = Modifier.isTransient(allModifiers);
        }else if (Modifier.isVolatile(specificModifier)){
            result = Modifier.isVolatile(allModifiers);
        }

        return result;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
