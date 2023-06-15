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
 * @since 2023-06-12
 */
@TableName("customer_loss")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "CustomerLoss对象", description = "")
public class CustomerLoss implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("流失预警ID，主键，自动递增")
    @TableId(value = "cl_id", type = IdType.AUTO)
    private Integer clId;

    @ApiModelProperty("客户ID")
    private Integer cusId;

    @ApiModelProperty("客户经理ID")
    private Integer suId;

    @ApiModelProperty("上次下单时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8") // 返回到前台
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 到后台，例如入参报文到后台
    private Date clOrderTime;

    @ApiModelProperty("暂缓流失措施")
    private String clPause;

    @ApiModelProperty("确认流失原因")
    private String clLossReason;

    @ApiModelProperty("确认流失时间")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8") // 返回到前台
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 到后台，例如入参报文到后台
    private Date clLossTime;

    @ApiModelProperty("状态。1-预警、2-暂缓、3-流失、4-挽回")
    private Integer clStatus;


}
