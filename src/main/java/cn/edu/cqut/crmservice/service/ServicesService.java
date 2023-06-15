package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.Report;
import cn.edu.cqut.crmservice.entity.Services;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-08
 */
public interface ServicesService extends IService<Services> {

    List<Report> getCustomerServices();

    List<Report> getCustomerLoss();
}
