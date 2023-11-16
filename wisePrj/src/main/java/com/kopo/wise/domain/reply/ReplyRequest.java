package com.kopo.wise.domain.reply;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReplyRequest {

    private Long id;           
    private Long postId;      
    private String content;   
    private String writer;   
    private Long fatherCommentId;


}