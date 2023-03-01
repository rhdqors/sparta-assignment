package com.sparta.mymemo.entity;

import com.sparta.mymemo.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Memo extends TimeStamped{

    @Id // pk설정
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(nullable = false) // ddl 생성시 not null 설정. - 데이터 생성시 null 못들어오게?
    private String userName;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String password;


    public Memo(MemoRequestDto requestDto) {
        this.userName = requestDto.getUserName();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
        this.password = requestDto.getPassword();
    }

    public void updateMemo(MemoRequestDto requestDto) {
        this.userName = requestDto.getUserName();
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }

}
