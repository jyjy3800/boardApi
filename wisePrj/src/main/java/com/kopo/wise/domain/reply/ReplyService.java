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
    public List<ReplyResponse> findPostId(final Long id) {
        List<ReplyResponse> replies = replyMapper.findAll(id);
        
      replies = sortComments(replies);
      for (ReplyResponse reply : replies) {
          System.out.println("id: " + reply.getId() + ", parentId: " + reply.getFatherId());
      }
        return replies;
    }
        
        // parentId가 있는 경우 해당 id와 동일한 값의 ReplyResponse 객체를 자식으로 붙이고,
    public static List<ReplyResponse> sortComments(List<ReplyResponse> comments) {
        Map<Long, List<ReplyResponse>> commentMap = new HashMap<>();
        List<ReplyResponse> sortedComments = new ArrayList<>();

        // 각 댓글을 부모 ID를 기준으로 맵에 저장
        for (ReplyResponse comment : comments) {
            if (!commentMap.containsKey(comment.getFatherId())) {
                commentMap.put(comment.getFatherId(), new ArrayList<>());
            }
            commentMap.get(comment.getFatherId()).add(comment);
        }

        // 최상위 레벨 댓글부터 시작하여 재귀적으로 정렬
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
    

   
    @Transactional
    public Long updateComment(final ReplyRequest params,Long memberId) {
    	replyMapper.update(params);
        return params.getId();
    }

  
    @Transactional
    public Long deleteComment(final Long id, Long memberId) {
    	replyMapper.deleteById(id);
        return id;
    }

}
