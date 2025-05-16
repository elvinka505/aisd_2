/*
Задача 1
Напишите функцию, которая принимает на вход текст и вовращает
количество вхождений каждого слова (с учетом окончаний.
Т.е. "яблоко" и "яблока" -- это два разных слова ). Сложность -- O(n)
 */
package aisd.lab03.hometask.task1;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        if (text == null || text.isEmpty()) {
            return wordCountMap;
        }

        //1) разделим текст на слова
        String[] words = text.split("[\\s\\p{Punct}]+");

        //2) пустые строчки (из-за разделителей) - в игнор!!
        for (String word : words) {
            if (!word.isEmpty()) {
                word = word.toLowerCase(); // без уч рег
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordCountMap;
    }
        public static void main(String[] args) {
            String text = "Яблоко, яблока, помидор, помидоры";
            Map<String, Integer> result = countWords(text);

            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
