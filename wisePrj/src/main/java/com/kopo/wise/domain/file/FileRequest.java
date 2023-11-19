package com.kopo.wise.domain.file;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FileRequest {

    private Long id;                // ?ŒŒ?¼ ë²ˆí˜¸ (PK)
    private Long postId;            // ê²Œì‹œê¸? ë²ˆí˜¸ (FK)
    private String originalName;    // ?›ë³? ?ŒŒ?¼ëª?
    private String saveName;        // ???¥ ?ŒŒ?¼ëª?
    private long size;              // ?ŒŒ?¼ ?¬ê¸?

    @Builder
    public FileRequest(String originalName, String saveName, long size) {
        this.originalName = originalName;
        this.saveName = saveName;
        this.size = size;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

}