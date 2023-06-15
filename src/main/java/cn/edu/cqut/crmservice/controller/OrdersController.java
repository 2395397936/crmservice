package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.Orders;
import cn.edu.cqut.crmservice.entity.PageParams;
import cn.edu.cqut.crmservice.service.IOrdersService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-06-12
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    IOrdersService ordersService;

    @PostMapping("/all")
    public TableResult getCustomerList(@RequestBody PageParams pageParams){
        Page<Orders> customerPage = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        Page<Orders> page = ordersService.page(customerPage);//调用service层的list方法，返回数据表的所有数据
        return TableResult.ok("查询成功", page.getTotal(), page.getRecords());
    }


}
