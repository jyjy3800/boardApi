package com.kopo.wise.domain.file;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FileRequest {

    private Long id;                // ??Ό λ²νΈ (PK)
    private Long postId;            // κ²μκΈ? λ²νΈ (FK)
    private String originalName;    // ?λ³? ??Όλͺ?
    private String saveName;        // ???₯ ??Όλͺ?
    private long size;              // ??Ό ?¬κΈ?

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