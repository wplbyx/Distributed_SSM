package pojo;

import java.util.List;

/**
 *  Created by Administrator on 2017/12/19 0019.
 */
public class EasyUiDataGrid {

    private long total;
    private List<?> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
