package cn.edu.cqut.crmservice.controller;
import cn.edu.cqut.crmservice.service.IOrdersService;


import cn.edu.cqut.crmservice.entity.Report;
import cn.edu.cqut.crmservice.entity.ReportResult;
import cn.edu.cqut.crmservice.service.CustomerService;

import cn.edu.cqut.crmservice.service.ServicesService;
import cn.edu.cqut.crmservice.util.TableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@RequestMapping("/report")
@PreAuthorize("hasAnyAuthority('MANAGER','ADMIN')")
public class ReportController {


    @Autowired
    private CustomerService customerService;
    @Autowired
    private ServicesService servicesService;

    @GetMapping("/getCustomerCountByRegion")
    public ReportResult getCustomerCountByRegion(){
        List<Report> reports = customerService.getCustomerCountByRegion();
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return ReportResult.ok(items, values);
    }

    @GetMapping("/attribute")
    public ReportResult getCustomerAttribute(){
        List<Report> reports = customerService.getCustomerAttribute();
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return ReportResult.ok(items, values);
    }

    @GetMapping("/attribute/{cusId}")
    public ReportResult getCustomerAttributeByCusId(@PathVariable(value = "cusId") Integer cusId){
        List<Report> reports = customerService.getCustomerAttributeByCusId(cusId);
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return ReportResult.ok(items, values);
    }

    @GetMapping("/rate")
    public ReportResult getCustomerRate(){
        List<Report> reports = customerService.getCustomerRate();
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return ReportResult.ok(items, values);
    }

    @GetMapping("/credit")
    public ReportResult getCustomerCredit(){
        List<Report> reports = customerService.getCustomerCredit();
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return ReportResult.ok(items, values);
    }

    @GetMapping("/services")
    public ReportResult getCustomerServices(){
        List<Report> reports = servicesService.getCustomerServices();
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return ReportResult.ok(items, values);
    }

    @GetMapping("/loss")
    public ReportResult getCustomerLoss(){
        List<Report> reports = servicesService.getCustomerLoss();
        List<String> items = new ArrayList<>();
        List<Long> values = new ArrayList<>();
        for (Report report : reports) {
            items.add(report.getItem());
            values.add(report.getValue());
        }
        return ReportResult.ok(items, values);
    }


}
