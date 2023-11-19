package com.kopo.wise.domain.reply;



import lombok.Data;

@Data
public class ReplyResponse {

	private Long id;                       
    private Long postId;                
    private String content;              
    private String writer;           
    private Boolean deleteYn;             
    private String createdDate;    
    private String modifiedDate;  
    private Long fatherId;

}
