package com.kopo.wise.common.dto;


import com.kopo.wise.common.paging.Pagination;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDto {

    private int page;                 // ?˜„?¬ ?˜?´ì§? ë²ˆí˜¸
    private int recordSize;           // ?˜?´ì§??‹¹ ì¶œë ¥?•  ?°?´?„° ê°œìˆ˜
    private int pageSize;             // ?™”ë©? ?•˜?‹¨?— ì¶œë ¥?•  ?˜?´ì§? ?‚¬?´ì¦?
    private String keyword;           // ê²??ƒ‰ ?‚¤?›Œ?“œ
    private String searchType;        // ê²??ƒ‰ ?œ ?˜•
    private Pagination pagination;    // ?˜?´ì§??„¤?´?…˜ ? •ë³?
    private long memberId;			  // adminPage, historyPage ?—?„œ ê²??ƒ‰
    
    public SearchDto() {
        this.page = 1;
        this.recordSize = 20;
        this.pageSize = 10;
    }

}