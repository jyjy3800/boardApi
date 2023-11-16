package com.kopo.wise.config;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PostResponse {

    private Long id;                       // PK
    private String title;                  // ? λͺ?
    private String content;                // ?΄?©
    private String writer;                 // ??±?
    private int viewCnt;                   // μ‘°ν ?
    private int likeCnt;				   // μ’μ? ?
    private Boolean noticeYn;              // κ³΅μ?κΈ? ?¬λΆ?
    private Boolean deleteYn;              // ?­?  ?¬λΆ?
    private LocalDateTime createdDate;     // ??±?Ό?
    private LocalDateTime modifiedDate;    // μ΅μ’ ?? ?Ό?
    private String saveName;              // ???₯ ??Όλͺ?
    private LocalDateTime fileDate;    // ??Ό??±?Ό?
   
}
