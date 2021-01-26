package com.vin.practise.crackingcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Find if a String(a) is a permutation(not substring da) of another string (b)
 */
public class Problem2_StringPermutation {
    public static void main(String[] args) {
        //String a= "ab",b="eidbaooo";
        String a= "dcbae",b="abcd";
        System.out.println("Result->"+isStringBPermutationOfA(a, b));
        final char[] charsA = a.toCharArray();
        final char[] charsB = b.toCharArray();
        //Now find the ascii values of CHars a into charB
        for (int i=0;i<=b.length()-a.length();i++) {
            //if (b.substring(i,a.length()).equals(a)) {
            System.out.println("res:"+b.substring(i,i+a.length()));
            //}
        }
    }
    static boolean isStringBPermutationOfA(String a, String b) {
        //Book Solution number 1 (Book had these two conditions below) :
        //This approach is to code the negative solution
        //Idea here is for given string a and b we need to find if any character in a is not present in b and at the
        //same time any character in b is not present in a, then we don't need to move further.
        //step 1: length equal ::
        //step2: all the characters should match :: else return false.
        for (int i=0;i<a.length();i++) {
            if (!b.contains(Character.toString(a.charAt(i))) || !a.contains(Character.toString(b.charAt(i)))) {
                return false;
            }
        }
        return true;
        //Book Solution 2:
        //Create an int ascii array
        //loop via first and increase the count of char position
        //loop via second and decrease the count of char position
        //if the count of characters !=0 (in book it is <) then false. else true.

        //This is to find the occurence of a in any order inside b
        //To find the number of combination of a is the first problem
        //To find then any combination of a in b is the second problem
        //for each combination of a, use sliding window technique and search the string b --> starting point

        //step 1: find combinatin of a:
        /*List<String> aList = new ArrayList<>();
        for (int i=0;i<a.length();i++) {
            System.out.println("later");
        }
        //find the combination in b
        for (int i=0;i<b.length();i++) {
            if (b.substring(i,a.length()).equals(a)) {
                return true;
            }
        }
        return false;*/
    }
}
