package com.kopo.wise.common.dto;


import com.kopo.wise.common.paging.Pagination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {

    private int page;                 // ?��?�� ?��?���? 번호
    private int recordSize;           // ?��?���??�� 출력?�� ?��?��?�� 개수
    private int pageSize;             // ?���? ?��?��?�� 출력?�� ?��?���? ?��?���?
    private String keyword;           // �??�� ?��?��?��
    private String searchType;        // �??�� ?��?��
    private Pagination pagination;    // ?��?���??��?��?�� ?���?
    private long memberId;			  // adminPage, historyPage ?��?�� �??��
    
    public SearchDto() {
        this.page = 1;
        this.recordSize = 20;
        this.pageSize = 10;
    }

}