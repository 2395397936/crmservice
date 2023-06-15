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
 * @since 2023-06-09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("business_record")
@ApiModel(value = "BusinessRecord对象", description = "")
public class BusinessRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "br_id", type = IdType.AUTO)
    private Integer brId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8") // 返回到前台
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 到后台，例如入参报文到后台
    private Date brDate;

    private String brAddr;

    private String brDesc;

    private String brInfo;

    private Integer cusId;

    private String brSale;

}
