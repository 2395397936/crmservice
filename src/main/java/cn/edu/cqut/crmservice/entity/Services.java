package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2023-06-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Services对象", description = "")
public class Services implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "services_id", type = IdType.AUTO)
    private Integer servicesId;

    @ApiModelProperty("服务类型：咨询、投诉、建议")
    private String servicesType;

    @ApiModelProperty("概要")
    private String servicesOutline;

    @ApiModelProperty("详细要求")
    private String servicesRequirement;

    @ApiModelProperty("客户编号")
    private Integer cusId;

    @ApiModelProperty("创建人：当前登录用户")
    private String servicesCreator;

    @ApiModelProperty("创建时间：当前系统时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8") // 返回到前台
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 到后台，例如入参报文到后台
    private Date servicesCtime;

    @ApiModelProperty("状态：新创建、已分配、已处理、已归档")
    private String servicesState;

    @ApiModelProperty("分配时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8") // 返回到前台
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 到后台，例如入参报文到后台
    private Date servicesAtime;

    @ApiModelProperty("处理人")
    private String servicesPerson;

    @ApiModelProperty("处理方法")
    private String servicesMethod;

    @ApiModelProperty("处理时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8") // 返回到前台
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 到后台，例如入参报文到后台
    private Date servicesPtime;

    @ApiModelProperty("客户反馈")
    private String servicesFeedback;

    @ApiModelProperty("客户满意度：12345")
    private Integer servicesSatisfaction;

    @ApiModelProperty("反馈时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8") // 返回到前台
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 到后台，例如入参报文到后台
    private Date servicesFtime;


}
