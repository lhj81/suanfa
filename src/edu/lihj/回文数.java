package edu.lihj;


/**
 * @Description 回文数
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @Author: lihj <lhjbpqbfq@163.com>
 * @Date: 2020-05-12 21:34
 */
public class 回文数 {
    public boolean isPalindrome(int x) {
        String str1 = "";
        String str2 = "";
        String nmuber = String.valueOf(x);
        int medIndex = 0;
        int length = nmuber.length();
        if (length % 2 == 0) {
            medIndex = length / 2;
            str1 = nmuber.substring(0, medIndex);
            str2 = nmuber.substring(medIndex, length);
            return comparisonFigures(str1, str2);
        } else {
            medIndex = length / 2;
            str1 = nmuber.substring(0, medIndex);
            str2 = nmuber.substring(medIndex + 1, length);
            return comparisonFigures(str1, str2);
        }
    }

    public boolean comparisonFigures(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(str2.length() - 1-i)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        回文数 a = new 回文数();
        System.out.println(a.isPalindrome(123321));

    }


}
