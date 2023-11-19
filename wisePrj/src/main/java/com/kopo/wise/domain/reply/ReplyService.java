package com.kopo.wise.domain.reply;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyMapper replyMapper;
    
    //댓글 리스트 조회
    public List<ReplyResponse> findPostId(final Long id) {
        List<ReplyResponse> replies = replyMapper.findAll(id);
        
      replies = sortComments(replies);
      for (ReplyResponse reply : replies) {
          System.out.println("id: " + reply.getId() + ", parentId: " + reply.getFatherId());
      }
        return replies;
    }
    //댓글 순서 정렬(부모 댓글 다음 바로 자식 댓글)
    public static List<ReplyResponse> sortComments(List<ReplyResponse> comments) {
        Map<Long, List<ReplyResponse>> commentMap = new HashMap<>();
        List<ReplyResponse> sortedComments = new ArrayList<>();

        for (ReplyResponse comment : comments) {
            if (!commentMap.containsKey(comment.getFatherId())) {
                commentMap.put(comment.getFatherId(), new ArrayList<>());
            }
            commentMap.get(comment.getFatherId()).add(comment);
        }

        recursiveSort(null, commentMap, sortedComments);

        return sortedComments;
    }

    private static void recursiveSort(Long parentId, Map<Long, List<ReplyResponse>> commentMap, List<ReplyResponse> sortedComments) {
        if (commentMap.containsKey(parentId)) {
            for (ReplyResponse comment : commentMap.get(parentId)) {
                sortedComments.add(comment);
                recursiveSort(comment.getId(), commentMap, sortedComments);
            }
        }
    }
    
    /**
     * 댓글 저장
     * @param params - 댓글 정보
     * @return Generated PK
     */
    @Transactional
    public Long saveReply(final ReplyRequest params) {
    	replyMapper.save(params);
        return params.getId();
    }
   
    /**
     * 댓글 상세정보 조회
     * @param id - PK
     * @return 댓글 상세정보
     */
    public ReplyResponse findReplyById(final Long id) {
        return replyMapper.findById(id);
    }

    /**
     * 댓글 수정
     * @param params - 댓글 정보
     * @return PK
     */
    @Transactional
    public Long updateReply(final ReplyRequest params) {
    	replyMapper.update(params);
        return params.getId();
    }

    /**
     * 댓글 삭제
     * @param id - PK
     * @return PK
     */
    @Transactional
    public Long deleteReply(final Long id) {
    	replyMapper.deleteById(id);
        return id;
    }

    

}
