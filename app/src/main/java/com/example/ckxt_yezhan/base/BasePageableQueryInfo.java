package com.example.ckxt_yezhan.base;


public class BasePageableQueryInfo implements PageableQueryInfo {

    private static final long serialVersionUID = 1L;

    private int pageIndex;

    private int pageSize;

    private int rowStart;

    private int rowEnd;

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public int getPageIndex() {
        return pageIndex < 1 ? 1 : pageIndex;
    }

    @Override
    public int getPageSize() {
        return pageSize <= 0 ? 10 : pageSize;
    }


    public int getRowStart() {
        rowStart = this.getRowEnd() - this.getPageSize();
        return rowStart;
    }

    public void setRowStart(int rowStart) {
        this.rowStart = rowStart;
    }

    public int getRowEnd() {
        rowEnd = this.getPageIndex() * this.getPageSize();
        return rowEnd;
    }

    public void setRowEnd(int rowEnd) {
        this.rowEnd = rowEnd;
    }


}
