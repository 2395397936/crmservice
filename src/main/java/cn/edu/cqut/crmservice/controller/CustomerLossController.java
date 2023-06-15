package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.CustomerLoss;
import cn.edu.cqut.crmservice.entity.LoginUser;
import cn.edu.cqut.crmservice.entity.PageParams;
import cn.edu.cqut.crmservice.service.CustomerService;
import cn.edu.cqut.crmservice.service.ICustomerLossService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-06-12
 */
@RestController
@RequestMapping("/customerLoss")
public class CustomerLossController {
    @Autowired
    ICustomerLossService customerLossService;
    @Autowired
    CustomerService customerService;

    @Scheduled(cron = "0 0 2 * * ?")
    public void job(){
        customerLossService.getLoss();
    }

    @PostMapping("/all")
    public TableResult getCustomerLossList(@RequestBody PageParams pageParams){
        Page<CustomerLoss> customerPage = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        Page<CustomerLoss> page = customerLossService.page(customerPage);//调用service层的list方法，返回数据表的所有数据
        return TableResult.ok("查询成功", page.getTotal(), page.getRecords());
    }

    @PostMapping("/pause")
    public TableResult pause(@RequestBody CustomerLoss customerLoss){
        customerLoss.setClStatus(2);
        LoginUser principal = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        customerLoss.setSuId(principal.getUser().getSuId());
        customerLossService.updateById(customerLoss);
        return TableResult.ok("修改成功");
    }

    @PostMapping("/fail")
    public TableResult fail(@RequestBody CustomerLoss customerLoss){
        Customer customer = new Customer();
        customer.setCusId(customerLoss.getCusId());
        customer.setCusStatus(0);

        customerLoss.setClStatus(3);
        customerLoss.setClLossTime(new Date());
        customerService.updateById(customer);

        customerLossService.updateById(customerLoss);
        return TableResult.ok("修改成功");
    }

    @PostMapping("/success")
    public TableResult success(@RequestBody Integer[] ids){
        CustomerLoss customerLoss = new CustomerLoss();
        customerLoss.setClStatus(4);
        for (Integer id : ids) {
            customerLoss.setClId(id);
            customerLossService.updateById(customerLoss);
        }
        return TableResult.ok("修改成功");
    }
}
