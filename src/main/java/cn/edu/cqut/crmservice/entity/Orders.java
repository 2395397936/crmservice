package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
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
@ApiModel(value = "Orders对象", description = "")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单编号，主键，自动递增")
    @TableId(value = "odr_id", type = IdType.AUTO)
    private Integer odrId;

    @ApiModelProperty("订单日期")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8") // 返回到前台
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 到后台，例如入参报文到后台
    private Date odrTime;

    @ApiModelProperty("订单金额")
    private BigDecimal odrAmount;

    @ApiModelProperty("送货地址")
    private String odrShipto;

    @ApiModelProperty("订单状态。1-未付款、2-已付款、3-已发货、4-已收货、5-已退货")
    private Integer odrStatus;

    @ApiModelProperty("客户编号")
    private Integer cusId;

}
