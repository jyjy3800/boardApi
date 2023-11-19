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
        
        // parentId�� �ִ� ��� �ش� id�� ������ ���� ReplyResponse ��ü�� �ڽ����� ���̰�,
    public static List<ReplyResponse> sortComments(List<ReplyResponse> comments) {
        Map<Long, List<ReplyResponse>> commentMap = new HashMap<>();
        List<ReplyResponse> sortedComments = new ArrayList<>();

        // �� ����� �θ� ID�� �������� �ʿ� ����
        for (ReplyResponse comment : comments) {
            if (!commentMap.containsKey(comment.getFatherId())) {
                commentMap.put(comment.getFatherId(), new ArrayList<>());
            }
            commentMap.get(comment.getFatherId()).add(comment);
        }

        // �ֻ��� ���� ��ۺ��� �����Ͽ� ��������� ����
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
