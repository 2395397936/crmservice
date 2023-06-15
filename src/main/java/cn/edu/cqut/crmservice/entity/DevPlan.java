package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2023-06-10
 */
@TableName("dev_plan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "DevPlan对象", description = "")
public class DevPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "dp_id", type = IdType.AUTO)
    private Integer dpId;

    @ApiModelProperty("销售机会编号")
    private Integer saleId;

    @ApiModelProperty("计划日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8") // 返回到前台
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 到后台，例如入参报文到后台
    private Date dpTime;

    @ApiModelProperty("计划内容")
    private String dpContent;

    @ApiModelProperty("执行日期")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8") // 返回到前台
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 到后台，例如入参报文到后台
    private Date dpExecutionTime;

    @ApiModelProperty("执行结果")
    private String dpExecutionResult;

    @ApiModelProperty("执行人")
    private String dpExecutor;
}
