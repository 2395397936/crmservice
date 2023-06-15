package cn.edu.cqut.crmservice.mapper;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Report;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2023-06-06
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    @Select("select count(*) value, cus_region item from customer GROUP BY cus_region")
    List<Report> getCustomerCountByRegion();

    List<Report> getCustomerAttribute();

    List<Report> getCustomerAttributeByCusId(Integer cusId);

    @Select("select count(*) value, cus_rate item from customer GROUP BY cus_rate ORDER BY cus_rate")
    List<Report> getCustomerRate();

    @Select("select count(*) value, cus_credit item from customer GROUP BY cus_credit ORDER BY cus_credit")
    List<Report> getCustomerCredit();
}
