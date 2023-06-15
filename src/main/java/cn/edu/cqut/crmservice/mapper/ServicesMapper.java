package cn.edu.cqut.crmservice.mapper;

import cn.edu.cqut.crmservice.entity.Report;
import cn.edu.cqut.crmservice.entity.Services;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2023-06-08
 */
public interface ServicesMapper extends BaseMapper<Services> {
    @Select("select count(*) value, services_type item " +
            "from services " +
            "GROUP BY services_type ")

    List<Report> getCustomerServices();
@Select("select count(*)  value ,s.su_name  item \n" +
        "        from sys_user s INNER JOIN customer_loss c\n" +
        "        on s.su_id = c.su_id    \n" +
        "\t\t\t\tand  c.cl_status=3\n" +
        "        GROUP BY s.su_name \n")
    List<Report> getCustomerLoss();
}
