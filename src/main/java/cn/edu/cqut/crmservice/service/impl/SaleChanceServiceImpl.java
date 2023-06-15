package cn.edu.cqut.crmservice.service.impl;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.DevPlan;
import cn.edu.cqut.crmservice.entity.SaleChance;
import cn.edu.cqut.crmservice.mapper.SaleChanceMapper;
import cn.edu.cqut.crmservice.service.CustomerService;
import cn.edu.cqut.crmservice.service.ISaleChanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-10
 */
@Service
public class SaleChanceServiceImpl extends ServiceImpl<SaleChanceMapper, SaleChance> implements ISaleChanceService {
    @Autowired
    CustomerService customerService;

    @Override
    public void success(SaleChance saleChance) {
        Customer customer = new Customer();
        customer.setCusName(saleChance.getSaleName());
        customerService.save(customer);
    }
}
