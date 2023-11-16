package com.kopo.wise.domain.reply;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyMapper commentMapper;

 
    @Transactional
    public Long saveComment(final ReplyRequest params, Long memberId) {
        commentMapper.save(params);
        return params.getId();
    }

   
    public  Map<Long, List<ReplyResponse>> findPostId(final Long id) {
    	List<ReplyResponse> replies = commentMapper.findAll(id);
    	Map<Long, List<ReplyResponse>> data = buildCommentTree(replies);
        return data;
    }

    
    @Transactional
    public Long updateComment(final ReplyRequest params,Long memberId) {
        commentMapper.update(params);
        return params.getId();
    }

    
    @Transactional
    public Long deleteComment(final Long id, Long memberId) {
        commentMapper.deleteById(id);
        return id;
    }

    public Map<Long, List<ReplyResponse>> buildCommentTree(List<ReplyResponse> replies) {
        Map<Long, List<ReplyResponse>> replyTree = new HashMap<>();

        for (ReplyResponse reply : replies) {
            replyTree.putIfAbsent(reply.getFatherCommentId(), new ArrayList<>());
            replyTree.get(reply.getFatherCommentId()).add(reply);
        }

        return replyTree;
    }

    
   

}
