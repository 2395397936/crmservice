package cn.edu.cqut.crmservice.controller;


import cn.edu.cqut.crmservice.entity.DevPlan;
import cn.edu.cqut.crmservice.entity.PageParams;
import cn.edu.cqut.crmservice.service.IDevPlanService;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2023-06-10
 */
@RestController
@RequestMapping("/devPlan")
public class DevPlanController {
    @Autowired
    IDevPlanService devPlanService;

    @PostMapping("/add")
    public TableResult addDevPlan(@RequestBody DevPlan devPlan){
        devPlanService.save(devPlan);
        return TableResult.ok("新增成功");
    }

    @PostMapping("/delete")
    public TableResult deleteService(@RequestBody Integer[] ids){
        devPlanService.removeBatchByIds(Arrays.asList(ids));
        return TableResult.ok("删除成功");
    }

    @PostMapping("/all/{saleId}")
    public TableResult getDevPlan(@RequestBody PageParams pageParams,@PathVariable(value="saleId")Integer saleId){
        QueryWrapper<DevPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sale_id",saleId);
        Page<DevPlan> devPlanPage = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        Page<DevPlan> page = devPlanService.page(devPlanPage,queryWrapper);//调用service层的list方法，返回数据表的所有数据
        return TableResult.ok("查询成功", page.getTotal(), page.getRecords());
    }


    @PostMapping("/update")
    public TableResult handleDevPlan(@RequestBody DevPlan devPlan){
        devPlanService.updateById(devPlan);
        return TableResult.ok("修改成功");
    }

    @PostMapping("/execute")
    public TableResult executeDevPlan(@RequestBody DevPlan devPlan){
        devPlan.setDpExecutor(SecurityContextHolder.getContext().getAuthentication().getName());
        devPlanService.updateById(devPlan);
        return TableResult.ok("修改成功");
    }



}
