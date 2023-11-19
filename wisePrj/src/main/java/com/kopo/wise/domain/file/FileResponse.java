package com.kopo.wise.domain.file;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FileResponse {

    private Long id;                      // ?��?�� 번호 (PK)
    private Long postId;                  // 게시�? 번호 (FK)
    private String originalName;          // ?���? ?��?���?
    private String saveName;              // ???�� ?��?���?
    private long size;                    // ?��?�� ?���?
    private Boolean deleteYn;             // ?��?�� ?���?
    private LocalDateTime createdDate;    // ?��?��?��?��
    private LocalDateTime deletedDate;    // ?��?��?��?��

}
