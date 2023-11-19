package com.kopo.wise.domain.reply;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReplyMapper {

    List<ReplyResponse> findAll(Long postId);

    /**
     * 댓글 저장
     * @param params - 댓글 정보
     */
    void save(ReplyRequest params);

    /**
     * 댓글 상세정보 조회
     * @param id - PK
     * @return 댓글 상세정보
     */
    ReplyResponse findById(Long id);

    /**
     * 댓글 수정
     * @param params - 댓글 정보
     */
    void update(ReplyRequest params);

    /**
     * 댓글 삭제
     * @param id - PK
     */
    void deleteById(Long id);

}
