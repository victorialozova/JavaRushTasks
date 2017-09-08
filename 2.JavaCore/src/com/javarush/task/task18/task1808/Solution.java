package com.javarush.task.task18.task1808;

/* 
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.

Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        String name3 = reader.readLine();

        FileInputStream file1 = new FileInputStream(name1);
        FileOutputStream file2 = new FileOutputStream(name2);
        FileOutputStream file3 = new FileOutputStream(name3);

        while (file1.available() > 0) {
            if (file1.available() % 2 == 0) {
                byte[] buff1 = new byte[file1.available() / 2];
                byte[] buff2 = new byte[file1.available() / 2];
                int count1 = file1.read(buff1);
                int count2 = file1.read(buff2);
                file2.write(buff1, 0, count1);
                file3.write(buff2, 0, count2);
            } else {
                byte[] buff1 = new byte[(int) Math.round(((double) file1.available())/2)];
                byte[] buff2 = new byte[file1.available()/2];
                int coun1 = file1.read(buff1);
                int coun2 = file1.read(buff2);
                file2.write(buff1, 0, coun1);
                file3.write(buff2, 0, coun2);
            }
        }
        reader.close();
        file1.close();
        file2.close();
        file3.close();
    }
}
