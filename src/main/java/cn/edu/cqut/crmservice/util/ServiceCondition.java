package cn.edu.cqut.crmservice.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCondition {
    private Date date1;
    private Date date2;
    private Integer servicesSatisfaction;
    private String servicesPerson;
    private Integer page;
    private Integer pageSize;
}
