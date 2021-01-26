package com.vin.practise.crackingcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a String s="Mr John Smith   " 13
 * replace the spaces with %20. Assume String has enough space to accomodate the characters.
 *
 */
public class Problem3_URLify {
    public static void main (String[] args) {
        String s ="Mr John Smith    ";//"Mr%20John%20Smith"
        System.out.println("Result -->"+urlify(s,13));
        /*char[] charArray = s.trim().toCharArray();
        List<String> strList = new ArrayList<>();
        for (int i=0;i<charArray.length;i++) {
            if (charArray[i]==' ') strList.add("%20");
            else strList.add(Character.toString(charArray[i]));
        }
        StringBuilder stringBuilder = new StringBuilder();
        strList.forEach(stringBuilder::append);
        System.out.println("Result--> "+stringBuilder.toString());*/
    }

    /**
     * Step 1 : convert string to character array
     * Step 2 : count number of spaces
     * Step 3 : determine the max index of new string
     * Step 4 : start the loop at the end of the true length
     * Step 5 : keep putting all the characters starting at the end (max index) until you encounter space
     * Step 6 : In case we see space, then put 0,2,% at the max index variable and keep reducing
     * Step 7 : wait till end of the loop
     * @param s
     * @param trueLength
     * @return
     */
    static String urlify(String s, int trueLength) {
        char[] chars = s.toCharArray();
        System.out.println("Array length-->"+chars.length);
        int spaceCount = countOfSpaces(chars, trueLength);
        System.out.println("SpaceCount-->"+spaceCount);
        int newIndex = trueLength-1+spaceCount*2;
        System.out.println("New Index-->"+newIndex);
        if(newIndex+1<chars.length) chars[newIndex+1]='\0';//later put '\0'
        System.out.println("Original String-->"+Arrays.toString(chars));
        for (int i=trueLength-1;i>=0;i--) {
            if (chars[i]==' ') {
                System.out.println("Right now new index is --> "+newIndex);
                chars[newIndex--]='0';
                chars[newIndex--]='2';
                chars[newIndex--]='%';
            }
            else {
                chars[newIndex] = chars[i];
                newIndex--;
            }
        }
        System.out.println("-->"+Arrays.toString(chars));
        return Arrays.toString(chars);
        /*char[] chars = s.toCharArray();
        char[] url = new char[chars.length];int i=0,j=0;
        *//*for (int i=0;i<chars.length;i++)*//* while (i<chars.length && j <url.length) {
            if (chars[i]==' ') {
                url[i]='%';url[i+1]='2';url[i+2]='0';
                j=i+2;
            }
            else {
                url[j]=chars[i];j++;
            }
            i++;
        }
        System.out.println("-->"+Arrays.toString(url));
        return Arrays.toString(url);*/
    }
    static int countOfSpaces(char[] chars, int trueLength ) {
        int spaceCount =0;
        for (int i=0;i<trueLength;i++) {
            if (chars[i]==' ') {
                spaceCount++;
            }
        }
        return spaceCount;
    }
}
