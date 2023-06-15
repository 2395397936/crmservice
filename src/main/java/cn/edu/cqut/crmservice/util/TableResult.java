package cn.edu.cqut.crmservice.util;

import cn.edu.cqut.crmservice.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableResult {
    private int code;

    private String message;

    private long count;

    private Object data;

    public TableResult(int code, String msg, Object data) {
        this.code = code;
        this.message = msg;
        this.data = data;
    }


    public static  TableResult ok(String msg, long count, Object data) {
        return new TableResult(200, msg, count, data);
    }

    public static  TableResult ok(String msg, Object data) {
        return new TableResult(200, msg, data);
    }



    public static  TableResult ok(String msg) {
        TableResult r = new TableResult();
        r.setCode(200);
        r.setMessage(msg);
        return r;
    }

    public static  TableResult ok(Object data) {
        TableResult r = new TableResult();
        r.setCode(200);
        r.setData(data);
        return r;
    }

    public static  TableResult error(int code ,String msg) {
        TableResult r = new TableResult();
        r.setCode(code);
        r.setMessage(msg);
        return r;
    }
}
