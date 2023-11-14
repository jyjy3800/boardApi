package com.kopo.wise;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class BoardResponse<T> {
	
	private List<T> data = new ArrayList<>();
	private Pagination pagination;

    public BoardResponse(List<T> list, Pagination pagination) {
        this.data.addAll(list);
        this.pagination = pagination;
    }

}
