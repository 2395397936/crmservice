package cn.edu.cqut.crmservice.service.impl;

import cn.edu.cqut.crmservice.entity.CustomerLoss;
import cn.edu.cqut.crmservice.mapper.CustomerLossMapper;
import cn.edu.cqut.crmservice.service.ICustomerLossService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-12
 */
@Service
public class CustomerLossServiceImpl extends ServiceImpl<CustomerLossMapper, CustomerLoss> implements ICustomerLossService {

    @Override
    public void getLoss() {
        this.baseMapper.getLoss();
    }
}
