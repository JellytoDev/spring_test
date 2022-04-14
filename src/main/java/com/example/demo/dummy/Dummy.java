package com.example.demo.dummy;

import lombok.Getter;
import lombok.Setter;

import javax.transaction.Transactional;

@Getter
@Setter
@Transactional
public class Dummy {

    private String table;

    // 테이블 정보 생성자로 가져오기
    public Dummy(String table) {
        this.table = table;
    }

    // 1. 테이블 존재 확인 함수
    public Boolean isTableExist() {
        return false;
    }

    // 2. dummy_create

    // 2.1 pk 있는지 확인

    // 2.2 pk 및 column 가져오기

    // 2.3 column 돌면서 for 문

    // 2.4 조건 체크 후 데이터 생성

    // 2.5 fk 속성이 있을시에 해당 테이블 참조한 후 해당 키값으로부터 데이터 생성 (onetomany, manytoone)

    // 2.6 데이터 삽입

    // 3. 더미데이터만 삭제
}
