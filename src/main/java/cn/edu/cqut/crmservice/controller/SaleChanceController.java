package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.*;
import cn.edu.cqut.crmservice.service.IDevPlanService;
import cn.edu.cqut.crmservice.service.ISaleChanceService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-06-10
 */
@RestController
@RequestMapping("/saleChance")
public class SaleChanceController {
    @Autowired
    ISaleChanceService saleChanceService;
    @Autowired
    IDevPlanService devPlanService;

    @PostMapping("/add")
    public TableResult addSaleChance(@RequestBody SaleChance saleChance){
        saleChance.setSaleState("未分配");
        saleChance.setSaleCreator(SecurityContextHolder.getContext().getAuthentication().getName());
        saleChanceService.save(saleChance);
        return TableResult.ok("新增成功");
    }

    @PostMapping("/all")
    public TableResult getSaleChanceList(@RequestBody PageParams pageParams){
        Page<SaleChance> saleChancePage = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        Page<SaleChance> page = saleChanceService.page(saleChancePage);
        return TableResult.ok("查询成功", page.getTotal(), page.getRecords());
    }



    @PostMapping("/all/new")
    public TableResult getAssignSaleChanceList(@RequestBody PageParams pageParams){
        QueryWrapper<SaleChance> wrapper = new QueryWrapper<>();
        wrapper.eq("sale_state", "已分配"); //第一个参数是字段名
        Page<SaleChance> saleChancePage = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        Page<SaleChance> page = saleChanceService.page(saleChancePage,wrapper);
        return TableResult.ok("查询成功", page.getTotal(), page.getRecords());
    }


    @PostMapping("/assign")
    public TableResult assignSaleChance(@RequestBody SaleChance saleChance){
        saleChance.setSaleAssignedTime(new Date());
        saleChance.setSaleState("已分配");
        saleChanceService.updateById(saleChance);
        return TableResult.ok("更新成功");
    }

    @PostMapping("/update")
    public TableResult updateSaleChance(@RequestBody SaleChance saleChance){
        saleChanceService.updateById(saleChance);
        return TableResult.ok("更新成功");
    }

    @PostMapping("/delete")
    public TableResult deleteSaleChance(@RequestBody Integer[] ids){
        saleChanceService.removeBatchByIds(Arrays.asList(ids));
        devPlanService.deleteAll(ids);
        return TableResult.ok("删除成功");
    }

    @PostMapping("/result")
    public TableResult resultDevPlan(@RequestBody SaleChance saleChance){
        saleChanceService.updateById(saleChance);

        if (saleChance.getSaleState().equals("开发成功")){
            saleChanceService.success(saleChance);
        }
        saleChanceService.updateById(saleChance);

        return TableResult.ok("修改成功");
    }

}
