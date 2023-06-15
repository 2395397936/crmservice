package cn.edu.cqut.crmservice.service.impl;

import cn.edu.cqut.crmservice.entity.Report;
import cn.edu.cqut.crmservice.entity.Services;
import cn.edu.cqut.crmservice.mapper.ServicesMapper;
import cn.edu.cqut.crmservice.service.ServicesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-08
 */
@Service
public class ServicesServiceImpl extends ServiceImpl<ServicesMapper, Services> implements ServicesService {

    @Override
    public List<Report> getCustomerServices() {
        return baseMapper.getCustomerServices();

    }

    @Override
    public List<Report> getCustomerLoss() {
        return baseMapper.getCustomerLoss();
    }
}
