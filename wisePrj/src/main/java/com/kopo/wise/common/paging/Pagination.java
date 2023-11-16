package com.kopo.wise.common.paging;


import com.kopo.wise.common.dto.SearchDto;

import lombok.Getter;

@Getter
public class Pagination {

    private int totalRecordCount;     // ?���? ?��?��?�� ?��
    private int totalPageCount;       // ?���? ?��?���? ?��
    private int startPage;            // �? ?��?���? 번호
    private int endPage;              // ?�� ?��?���? 번호
    private int limitStart;           // LIMIT ?��?�� ?���?
    private boolean existPrevPage;    // ?��?�� ?��?���? 존재 ?���?
    private boolean existNextPage;    // ?��?�� ?��?���? 존재 ?���?

    public Pagination(int totalRecordCount, SearchDto params) {
        if (totalRecordCount > 0) {
            this.totalRecordCount = totalRecordCount;
            calculation(params);
            params.setPagination(this);
        }
    }

    private void calculation(SearchDto params) {

        // ?���? ?��?���? ?�� 계산
        totalPageCount = ((totalRecordCount - 1) / params.getRecordSize()) + 1;

        // ?��?�� ?��?���? 번호�? ?���? ?��?���? ?��보다 ?�� 경우, ?��?�� ?��?���? 번호?�� ?���? ?��?���? ?�� ???��
        if (params.getPage() > totalPageCount) {
            params.setPage(totalPageCount);
        }

        // �? ?��?���? 번호 계산
        startPage = ((params.getPage() - 1) / params.getPageSize()) * params.getPageSize() + 1;

        // ?�� ?��?���? 번호 계산
        endPage = startPage + params.getPageSize() - 1;

        // ?�� ?��?���?�? ?���? ?��?���? ?��보다 ?�� 경우, ?�� ?��?���? ?���? ?��?���? ?�� ???��
        if (endPage > totalPageCount) {
            endPage = totalPageCount;
        }

        // LIMIT ?��?�� ?���? 계산
        limitStart = (params.getPage() - 1) * params.getRecordSize();

        // ?��?�� ?��?���? 존재 ?���? ?��?��
        existPrevPage = startPage != 1;

        // ?��?�� ?��?���? 존재 ?���? ?��?��
        existNextPage = (endPage * params.getRecordSize()) < totalRecordCount;
    }

}
