package com.javarush.task.task08.task0824;

/* 
Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.


Требования:
1. Программа должна выводить текст на экран.
2. Класс Human должен содержать четыре поля.
3. Класс Human должен содержать один метод.
4. Класс Solution должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human son1 = new Human("son_1", true, 1, new ArrayList<>());
        Human son2 = new Human("son_2", true, 2, new ArrayList<>());
        Human son3 = new Human("son_3", true, 3, new ArrayList<>());
        ArrayList<Human> ch = new ArrayList<>();
        ch.add(son1);
        ch.add(son2);
        ch.add(son3);

        Human mom = new Human("Mother", false, 30, ch);
        Human dad = new Human("Father", true, 31, ch);
        ArrayList<Human> parent = new ArrayList<>();
        ArrayList<Human> parent1 = new ArrayList<>();
        parent.add(mom);
        parent1.add(dad);

        Human grmom1 = new Human("GrandM1", false, 60, parent);
        Human grmom2 = new Human("GrandM2", false, 65, parent1);
        Human grdad1 = new Human("GrandD1", true, 70, parent);
        Human grdad2 = new Human("GrandD2", true, 80, parent1);
        ArrayList<Human> grand = new ArrayList<>();
        grand.add(grdad1);
        grand.add(grdad2);
        grand.add(grmom1);
        grand.add(grmom2);
        System.out.println("People");
        System.out.println(grdad1.toString());
        System.out.println(grdad2.toString());
        System.out.println(grmom1.toString());
        System.out.println(grmom2.toString());
        System.out.println(dad.toString());
        System.out.println(mom.toString());
        System.out.println(son1.toString());
        System.out.println(son2.toString());
        System.out.println(son3.toString());
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
