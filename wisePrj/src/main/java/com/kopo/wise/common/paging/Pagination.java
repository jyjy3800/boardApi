package com.kopo.wise.common.paging;


import com.kopo.wise.common.dto.SearchDto;

import lombok.Getter;

@Getter
public class Pagination {

    private int totalRecordCount;     // ? μ²? ?°?΄?° ?
    private int totalPageCount;       // ? μ²? ??΄μ§? ?
    private int startPage;            // μ²? ??΄μ§? λ²νΈ
    private int endPage;              // ? ??΄μ§? λ²νΈ
    private int limitStart;           // LIMIT ?? ?μΉ?
    private boolean existPrevPage;    // ?΄?  ??΄μ§? μ‘΄μ¬ ?¬λΆ?
    private boolean existNextPage;    // ?€? ??΄μ§? μ‘΄μ¬ ?¬λΆ?

    public Pagination(int totalRecordCount, SearchDto params) {
        if (totalRecordCount > 0) {
            this.totalRecordCount = totalRecordCount;
            calculation(params);
            params.setPagination(this);
        }
    }

    private void calculation(SearchDto params) {

        // ? μ²? ??΄μ§? ? κ³μ°
        totalPageCount = ((totalRecordCount - 1) / params.getRecordSize()) + 1;

        // ??¬ ??΄μ§? λ²νΈκ°? ? μ²? ??΄μ§? ?λ³΄λ€ ?° κ²½μ°, ??¬ ??΄μ§? λ²νΈ? ? μ²? ??΄μ§? ? ???₯
        if (params.getPage() > totalPageCount) {
            params.setPage(totalPageCount);
        }

        // μ²? ??΄μ§? λ²νΈ κ³μ°
        startPage = ((params.getPage() - 1) / params.getPageSize()) * params.getPageSize() + 1;

        // ? ??΄μ§? λ²νΈ κ³μ°
        endPage = startPage + params.getPageSize() - 1;

        // ? ??΄μ§?κ°? ? μ²? ??΄μ§? ?λ³΄λ€ ?° κ²½μ°, ? ??΄μ§? ? μ²? ??΄μ§? ? ???₯
        if (endPage > totalPageCount) {
            endPage = totalPageCount;
        }

        // LIMIT ?? ?μΉ? κ³μ°
        limitStart = (params.getPage() - 1) * params.getRecordSize();

        // ?΄?  ??΄μ§? μ‘΄μ¬ ?¬λΆ? ??Έ
        existPrevPage = startPage != 1;

        // ?€? ??΄μ§? μ‘΄μ¬ ?¬λΆ? ??Έ
        existNextPage = (endPage * params.getRecordSize()) < totalRecordCount;
    }

}
