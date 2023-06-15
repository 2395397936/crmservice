package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
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
@TableName("sale_chance")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "SaleChance对象", description = "")
public class SaleChance implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    @TableId(value = "sale_id", type = IdType.AUTO)
    private Integer saleId;

    @ApiModelProperty("客户名称")
    private String saleName;

    @ApiModelProperty("机会来源：促销、广告、搜索引擎、线上咨询、电话咨询、邮件咨询、客户介绍")
    private String saleChanceSource;

    @ApiModelProperty("联系人")
    private String saleContact;

    @ApiModelProperty("联系电话")
    private String salePhone;

    @ApiModelProperty("成功几率")
    private Integer saleChance;

    @ApiModelProperty("概要")
    private String saleDes;

    @ApiModelProperty("机会描述")
    private String saleChanceDes;

    @ApiModelProperty("创建人")
    private String saleCreator;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8") // 返回到前台
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 到后台，例如入参报文到后台
    private Date saleCreatTime;

    @ApiModelProperty("指派给")
    private String saleAssignedTo;

    @ApiModelProperty("指派时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8") // 返回到前台
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 到后台，例如入参报文到后台
    private Date saleAssignedTime;

    @ApiModelProperty("销售机会的状态为：未分配、已分配、开发成功、开发失败")
    private String saleState;


}
