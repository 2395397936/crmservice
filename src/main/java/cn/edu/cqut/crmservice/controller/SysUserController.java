package cn.edu.cqut.crmservice.controller;

import cn.edu.cqut.crmservice.entity.Customer;
import cn.edu.cqut.crmservice.entity.DevPlan;
import cn.edu.cqut.crmservice.entity.PageParams;
import cn.edu.cqut.crmservice.entity.SysUser;
import cn.edu.cqut.crmservice.service.ISysUserService;
import cn.edu.cqut.crmservice.util.JWTUtil;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author CQUT
 * @since 2023-06-10
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    PasswordEncoder encoder;


    @PostMapping("/login")
    public TableResult login(@RequestBody SysUser sysUser) {
        return sysUserService.login(sysUser);
    }

    @PostMapping("/logout")
    public TableResult logout() {
        return sysUserService.logout();
    }

    @PostMapping("/register")
    public TableResult register(@RequestBody SysUser user) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("su_name",user.getSuName());
        if (sysUserService.getOne(queryWrapper)!=null){
            return TableResult.error(-200,"用户名已占用");
        }
        user.setSuPwd(encoder.encode(user.getSuPwd()));
        sysUserService.save(user);
        return TableResult.ok("注册成功");
    }

    @GetMapping("/sales")
    public TableResult getSales() {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("su_role","SALES");
        List<SysUser> list = sysUserService.list(queryWrapper);
        return TableResult.ok("查询成功", list);
    }

    @PreAuthorize("hasAnyAuthority('MANAGER','ADMIN')")
    @PostMapping("/all")
    public TableResult getSysUserList(@RequestBody PageParams pageParams){
        Page<SysUser> customerPage = new Page<>(pageParams.getPage(),pageParams.getPageSize());
        Page<SysUser> page = sysUserService.page(customerPage);//调用service层的list方法，返回数据表的所有数据
        return TableResult.ok("查询成功", page.getTotal(), page.getRecords());
    }

    @PreAuthorize("hasAnyAuthority('MANAGER','ADMIN')")
    @PostMapping("/update")
    public TableResult updateUser(@RequestBody SysUser sysUser){
        sysUserService.updateById(sysUser);
        return TableResult.ok("修改成功");
    }

}
