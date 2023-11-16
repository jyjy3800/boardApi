package com.kopo.wise.domain.post;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
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
   
}
