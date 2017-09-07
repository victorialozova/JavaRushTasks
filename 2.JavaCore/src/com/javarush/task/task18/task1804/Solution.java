package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.

Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с минимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream file = new FileInputStream(name);
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        while (file.available() > 0) {
            int fb = file.read();
            if (map.containsKey(fb)) {
                int val = map.get(fb) + 1;
                map.put(fb, val);
            } else {
                map.put(fb, 1);
            }
        }
        file.close();
        for (int value : map.values()) {
            if (value < min){
                min = value;
            }
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
             if (pair.getValue() == min){
                 System.out.print(pair.getKey() + " ");
             }
        }
    }
}
