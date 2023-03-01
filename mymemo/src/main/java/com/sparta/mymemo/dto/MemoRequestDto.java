package com.sparta.mymemo.dto;

import lombok.Getter;

@Getter
public class MemoRequestDto {

    private String title;
    private String userName;
    private String password;
    private String contents;
}
