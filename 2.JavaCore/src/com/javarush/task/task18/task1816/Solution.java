package com.javarush.task.task18.task1816;

/* 
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.

Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        int sum = 0;
        while (file.available() > 0){
            String str = String.valueOf((char) file.read());
            if (str.matches(".*[A-Za-z].*")){
                sum++;
            }
        }
        file.close();
        System.out.println(sum);
    }
}
