package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.PageParams;
import cn.edu.cqut.crmservice.entity.Services;
import cn.edu.cqut.crmservice.service.ServicesService;
import cn.edu.cqut.crmservice.util.ServiceCondition;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-06-08
 */
@RestController
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    ServicesService servicesService;

    @PreAuthorize("hasAnyAuthority('MANAGER','ADMIN')")
    @PostMapping("/all/archive")
    public TableResult getCustomerList(@RequestBody PageParams pageParams) {
        QueryWrapper<Services> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("services_state", "已归档");
        Page<Services> customerPage = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        Page<Services> page = servicesService.page(customerPage, queryWrapper);
        return TableResult.ok("查询成功", page.getTotal(), page.getRecords());
    }

    @PostMapping("/all/new")
    public TableResult getNewServiceList(@RequestBody PageParams pageParams) {
        QueryWrapper<Services> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("services_state", "新创建");
        Page<Services> customerPage = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        Page<Services> page = servicesService.page(customerPage, queryWrapper);
        return TableResult.ok("查询成功", page.getTotal(), page.getRecords());
    }

    @PostMapping("/all/assign")
    public TableResult getAssignServiceList(@RequestBody PageParams pageParams) {
        QueryWrapper<Services> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("services_state", "已分配");
        Page<Services> customerPage = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        Page<Services> page = servicesService.page(customerPage, queryWrapper);
        return TableResult.ok("查询成功", page.getTotal(), page.getRecords());
    }

    @PostMapping("/all/handle")
    public TableResult getHandleServiceList(@RequestBody PageParams pageParams) {
        QueryWrapper<Services> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("services_state", "已处理");
        Page<Services> customerPage = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        Page<Services> page = servicesService.page(customerPage, queryWrapper);
        return TableResult.ok("查询成功", page.getTotal(), page.getRecords());
    }

    @PreAuthorize("hasAnyAuthority('MANAGER','ADMIN')")
    @PostMapping("/assign")
    public TableResult assignService(@RequestBody Services services) {
        services.setServicesAtime(new Date());
        services.setServicesState("已分配");
        servicesService.updateById(services);
        return TableResult.ok("更新成功");
    }

    @PostMapping("/handle")
    public TableResult handleService(@RequestBody Services services) {
        services.setServicesPtime(new Date());
        services.setServicesState("已处理");
        servicesService.updateById(services);
        return TableResult.ok("更新成功");
    }

    @PostMapping("/feedback")
    public TableResult feedbackService(@RequestBody Services services) {
        services.setServicesFtime(new Date());
        if (services.getServicesSatisfaction() < 3) {
            services.setServicesState("已分配");
            servicesService.updateById(services);
            return TableResult.ok("再次分配成功");
        } else {
            services.setServicesState("已归档");
            servicesService.updateById(services);
            return TableResult.ok("归档成功");
        }
    }

    @PostMapping("/add")
    public TableResult addService(@RequestBody Services services) {
        services.setServicesState("新创建");
        services.setServicesCreator(SecurityContextHolder.getContext().getAuthentication().getName());
        servicesService.save(services);
        return TableResult.ok("新增成功");
    }

    @PostMapping("/delete")
    public TableResult deleteService(@RequestBody Integer[] ids) {
        servicesService.removeBatchByIds(Arrays.asList(ids));
        return TableResult.ok("删除成功");
    }

    @PostMapping("/search")
    public TableResult search(@RequestBody ServiceCondition condition) {
        QueryWrapper<Services> queryWrapper = new QueryWrapper<>();
        Date date1 = condition.getDate1();
        Date date2 = condition.getDate2();
        Integer satisfaction = condition.getServicesSatisfaction();
        String person = condition.getServicesPerson();
        System.out.println(condition);
        if (date1 != null && date2 != null) {
            queryWrapper.between("services_ctime", date1, date2);
        }
        if (date1 != null && date2 == null) {
            queryWrapper.ge("services_ctime", date1);
        }
        if (date1 == null && date2 != null) {
            queryWrapper.lt("services_ctime", date2);
        }
        if (satisfaction != null) {
            queryWrapper.eq("services_satisfaction", satisfaction);
        }
        if (person != null) {
            queryWrapper.eq("services_person", person);
        }
        queryWrapper.eq("services_state", "已归档");
        Page<Services> customerPage = new Page<>(condition.getPage(), condition.getPageSize());
        Page<Services> page = servicesService.page(customerPage, queryWrapper);
        return TableResult.ok("查询成功", page.getTotal(), page.getRecords());
    }

    @PostMapping("/detail")
    public TableResult getCustomerList(@RequestBody Integer serviceId) {
        QueryWrapper<Services> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("services_id", serviceId);
        Services services = servicesService.getById(serviceId);
        return TableResult.ok("查询成功", 1, services);
    }
}
