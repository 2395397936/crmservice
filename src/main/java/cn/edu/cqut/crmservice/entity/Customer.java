package cn.edu.cqut.crmservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2023-06-06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cus_id", type = IdType.AUTO)
    private Integer cusId;

    private String cusName;

    private String cusRegion;

    private String cusIndustry;

    private String cusLevel;

    private Integer cusRate;

    private Integer cusCredit;

    private String cusAddr;

    private String cusPostcode;

    private String cusPhone;

    private String cusUrl;

    private String cusFax;

    private Integer cusStatus;
}
