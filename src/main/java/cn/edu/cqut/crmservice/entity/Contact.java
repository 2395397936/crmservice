package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2023-06-08
 */
@ApiModel(value = "Contact对象", description = "")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("联系人编号")
    @TableId(value = "con_id", type = IdType.AUTO)
    private Integer conId;

    @ApiModelProperty("联系人姓名")
    private String conName;

    @ApiModelProperty("联系人性别：男、女")
    private String conSex;

    @ApiModelProperty("联系人职位")
    private String conJob;

    @ApiModelProperty("联系人办公电话")
    private String conTel;

    @ApiModelProperty("联系人手机号码")
    private String conPhone;

    @ApiModelProperty("联系人备注")
    private String conDesc;

    @ApiModelProperty("客户编号")
    private Integer cusId;


}
