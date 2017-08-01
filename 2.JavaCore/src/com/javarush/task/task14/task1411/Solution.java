package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Looser, Coder and Proger
user«, «loser«, «coder«, «proger«

1. Ввести [в цикле] с клавиатуры несколько строк (ключей).
Строки(ключи) могут быть такими: «user«, «loser«, «coder«, «proger«.
Ввод окончен, когда строка не совпадает ни с одной из выше указанных.

2. Для каждой введенной строки нужно:
2.1. Создать соответствующий объект [см. Person.java], например, для строки «user» нужно создать объект класса User.
2.2. Передать этот объект в метод doWork.

3. Написать реализацию метода doWork, который:
3.1. Вызывает метод live() у переданного обекта, если этот объект (person) имеет тип User.
3.2. Вызывает метод doNothing(), если person имеет тип Loser.
3.3. Вызывает метод coding(), если person имеет тип Coder.
3.4. Вызывает метод enjoy(), если person имеет тип Proger.

Требования:
1. Метод main должен считывать строки с клавиатуры.
2. Метод main должен прекращать считывать строки с клавиатуры, как только введенная строка не совпадает с одной из ожидаемых(user, loser, coder, proger).
3. Для каждой корректной(user, loser, coder, proger) введенной строки должен быть вызван метод doWork с соответствующим объектом класса Person в качестве параметра.
4. В классе Solution должен быть реализован метод doWork с одним параметром типа Person.
5. Метод doWork должен вызывать метод live() у переданного объекта, если этот объект имеет тип User.
6. Метод doWork должен вызывать метод doNothing() у переданного объекта, если этот объект имеет тип Loser.
7. Метод doWork должен вызывать метод coding() у переданного объекта, если этот объект имеет тип Coder.
8. Метод doWork должен вызывать метод enj
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        //тут цикл по чтению ключей, пункт 1
        while (true) {
            key = reader.readLine();
            if (("user".equals(key)) || ("loser".equals(key)) || ("coder".equals(key)) || ("proger".equals(key))) {

                //создаем объект, пункт 2
                if ("user".equals(key)) {
                    person = new Person.User();
                } else if ("loser".equals(key)) {
                    person = new Person.Loser();

                } else if ("coder".equals(key)) {
                    person = new Person.Coder();
                } else if ("proger".equals(key)) {
                    person = new Person.Proger();
                }
                doWork(person); //вызываем doWork
            } else {
                break;
            }
        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if(person instanceof Person.User){
            ((Person.User) person).live();
        } else if (person instanceof Person.Loser) {
            ((Person.Loser)person).doNothing();
        } else if (person instanceof Person.Coder) {
            ((Person.Coder)person).coding();
        } else if (person instanceof Person.Proger) {
            ((Person.Proger)person).enjoy();
        }
    }
}
