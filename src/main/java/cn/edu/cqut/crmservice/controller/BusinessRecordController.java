package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.BusinessRecord;
import cn.edu.cqut.crmservice.entity.Contact;
import cn.edu.cqut.crmservice.entity.PageParams;
import cn.edu.cqut.crmservice.service.BusinessRecordService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-06-09
 */
@RestController
@RequestMapping("/businessRecord")
public class BusinessRecordController {
    @Autowired
    BusinessRecordService businessRecordService;

    @PostMapping("/getPage/{cusId}")
    public TableResult getContactPage(@RequestBody PageParams pageParams, @PathVariable(value="cusId") Integer cusId){
        //条件查询
        QueryWrapper<BusinessRecord> wrapper = new QueryWrapper<>();
        wrapper.eq("cus_id", cusId); //第一个参数是字段名

        Page<BusinessRecord> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        Page<BusinessRecord> contactPage = businessRecordService.page(page, wrapper);
        return TableResult.ok("查询客户联系人成功", contactPage.getTotal(), contactPage.getRecords());
    }


    @PostMapping("/update")
    public TableResult updateCustomer(@RequestBody BusinessRecord businessRecord){
        businessRecordService.updateById(businessRecord);
        return TableResult.ok("更新成功");
    }

    @PostMapping("/add")
    public TableResult addCustomer(@RequestBody BusinessRecord businessRecord){
        businessRecord.setBrSale(SecurityContextHolder.getContext().getAuthentication().getName());
        businessRecordService.save(businessRecord);
        return TableResult.ok("新增成功");
    }

    @PostMapping("/delete")
    public TableResult deleteCustomer(@RequestBody Integer[] ids){
        businessRecordService.removeBatchByIds(Arrays.asList(ids));
        return TableResult.ok("删除成功");
    }
}
