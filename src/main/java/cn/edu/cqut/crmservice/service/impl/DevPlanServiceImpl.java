package cn.edu.cqut.crmservice.service.impl;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.DevPlan;
import cn.edu.cqut.crmservice.entity.SaleChance;
import cn.edu.cqut.crmservice.mapper.CustomerMapper;
import cn.edu.cqut.crmservice.mapper.DevPlanMapper;
import cn.edu.cqut.crmservice.service.CustomerService;
import cn.edu.cqut.crmservice.service.IDevPlanService;
import cn.edu.cqut.crmservice.service.ISaleChanceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
public class DevPlanServiceImpl extends ServiceImpl<DevPlanMapper, DevPlan> implements IDevPlanService {

    @Override
    public void deleteAll(Integer[] ids) {
        QueryWrapper<DevPlan> queryWrapper = new QueryWrapper<>();
        for (Integer id : ids) {
            queryWrapper.eq("sale_id",id);
            this.remove(queryWrapper);
        }
    }
}
