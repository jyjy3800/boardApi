package com.kopo.wise.domain.file;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class FileResponse {

    private Long id;                      // ??Ό λ²νΈ (PK)
    private Long postId;                  // κ²μκΈ? λ²νΈ (FK)
    private String originalName;          // ?λ³? ??Όλͺ?
    private String saveName;              // ???₯ ??Όλͺ?
    private long size;                    // ??Ό ?¬κΈ?
    private Boolean deleteYn;             // ?­?  ?¬λΆ?
    private LocalDateTime createdDate;    // ??±?Ό?
    private LocalDateTime deletedDate;    // ?­? ?Ό?

}
