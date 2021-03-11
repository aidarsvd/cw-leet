package pro.aidar;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println(duplicateCount("inivisibility"));
    }

    public static int duplicateCount(String text) {
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        ArrayList<Character> list = new ArrayList<>();
        for (int j = 0; j < text.length(); j ++){
            list.add(Character.toLowerCase(text.charAt(j)));
        }
        for (char word : list) {
            Integer current = counts.get(word);
            if (current == null) {
                current = 0;
            }
            current++;
            counts.put(word, current);
        }
        int res = 0;
        for(Map.Entry<Character, Integer> entry : counts.entrySet()) {
            Integer value = entry.getValue();
            if (value > 1){
                res++;
            }
        }
        return res;
    }

    public static int digital_root(int n) {
        String a = String.valueOf(n);
        int[] list = new int[a.length()];
        for (int i =0; i < list.length; i ++){
            list[i] = a.charAt(i) - '0';
        }
        int result=0;
        while (list.length > 1){
            for(int value : list) {
                result += value;
            }
            String temp = Integer.toString(result);
            if (result >= 10){
                result = 0;
            }else{
                break;
            }
            list = new int[temp.length()];
            for (int i =0; i < list.length; i ++){
                list[i] = temp.charAt(i) - '0';
            }
        }
        return result;
    }

    public static String longToIP(long ip) {
        return String.format("%d.%d.%d.%d", ip>>>24, (ip>>16)&0xff, (ip>>8)&0xff, ip&0xff);
    }

    public static boolean scramble(String str1, String str2) {
        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        Map<Character, Integer> counts2 = new HashMap<Character, Integer>();
        for (int j = 0; j < str1.length(); j ++){
            list.add(str1.charAt(j));
        }
        for (int j = 0; j < str2.length(); j ++){
            list2.add(str2.charAt(j));
        }
        int res = 0;
        for (char word : list) {
            Integer current = counts.get(word);
            if (current == null) {
                current = 0;
            }
            current++;
            counts.put(word, current);
        }
        for (char word : list2) {
            Integer current = counts2.get(word);
            if (current == null) {
                current = 0;
            }
            current++;
            counts2.put(word, current);
        }
        for (int j=0; j < str2.length();j++){
            Integer temp = counts2.get(list2.get(j));
            Integer temp2 = counts.get(list2.get(j));
            if (temp2 != null && temp != null){
                if (temp2 >= temp){
                    res++;
                }
            }
        }
        return res == str2.length();
    }


    public static String longest (String s1, String s2) {
        String s3 = s1 + s2;
        ArrayList<Character> list1 = new ArrayList<>();
        for (int i = 0; i < s3.length(); i++){
            if (i > 0){
                if (!list1.contains(s3.charAt(i))){
                    list1.add(s3.charAt(i));
                }
            }else{
                list1.add(s3.charAt(i));
            }
        }
        Collections.sort(list1);
        return list1.stream().map(String::valueOf).collect(Collectors.joining(""));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static String getMiddle(String word) {
        char[] ch = word.toCharArray();
        String letter;
        if (ch.length % 2 != 0){
            letter = String.valueOf(ch[ch.length/2]);
        }else{
            char f;
            char s;
            f = ch[ch.length/2 - 1];
            s = ch[ch.length/2];
            letter = f + String.valueOf(s);
        }
        return letter;
    }

    public static char findMissingLetter(char[] array)
    {
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] list = abc.toCharArray();
        char[] rangeArray = new char[array.length];
        for(int i = 0; i < list.length; i++){
            if (Character.toUpperCase(array[0]) == Character.toUpperCase(list[i])){
                for (int j = 0; j < array.length; j ++ ){
                    rangeArray[j] = list[i];
                    i ++;
                }
            }
        }
        for (int i = 0; i < rangeArray.length; i ++){
            if (Character.toUpperCase(array[i]) != Character.toUpperCase(rangeArray[i])){
                return Character.isLowerCase(array[0]) ?
                        Character.toLowerCase(rangeArray[i]) : Character.toUpperCase(rangeArray[i]);
            }
        }
        return ' ';
    }

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        String result = binary.stream().map(String::valueOf).collect(Collectors.joining(""));
        return Integer.parseInt(result, 2);
    }

    public static int persistence(long n) {
        int itteration = 0;
        String a = Long.toString(n);
        int[] list = new int[a.length()];
        for (int i =0; i < list.length; i ++){
            list[i] = a.charAt(i) - '0';
        }
        int result=1;
        while (list.length > 1){
            itteration += 1;
            for(int value : list) {
                result *= value;
            }
            String temp = Integer.toString(result);
            result = 1;
            list = new int[temp.length()];
            for (int i =0; i < list.length; i ++){
                list[i] = temp.charAt(i) - '0';
            }
        }
        return itteration;
    }



}
