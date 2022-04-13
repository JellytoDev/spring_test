package com.example.demo.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    public void jacksonTest() {
        User user = new User("hello", 30);

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            String memberJsonString = objectMapper.writeValueAsString(user);

            System.out.println("memberJsonString = " + memberJsonString);
            String json = "{\"name\":\"hello\",\"age\":30}";

            User user1 = objectMapper.readValue(json, User.class);
            System.out.println("user1 = " + user1.getName());

        }catch(IOException e){
            System.out.println("e = " + e);
        }
    }

    @Test
    public void reflectionTest() {
        try {
            Class targetClass = Class.forName("com.example.demo.domain.UserTest$TargetClass");
            //java.lang.Class의 forName()메소드를 통해 클래스를 찾음

            Method methods[] = targetClass.getDeclaredMethods();
            //getDeclaredMethods()를 통해 해당 클래스의 메소드들을 찾음

            for(int i=0;i<methods.length;i++) {
                System.out.println(methods[i].toString());
            }
        } catch (ClassNotFoundException e) {
            System.out.println("클래스를 찾을 수 없습니다.");
        }

        /*
         * 이름을 지정해 특정 메소드를 실행시키는 방법
         */

        try {
            TargetClass target = new TargetClass(); //해당 클래스의 인스턴스 생성
            Class targetClass = Class.forName("com.example.demo.domain.UserTest$TargetClass");
            Method methods[] = targetClass.getDeclaredMethods();

            for(int i=0;i<methods.length;i++) {
                String findMethod = methods[i].getName();
                if(findMethod.equals("secondMethod")) {
                    //secondMethod를 찾아서 실행
                    try {
                        methods[i].invoke(target,"리플렉션");
                        //invoke()를 통해 메소드 호출 가능
                        //첫번째 파라미터는 해당 메소드를 가진 인스턴스, 두번쨰 파라미터는 해당 메소드의 파라미터
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("클래스를 찾을 수 없습니다.");
        }
    }

    class Car{
        String name;
        String age;
    }

    public class TargetClass {
        /*
         * reflection 되어질 객체
         */

        public void firstMethod() {
            System.out.println("첫번째 매소드");
        }

        public void secondMethod(String name) {
            System.out.println("두번째 메소드");
        }

        public void thirdMethod(int n) {
            for(int i=0;i<n;i++) {
                System.out.println("세번째 메소드");
            }
        }
    }



}

