package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.SaleChance;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-10
 */
public interface ISaleChanceService extends IService<SaleChance> {

    void success(SaleChance saleChance);
}
