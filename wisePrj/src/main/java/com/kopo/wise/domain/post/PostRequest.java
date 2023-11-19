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
    private String title;                                     // ?���?
    private String content;                                   // ?��?��
    private String writer;                                    // ?��?��?��
    private int postType;                                 // 공�?�? ?���?
    private List<MultipartFile> files = new ArrayList<>();    // 첨�??��?�� List
    private List<Long> removeFileIds = new ArrayList<>();     // ?��?��?�� 첨�??��?�� id List

}