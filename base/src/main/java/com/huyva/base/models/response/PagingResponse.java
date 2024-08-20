package com.huyva.base.models.response;

import lombok.Data;

import java.util.List;

@Data
public class PagingResponse <T>{
    private PagingData paging;
    private List<T> data;
}
