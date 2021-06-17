package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'g', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
//        detectAllWords(crossword, "home", "same", "fulmp", "konhj", "fderlk", "plgml");

        System.out.println("Положение по горизонтали слева направо");
        System.out.println((detectAllWords(crossword, "fderlk", "usameo", "lngrov", "mlgrrh", "poeejj")));
        System.out.println("Положение по горизонтали справа налево");
        System.out.println((detectAllWords(crossword, "klredf", "oemasu", "vorgnl", "hrr0lm", "jjeeop")));
        System.out.println("Положение по вертикали сверху вниз");
        System.out.println((detectAllWords(crossword, "fulmp", "dsnlo", "eagge", "rmrre", "leorj", "kovhj")));
        System.out.println("Положение по вертикали снизу вверх");
        System.out.println((detectAllWords(crossword, "pmluf", "olnsd", "eggae", "errmr", "jroel", "jhvok")));

        System.out.println("Положение по диагонали вектор - направо вверх");
        System.out.println((detectAllWords(crossword, "lse", "mnar", "plgml", "ogrek", "eroo", "erv")));
        System.out.println("Положение по диагонали вектор - направо вниз");
        System.out.println((detectAllWords(crossword, "rev", "emoh", "darrj", "fsgrj", "unge", "lle")));
        System.out.println("Положение по диагонали вектор - налево вверх");
        System.out.println((detectAllWords(crossword, "ver", "home", "jrrad", "jrgsf", "egnu", "ell")));
        System.out.println("Положение по диагонали вектор - налево вниз");
        System.out.println((detectAllWords(crossword, "esl", "ranm", "lmglp", "kergo", "oore", "vre")));

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> isDetectedWords = new ArrayList<>();
        List<String> thisWords = new ArrayList<>(Arrays.asList(words));
        String[] symbolsOfThisWord;
        String[][] tempCrossword = new String[crossword.length + 2][crossword[0].length + 2];

        Word textAndLocation = null;
        int l;
        for (String thisWord : thisWords) {
            symbolsOfThisWord = thisWord.split("\\B");
            //создаем копию входного массива
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[0].length; j++) {
                    tempCrossword[i + 1][j + 1] = String.valueOf((char) crossword[i][j]);
                }
            }
//            for (String[] strings : tempCrossword) {
//                System.out.println(Arrays.toString(strings));
//            }
label:            for (int j = 0; j < tempCrossword.length; j++) {
label1:                for (int k = 0; k < tempCrossword[0].length; k++) {
                    if (symbolsOfThisWord[0].equals(tempCrossword[j][k])) {
                        textAndLocation = new Word(thisWord);
                        l = symbolsOfThisWord.length - 1;
                        //символ справа и двойная проверка
                        if (symbolsOfThisWord[1].equals(tempCrossword[j][k + 1])
                                    && symbolsOfThisWord[2].equals(tempCrossword[j][k + 2])
                                    && symbolsOfThisWord[l].equals(tempCrossword[j][k + l])) {
                                textAndLocation.setStartPoint(k - 1, j - 1);
                                textAndLocation.setEndPoint(k + l - 1, j - 1);
                                break label;
                            }
                        //символ слева
                        else if (symbolsOfThisWord[1].equals(tempCrossword[j][k - 1])
                                && symbolsOfThisWord[2].equals(tempCrossword[j][k - 2])
                                && symbolsOfThisWord[l].equals(tempCrossword[j][k - l])) {
                                textAndLocation.setStartPoint(k - 1, j - 1);
                                textAndLocation.setEndPoint(k - l - 1, j - 1);
                                break label;
                            }
                        //символ сверху
                        else if (symbolsOfThisWord[1].equals(tempCrossword[j - 1][k])
                                    && symbolsOfThisWord[2].equals(tempCrossword[j - 2][k])
                                    && symbolsOfThisWord[l].equals(tempCrossword[j - l][k])) {
                                textAndLocation.setStartPoint(k - 1, j - 1);
                                textAndLocation.setEndPoint(k - 1, j - l - 1);
                                break label;
                            }
                        //символ снизу
                        else if (symbolsOfThisWord[1].equals(tempCrossword[j + 1][k])
                                    && symbolsOfThisWord[2].equals(tempCrossword[j + 2][k])
                                    && symbolsOfThisWord[l].equals(tempCrossword[j + l][k])) {
                                textAndLocation.setStartPoint(k - 1, j - 1);
                                textAndLocation.setEndPoint(k - 1, j + l - 1);
                                break label;
                            }
                        //cимвол слева сверху
                        else if (symbolsOfThisWord[1].equals(tempCrossword[j - 1][k - 1])
                                    && symbolsOfThisWord[2].equals(tempCrossword[j - 2][k - 2])
                                    && symbolsOfThisWord[l].equals(tempCrossword[j - l][k - l])) {
                                textAndLocation.setStartPoint(k - 1, j - 1);
                                textAndLocation.setEndPoint(k - l - 1, j - l - 1);
                                break label;
                            }
                        //символ слева снизу
                        else if (symbolsOfThisWord[1].equals(tempCrossword[j + 1][k - 1])
                                    && symbolsOfThisWord[2].equals(tempCrossword[j + 2][k - 2])
                                    && symbolsOfThisWord[l].equals(tempCrossword[j + l][k - l])) {
                                textAndLocation.setStartPoint(k - 1, j - 1);
                                textAndLocation.setEndPoint(k - l - 1, j + l - 1);
                                break label;
                            }
                        //символ справа сверху
                        else if (symbolsOfThisWord[1].equals(tempCrossword[j - 1][k + 1])
                                    && symbolsOfThisWord[2].equals(tempCrossword[j - 2][k + 2])
                                    && symbolsOfThisWord[l].equals(tempCrossword[j - l][k + l])) {
                                textAndLocation.setStartPoint(k - 1, j - 1);
                                textAndLocation.setEndPoint(k + l - 1, j - l - 1);
                                break label;
                        }
                        //символ справа снизу
                        else if (symbolsOfThisWord[1].equals(tempCrossword[j + 1][k + 1])
                                    && symbolsOfThisWord[2].equals(tempCrossword[j + 2][k + 2])
                                    && symbolsOfThisWord[l].equals(tempCrossword[j + l][k + l])) {
                                textAndLocation.setStartPoint(k - 1, j - 1);
                                textAndLocation.setEndPoint(k + l - 1, j + l - 1);
                                break label;
                        }
                    }
                }
            }
            isDetectedWords.add(textAndLocation);
        }
        return isDetectedWords;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
