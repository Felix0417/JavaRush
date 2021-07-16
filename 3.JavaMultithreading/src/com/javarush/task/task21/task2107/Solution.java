package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/

public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = (Solution) solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap<>();

    @Override
    public int hashCode() {
        int result = 1;
        for (String name : users.keySet()){
            result = 31 * name.hashCode() + users.get(name).hashCode();
        }
//        System.out.println("Solution " + result);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Solution solution = (Solution) super.clone();
        Map<String, User> userClone = new LinkedHashMap<>();
        for (String name : users.keySet()){
            User user = users.get(name);
            userClone.put(name, (User) user.clone());
        }
        solution.users = userClone;
        return solution;
    }


    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int hashCode() {
//            System.out.println("Users " + 31 * this.name.hashCode() + age);
            return 31 * this.name.hashCode() + age;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (this.getClass() != obj.getClass() || obj == null) return false;

            User that = (User) obj;
            if (!(name == that.name)) return false;
            return age == that.age;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            User clone = (User) super.clone();
            clone.name = name;
            clone.age = age;
            return new User(clone.age, clone.name);
        }
    }
}
