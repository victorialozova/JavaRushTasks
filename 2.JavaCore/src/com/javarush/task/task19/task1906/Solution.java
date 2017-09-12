package com.javarush.task.task19.task1906;

/* 
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным индексом.
Пример:
второй символ, четвертый символ, шестой символ и т.д.

Закрыть потоки ввода-вывод
Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все байты из первого файла с четным индексом (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileReader fr = new FileReader(file1);
        FileWriter fw = new FileWriter(file2);
        int i = 0;
        while (fr.ready()) {
            i++;
            int data = fr.read();
            if (i%2 == 0) {
                fw.write(data);
            }
        }
        reader.close();
        fr.close();
        fw.close();
    }
}
