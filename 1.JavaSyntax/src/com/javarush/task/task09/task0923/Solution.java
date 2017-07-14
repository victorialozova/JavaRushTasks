package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
1. первая строка содержит только гласные буквы из введённой строки.
2. вторая — только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.
Пример ввода:
Мама мыла раму.

Пример вывода:
а а ы а а у
М м м л р м .


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить две строки.
3. Первая строка должна содержать только гласные буквы из введенной строки, разделенные пробелом.
4. Вторая строка должна содержать только согласные и знаки препинания из введенной строки, разделенные пробелом.
5. Каждая строка должна заканчиваться пробелом.
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine(); //читаем строку с консоли
        char [] charArray = s.toCharArray(); //создаем массив, куда поместим строку с консоли, и которую переводим в char

        ArrayList <Character> listCharVowels = new ArrayList <Character>(); //список для гласных
        ArrayList <Character> listCharNonVowels = new ArrayList <Character>(); //список для согласных

        for (int i=0; i < charArray.length; i++) //бежим по массиву
        {
            if (isVowel(charArray[i])) //проверяем условие методом isVowel если текуший символ гласная
            {
                listCharVowels.add(charArray[i]); //помещаем гласную в свой список
            }
            else if (charArray [i] == ' ')// проверяем есть ли пробел, и пропускаем его
            {
                continue;
            }
            else
            {
                listCharNonVowels.add(charArray[i]); //остальные буквы или другие символы(точка например), помещаем в свой список
            }
        }

        for (char c : listCharVowels)//бежим по списку, в который положили гласные
        {
            System.out.print(c + " "); //выводи гланые на экран, не забываем пробел между ними
        }

        System.out.println(); // переводим курсов на другую строчку

        for (char c : listCharNonVowels) //бежим по списку согласных
        {
            System.out.print(c + " "); //выводим на экран все остальные символы, через пробел
        }


    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}