package com.sparta.mymemo.service;

import com.sparta.mymemo.dto.MemoRequestDto;
import com.sparta.mymemo.entity.Memo;
import com.sparta.mymemo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor // 추적
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Memo createMemo(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo);
        return memo;
    }

    @Transactional(readOnly = true) // 글 조회
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Long updateMemo(Long id, MemoRequestDto requestDto) { // 글 수정
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")// 오류 발생시
        );
        if (!memo.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        memo.updateMemo(requestDto); // 오류 없으면 수정해야할 메모 있다 판단. - 가지고온 데이터로 변경, memo entity에서 update메서드를 만들어 처리할거임
        return memo.getId();

    }

    @Transactional
    public String deleteMemo(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")// 오류 발생시
        );// id가 공백이면 예외처리(아이디 없다.)
        if (!memo.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        } // 처음 db에 넣은 비밀번호와 요청받은 비밀번호(requestdto에 있는 비밀번호)가 다르면 불일치 예외 발생.

        memoRepository.deleteById(id);
        return "삭제 완료.";

    }
}
