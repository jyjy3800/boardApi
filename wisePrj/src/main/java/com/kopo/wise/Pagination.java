package com.kopo.wise;


import lombok.Getter;

@Getter
public class Pagination {

    private int totalRecordCount;     // �쟾泥� �뜲�씠�꽣 �닔
    private int totalPageCount;       // �쟾泥� �럹�씠吏� �닔
    private int startPage;            // 泥� �럹�씠吏� 踰덊샇
    private int endPage;              // �걹 �럹�씠吏� 踰덊샇
    private int limitStart;           // LIMIT �떆�옉 �쐞移�
    private boolean existPrevPage;    // �씠�쟾 �럹�씠吏� 議댁옱 �뿬遺�
    private boolean existNextPage;    // �떎�쓬 �럹�씠吏� 議댁옱 �뿬遺�

    public Pagination(int totalRecordCount, SearchDto params) {
        if (totalRecordCount > 0) {
            this.totalRecordCount = totalRecordCount;
            calculation(params);
            params.setPagination(this);
        }
    }

    private void calculation(SearchDto params) {

        // �쟾泥� �럹�씠吏� �닔 怨꾩궛
        totalPageCount = ((totalRecordCount - 1) / params.getRecordSize()) + 1;

        // �쁽�옱 �럹�씠吏� 踰덊샇媛� �쟾泥� �럹�씠吏� �닔蹂대떎 �겙 寃쎌슦, �쁽�옱 �럹�씠吏� 踰덊샇�뿉 �쟾泥� �럹�씠吏� �닔 ���옣
        if (params.getPage() > totalPageCount) {
            params.setPage(totalPageCount);
        }

        // 泥� �럹�씠吏� 踰덊샇 怨꾩궛
        startPage = ((params.getPage() - 1) / params.getPageSize()) * params.getPageSize() + 1;

        // �걹 �럹�씠吏� 踰덊샇 怨꾩궛
        endPage = startPage + params.getPageSize() - 1;

        // �걹 �럹�씠吏�媛� �쟾泥� �럹�씠吏� �닔蹂대떎 �겙 寃쎌슦, �걹 �럹�씠吏� �쟾泥� �럹�씠吏� �닔 ���옣
        if (endPage > totalPageCount) {
            endPage = totalPageCount;
        }

        // LIMIT �떆�옉 �쐞移� 怨꾩궛
        limitStart = (params.getPage() - 1) * params.getRecordSize();

        // �씠�쟾 �럹�씠吏� 議댁옱 �뿬遺� �솗�씤
        existPrevPage = startPage != 1;

        // �떎�쓬 �럹�씠吏� 議댁옱 �뿬遺� �솗�씤
        existNextPage = (endPage * params.getRecordSize()) < totalRecordCount;
    }

}
