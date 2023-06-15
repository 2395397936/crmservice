package cn.edu.cqut.crmservice.service;

import cn.edu.cqut.crmservice.entity.SysUser;
import cn.edu.cqut.crmservice.util.TableResult;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author baomidou
 * @since 2023-06-11
 */
public interface ISysUserService extends IService<SysUser> {
    public TableResult login(SysUser user);
    public TableResult logout();
}
