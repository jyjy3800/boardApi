package com.kopo.wise.domain.reply;


import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ReplyResponse {

    private Long id;                       
    private Long postId;                
    private String content;              
    private String writer;           
    private Boolean deleteYn;             
    private LocalDateTime createdDate;    
    private LocalDateTime modifiedDate;  
    private Long fatherCommentId;

}
