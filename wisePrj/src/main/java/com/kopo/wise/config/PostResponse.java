package com.kopo.wise.config;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PostResponse {

    private Long id;                       // PK
    private String title;                  // ?���?
    private String content;                // ?��?��
    private String writer;                 // ?��?��?��
    private int viewCnt;                   // 조회 ?��
    private int likeCnt;				   // 좋아?�� ?��
    private Boolean noticeYn;              // 공�?�? ?���?
    private Boolean deleteYn;              // ?��?�� ?���?
    private LocalDateTime createdDate;     // ?��?��?��?��
    private LocalDateTime modifiedDate;    // 최종 ?��?��?��?��
    private String saveName;              // ???�� ?��?���?
    private LocalDateTime fileDate;    // ?��?��?��?��?��?��
   
}
