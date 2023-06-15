package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.CustomerLoss;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-12
 */
public interface ICustomerLossService extends IService<CustomerLoss> {
    void getLoss();
}
