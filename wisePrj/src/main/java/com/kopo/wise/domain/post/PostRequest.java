package com.kopo.wise.domain.post;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PostRequest {

    private Long id;                                          // PK
    private String title;                                     // ? λͺ?
    private String content;                                   // ?΄?©
    private String writer;                                    // ??±?
    private Boolean noticeYn;                                 // κ³΅μ?κΈ? ?¬λΆ?
    private List<MultipartFile> files = new ArrayList<>();    // μ²¨λ???Ό List
    private List<Long> removeFileIds = new ArrayList<>();     // ?­? ?  μ²¨λ???Ό id List

}