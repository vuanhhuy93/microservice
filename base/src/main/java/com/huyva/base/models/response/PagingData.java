package com.huyva.base.models.response;

import lombok.Data;

@Data
public class PagingData {
    private int currentPage;
    private int pageSize;
    private int totalItems;
    private int totalPage;
}
