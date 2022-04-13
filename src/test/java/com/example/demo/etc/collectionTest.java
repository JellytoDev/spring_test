package com.example.demo.etc;

import com.example.demo.domain.User;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class collectionTest {

    @Test
    void collectionTest() {
        // Map 은 인터페이스이고 HashMap,TreeMap 등은 Map의 상속을 받는 구현 클래스이다.
        // HashMap은 자료를 관리하는 방식이 해시 방식이다(key 값 중복 불가, value 값 중복 가능, key/value null 값 허용)
        // Hashtable은 자료를 관리하는 방식이 해시 방식이다(key 값 중복 불가, value 값 중복 가능, key/value null 값 불가)
        // TreeMap은 자료를 관리하는 방식이 해시 방식이다(key 값에 대한 정렬이 이루어진다. key 값들에 대한 정렬 순서를 바꿀 수 있음)
        // LinkedHashMap은 Linked List 형태로 저장된 이는 순서대로 출력된다는 뜻.
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("one", 1);
        hashMap.put("two", null);

        Map<String,Object> hashtableMap= new HashMap<>();
        hashtableMap.put("one", 1);
        hashtableMap.put("two", 2);

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "member1");
        treeMap.put(2, "member2");

        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("two", 2);
        linkedHashMap.put("one", 1);

        for (String s : linkedHashMap.keySet()) {
            System.out.println("s = " + s);
        }

        User user = new User();
        user.setName("hello");

    }

}
