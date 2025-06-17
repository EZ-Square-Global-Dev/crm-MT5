package com.ez.crm.common.core.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@Getter
@Setter
public class PageResponse<T> {
    private List<T> data;
    private int page;
    private int limit;
    private long total;

    public PageResponse(List<T> data, int page, int limit, long total) {
        this.data = data;
        this.page = page;
        this.limit = limit;
        this.total = total;
    }

}

