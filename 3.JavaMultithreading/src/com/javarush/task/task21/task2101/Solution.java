package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/

public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] addressResult = new byte[4];
        for (int i = 0; i < 4; i++) {
            addressResult[i] = (byte) (ip[i] & mask[i]);
        }
        return addressResult;
    }

    public static void print(byte[] bytes) {
//        System.out.println(Integer.toBinaryString(String.valueOf(bytes)));
        for (byte x : bytes){
            System.out.print(convertationByte(x));
            System.out.print(" ");
        }
        System.out.println("");
    }
    public static String convertationByte(byte b){
        String[] strings = Integer.toBinaryString(b).split("\\B");
        String resultOfConvertation;
        StringBuilder tempConvert = new StringBuilder("");
        if (strings.length > 8){
            for (int i = strings.length - 8; i < strings.length; i++) {
                tempConvert.append(strings[i]);
            }
        }else{
            for (int i = strings.length; i < 8; i++) {
                tempConvert.append("0");
            }
            tempConvert.append(Integer.toBinaryString(b));
        }

        resultOfConvertation = tempConvert.toString();

        return resultOfConvertation;
    }
}
