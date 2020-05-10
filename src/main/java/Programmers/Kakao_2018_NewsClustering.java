package Programmers;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Kakao_2018_NewsClustering {

    public static void main(String[] args) {

    }

    public int solution(String str1, String str2) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        String tempStr = "";
        for (int i = 0; i < str1.length() - 1; i++) {
            tempStr = str1.substring(i, i + 2).toUpperCase();
            if (tempStr.matches("^[A-Z]+$")) {
                list1.add(tempStr);
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            tempStr = str2.substring(i, i + 2).toUpperCase();
            if (tempStr.matches("^[A-Z]+$")) {
                list2.add(tempStr);
            }
        }

        ArrayList<String> union = unionList(list1, list2);
        ArrayList<String> intersection = intersection(list1, list2);
        if (intersection.size() == 0) {
            return 65536;
        } else {
            return (int) ((double) intersection.size() / (double) union.size() * (double) 65536);
        }
    }

    static ArrayList<String> unionList(ArrayList<String> list1, ArrayList<String> list2) {
        list1 = (ArrayList<String>) list1.clone();
        list2 = (ArrayList<String>) list2.clone();

        ArrayList<String> unionList = new ArrayList<>();
        for(String str : list1) {
            if(list2.contains(str)) {
                list2.remove(str);
            }
            unionList.add(str);
        }
        unionList.addAll(list2);
        return unionList;
    }

    static ArrayList<String> intersection(ArrayList<String> list1, ArrayList<String> list2) {
        list1 = (ArrayList<String>) list1.clone();
        list2 = (ArrayList<String>) list2.clone();
        ArrayList<String> interList = new ArrayList<>();
        for(String str : list1) {
            if(list2.contains(str)) {
                interList.add(str);
                list2.remove(str);
            }
        }
        return interList;
    }
}
