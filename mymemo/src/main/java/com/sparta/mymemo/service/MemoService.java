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

    @Transactional // 글 생성
    public Memo createMemo(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo);
        return memo;
    }

    @Transactional(readOnly = true) // 전체 글 조회
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional // 선택 글 조회
    public Memo getMemo(Long id/*controller에서 가져온 id값*/) {
        Memo memo = memoRepository.findById(id/*controller에서 가져온 id값*/).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")// 오류 발생시
        );
        return memo; // 아이디 일치하면 controller로 memo리턴
    }

    @Transactional // 글 수정
    public Long updateMemo(Long id, MemoRequestDto requestDto) {
        Memo memo = getMemo(id); // 위에 선택 글 조회에서 같은 내용이 있어 메서드를 호출해 사용할 수 있다.
//        memoRepository.findById(id).orElseThrow( //위와 같은 내용
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")// 오류 발생시
//        );
        if (!memo.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        memo.updateMemo(requestDto); // 오류 없으면 수정해야할 메모 있다 판단. - 가지고온 데이터로 변경, memo entity에서 update메서드를 만들어 처리할거임
        return memo.getId();
    }

    @Transactional // 글 삭제
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
