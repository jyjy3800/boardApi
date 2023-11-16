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
    private String title;                                     // ?†úÎ™?
    private String content;                                   // ?Ç¥?ö©
    private String writer;                                    // ?ûë?Ñ±?ûê
    private Boolean noticeYn;                                 // Í≥µÏ?Í∏? ?ó¨Î∂?
    private List<MultipartFile> files = new ArrayList<>();    // Ï≤®Î??åå?ùº List
    private List<Long> removeFileIds = new ArrayList<>();     // ?Ç≠?†ú?ï† Ï≤®Î??åå?ùº id List

}