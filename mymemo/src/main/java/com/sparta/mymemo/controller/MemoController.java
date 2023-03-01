package com.sparta.mymemo.controller;

import com.sparta.mymemo.dto.MemoRequestDto;
import com.sparta.mymemo.entity.Memo;
import com.sparta.mymemo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController // json 형태로 데이터 반환?
@RequiredArgsConstructor // 생성자 부분의 autowired 필요없음
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping("/api/memos") // 글쓰기
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) { // dto를 문자열로 받아오겠다 ?
        return memoService.createMemo(requestDto);
    }

    @GetMapping("/api/memos") // 글조회
    public List<Memo> getMemos() {
        return memoService.getMemos();
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.updateMemo(id, requestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public String deleteMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.deleteMemo(id, requestDto);
    }



}
