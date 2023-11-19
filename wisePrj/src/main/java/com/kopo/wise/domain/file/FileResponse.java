package com.kopo.wise.domain.file;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FileResponse {

    private Long id;                      // ?ŒŒ?¼ ë²ˆí˜¸ (PK)
    private Long postId;                  // ê²Œì‹œê¸? ë²ˆí˜¸ (FK)
    private String originalName;          // ?›ë³? ?ŒŒ?¼ëª?
    private String saveName;              // ???¥ ?ŒŒ?¼ëª?
    private long size;                    // ?ŒŒ?¼ ?¬ê¸?
    private Boolean deleteYn;             // ?‚­? œ ?—¬ë¶?
    private LocalDateTime createdDate;    // ?ƒ?„±?¼?‹œ
    private LocalDateTime deletedDate;    // ?‚­? œ?¼?‹œ

}
