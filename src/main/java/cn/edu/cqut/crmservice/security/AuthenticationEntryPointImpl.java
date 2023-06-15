package cn.edu.cqut.crmservice.security;

import cn.edu.cqut.crmservice.util.TableResult;
import cn.edu.cqut.crmservice.util.WebUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 三更  B站： https://space.bilibili.com/663528522
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        TableResult result = TableResult.error(HttpStatus.UNAUTHORIZED.value(), "用户名或密码错误");
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response,json);
    }
}

