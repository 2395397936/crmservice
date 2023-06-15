package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.DevPlan;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-10
 */
public interface IDevPlanService extends IService<DevPlan> {

    void deleteAll(Integer[] ids);
}
