package com.example.demo1.common.type;

public enum PostSuccessType implements SuccessType {

    // enum 상수
    GET_ALL("POST_1", "게시물 목록 조회에 성공하였습니다"), // = "new PostSuccessType("POST_1", "게시글 목록 조회에 성공하였습니다.");"
    CREATE("POST_2", "게시물 생성에 성공하였습니다"),
    GET_ONE("POST_3", "게시물 단일 조회에 성공하였습니다.");



    private final String code;
    private final String message;

    // 생성자 -> enum 상수를 정의하면서 생성자 호출
    // GET_ALL("POST_1", "...")을 선언하면 → 자바가 내부적으로 new PostSuccessType(...)을 해서 생성자를 자동 호출
    PostSuccessType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    // getter 구현
    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
