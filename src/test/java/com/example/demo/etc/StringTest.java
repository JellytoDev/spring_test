package com.example.demo.etc;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    public void stringMethod() {
        String a = "the snow glows white on the mountain to night test";
        String b = a;
        String c = "test";
        String d = "Hello, this is wonderful world";
        String e = "test";
        String f = new String("tefdnosafnodsanfo");
        String g = "heytest";


        // 문자열 비교 함수
        System.out.println(a.equals(b)); // true
        System.out.println(a==b); // true

        System.out.println(c.equals(e)); // true
        System.out.println(c==e); // true

        // 문자열 포함 여부 함수
        System.out.println(a.contains(c)); // true
        System.out.println(g.contains(c)); // true
        System.out.println(e.contains(c)); // true

        System.out.println(a.indexOf(c)); // 46
        System.out.println(a.matches(",*[0-9]].*")); //false

        // 문자열 길이 함수
        System.out.println(a.length()); // 50

        // 문자열 잘라내기 함수
        System.out.println(a.substring(3, 7)); //sno

        // 문자열 교환 함수
        System.out.println(f.replace("f",".")); //te.dnosa.nodsan.o

        // 지정한 문자를 기준으로 문자열 나누기
        for (String s : a.split(" ")) {
            System.out.println("s = " + s);
            // the
            // snow ......
        }

    }
}
