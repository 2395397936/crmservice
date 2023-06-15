package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author baomidou
 * @since 2023-06-11
 */
@TableName("sys_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "SysUser对象")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户编号，主键，自动递增")
    @TableId(value = "su_id", type = IdType.AUTO)
    private Integer suId;

    @ApiModelProperty("用户名")
    private String suName;

    @ApiModelProperty("用户密码")
    private String suPwd;

    @ApiModelProperty("用户角色")
    private String suRole;

}
