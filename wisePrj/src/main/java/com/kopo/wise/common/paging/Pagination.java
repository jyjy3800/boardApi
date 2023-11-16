package com.kopo.wise.common.paging;


import com.kopo.wise.common.dto.SearchDto;

import lombok.Getter;

@Getter
public class Pagination {

    private int totalRecordCount;     // ? „ì²? ?°?´?„° ?ˆ˜
    private int totalPageCount;       // ? „ì²? ?˜?´ì§? ?ˆ˜
    private int startPage;            // ì²? ?˜?´ì§? ë²ˆí˜¸
    private int endPage;              // ? ?˜?´ì§? ë²ˆí˜¸
    private int limitStart;           // LIMIT ?‹œ?‘ ?œ„ì¹?
    private boolean existPrevPage;    // ?´? „ ?˜?´ì§? ì¡´ì¬ ?—¬ë¶?
    private boolean existNextPage;    // ?‹¤?Œ ?˜?´ì§? ì¡´ì¬ ?—¬ë¶?

    public Pagination(int totalRecordCount, SearchDto params) {
        if (totalRecordCount > 0) {
            this.totalRecordCount = totalRecordCount;
            calculation(params);
            params.setPagination(this);
        }
    }

    private void calculation(SearchDto params) {

        // ? „ì²? ?˜?´ì§? ?ˆ˜ ê³„ì‚°
        totalPageCount = ((totalRecordCount - 1) / params.getRecordSize()) + 1;

        // ?˜„?¬ ?˜?´ì§? ë²ˆí˜¸ê°? ? „ì²? ?˜?´ì§? ?ˆ˜ë³´ë‹¤ ?° ê²½ìš°, ?˜„?¬ ?˜?´ì§? ë²ˆí˜¸?— ? „ì²? ?˜?´ì§? ?ˆ˜ ???¥
        if (params.getPage() > totalPageCount) {
            params.setPage(totalPageCount);
        }

        // ì²? ?˜?´ì§? ë²ˆí˜¸ ê³„ì‚°
        startPage = ((params.getPage() - 1) / params.getPageSize()) * params.getPageSize() + 1;

        // ? ?˜?´ì§? ë²ˆí˜¸ ê³„ì‚°
        endPage = startPage + params.getPageSize() - 1;

        // ? ?˜?´ì§?ê°? ? „ì²? ?˜?´ì§? ?ˆ˜ë³´ë‹¤ ?° ê²½ìš°, ? ?˜?´ì§? ? „ì²? ?˜?´ì§? ?ˆ˜ ???¥
        if (endPage > totalPageCount) {
            endPage = totalPageCount;
        }

        // LIMIT ?‹œ?‘ ?œ„ì¹? ê³„ì‚°
        limitStart = (params.getPage() - 1) * params.getRecordSize();

        // ?´? „ ?˜?´ì§? ì¡´ì¬ ?—¬ë¶? ?™•?¸
        existPrevPage = startPage != 1;

        // ?‹¤?Œ ?˜?´ì§? ì¡´ì¬ ?—¬ë¶? ?™•?¸
        existNextPage = (endPage * params.getRecordSize()) < totalRecordCount;
    }

}
