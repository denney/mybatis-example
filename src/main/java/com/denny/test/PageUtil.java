package com.denny.test;

public class PageUtil {
    private int page;
    private int pageSize;

    public PageUtil(int page, int pageSize) {
        System.out.println("page 值为:" + page + ",pageSize值为：" + pageSize);

        this.page = page;
        this.pageSize = pageSize;
    }

    public int getPage() {

        return (page - 1) * pageSize;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
