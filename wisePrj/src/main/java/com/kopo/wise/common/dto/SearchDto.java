package com.kopo.wise.common.dto;


import com.kopo.wise.common.paging.Pagination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {

    private int page;                 // ??¬ ??΄μ§? λ²νΈ
    private int recordSize;           // ??΄μ§??Ή μΆλ ₯?  ?°?΄?° κ°μ
    private int pageSize;             // ?λ©? ??¨? μΆλ ₯?  ??΄μ§? ?¬?΄μ¦?
    private String keyword;           // κ²?? ?€??
    private String searchType;        // κ²?? ? ?
    private Pagination pagination;    // ??΄μ§??€?΄? ? λ³?
    private long memberId;			  // adminPage, historyPage ?? κ²??
    
    public SearchDto() {
        this.page = 1;
        this.recordSize = 20;
        this.pageSize = 10;
    }

}