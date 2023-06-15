package cn.edu.cqut.crmservice.service.impl;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Report;
import cn.edu.cqut.crmservice.entity.ReportResult;
import cn.edu.cqut.crmservice.mapper.CustomerMapper;
import cn.edu.cqut.crmservice.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-06
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Override
    public List<Report> getCustomerCountByRegion() {
        return baseMapper.getCustomerCountByRegion();
    }

    @Override
    public List<Report>  getCustomerAttribute() {
        return baseMapper.getCustomerAttribute();
    }

    @Override
    public List<Report> getCustomerAttributeByCusId(Integer cusId) {
        return baseMapper.getCustomerAttributeByCusId(cusId);
    }

    @Override
    public List<Report> getCustomerRate() {
        return baseMapper.getCustomerRate();
    }

    @Override
    public List<Report> getCustomerCredit() {
        return baseMapper.getCustomerCredit();
    }

}
