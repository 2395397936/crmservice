package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Contact;
import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.PageParams;
import cn.edu.cqut.crmservice.service.ContactService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-06-08
 */
@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    ContactService contactService;

    @PostMapping("/getContactPage/{cusId}")
    public TableResult getContactPage(@RequestBody PageParams pageParams, @PathVariable(value="cusId") Integer cusId){
        //条件查询
        QueryWrapper<Contact> wrapper = new QueryWrapper<>();
        wrapper.eq("cus_id", cusId); //第一个参数是字段名

        Page<Contact> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        Page<Contact> contactPage = contactService.page(page, wrapper);
        return TableResult.ok("查询客户联系人成功", contactPage.getTotal(), contactPage.getRecords());
    }


    @PostMapping("/update")
    public TableResult updateCustomer(@RequestBody Contact contact){
        contactService.updateById(contact);
        return TableResult.ok("更新成功");
    }

    @PostMapping("/add")
    public TableResult addCustomer(@RequestBody Contact contact){
        contactService.save(contact);
        return TableResult.ok("新增成功");
    }

    @PostMapping("/delete")
    public TableResult deleteCustomer(@RequestBody Integer[] ids){
        contactService.removeBatchByIds(Arrays.asList(ids));
        return TableResult.ok("删除成功");
    }
}
