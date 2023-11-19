package com.kopo.wise.domain.post;


import java.time.LocalDateTime;
import java.util.List;

import com.kopo.wise.domain.file.FileResponse;
import com.kopo.wise.domain.reply.ReplyResponse;

import lombok.Data;

@Data
public class PostResponse {

    private Long id;                       
    private String title;               
    private String content;              
    private String writer;               
    private Boolean deleteYn;              
    private LocalDateTime createdDate;    
    private LocalDateTime modifiedDate;    
    private String saveName;             
    private LocalDateTime fileDate;   
    private List<ReplyResponse> replies;
    private List<FileResponse> files;
   
}
