package com.kopo.wise.config;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PostResponse {

    private Long id;                       // PK
    private String title;                  // ? œëª?
    private String content;                // ?‚´?š©
    private String writer;                 // ?‘?„±?
    private int viewCnt;                   // ì¡°íšŒ ?ˆ˜
    private int likeCnt;				   // ì¢‹ì•„?š” ?ˆ˜
    private Boolean noticeYn;              // ê³µì?ê¸? ?—¬ë¶?
    private Boolean deleteYn;              // ?‚­? œ ?—¬ë¶?
    private LocalDateTime createdDate;     // ?ƒ?„±?¼?‹œ
    private LocalDateTime modifiedDate;    // ìµœì¢… ?ˆ˜? •?¼?‹œ
    private String saveName;              // ???¥ ?ŒŒ?¼ëª?
    private LocalDateTime fileDate;    // ?ŒŒ?¼?ƒ?„±?¼?‹œ
   
}
