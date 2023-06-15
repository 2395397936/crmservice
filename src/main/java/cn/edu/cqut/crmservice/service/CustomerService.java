package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Report;
import cn.edu.cqut.crmservice.entity.ReportResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-06
 */
public interface CustomerService extends IService<Customer> {
    public List<Report> getCustomerCountByRegion();

    List<Report>  getCustomerAttribute();

    List<Report> getCustomerAttributeByCusId(Integer cusId);

    List<Report> getCustomerRate();

    List<Report> getCustomerCredit();
}
