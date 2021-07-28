package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());

        reader = new BufferedReader(fileReader);
        String[] words;

        StringBuilder word2 = new StringBuilder("");
        StringBuilder allLines = new StringBuilder("");

        while (reader.ready()) {
            allLines.append(" ").append(reader.readLine());
        }

        words = allLines.toString().trim().split(" ");

        for (int i = 0; i < words.length - 1; i++) {
            Pair pair;
            if (words[i] != null){
                pair = new Pair();
                pair.first = words[i];
            } else continue;

            for (int j = i + 1; j < words.length; j++) {
                word2.delete(0, word2.capacity());
                if (words[j] != null){
                    word2.append(words[j]);
                    pair.second = word2.reverse().toString();
                    if (pair.first.equals(pair.second)){
                        pair.second = word2.reverse().toString();
                        result.add(pair);
                        words[i] = null;
                        words[j] = null;
                        break;
                    }
                }
            }
        }

    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
