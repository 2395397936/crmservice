package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Orders;
import cn.edu.cqut.crmservice.entity.PageParams;
import cn.edu.cqut.crmservice.service.CustomerService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-06-06
 */
@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping("/all")
    public TableResult getCustomerList(@RequestBody PageParams pageParams){
        Page<Customer> customerPage = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        Page<Customer> page = customerService.page(customerPage);//调用service层的list方法，返回数据表的所有数据
        return TableResult.ok("查询成功", page.getTotal(), page.getRecords());
    }

    @PostMapping("/update")
    public TableResult updateCustomer(@RequestBody Customer customer){
        customerService.updateById(customer);
        return TableResult.ok("更新成功");
    }

    @PostMapping("/add")
    public TableResult addCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return TableResult.ok("新增成功");
    }

    @PostMapping("/delete")
    public TableResult deleteCustomer(@RequestBody Integer[] ids){
        customerService.removeBatchByIds(Arrays.asList(ids));
        return TableResult.ok("删除成功");
    }

    @GetMapping("/name")
    public TableResult getCustomerName(){
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("cus_id","cus_name");
        List<Customer> list = customerService.list(queryWrapper);
        return TableResult.ok(list);
    }


}
