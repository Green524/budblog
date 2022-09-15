package com.chenum.config.interceptor;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.chenum.annotation.ApiPass;
import com.chenum.dubbo.service.IUserService;
import com.chenum.response.WrapMapper;
import com.chenum.response.Wrapper;
import com.chenum.util.JWTUtil;
import com.chenum.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.pdfbox.pdmodel.font.encoding.StandardEncoding;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Configuration
@Slf4j
public class ApiInterceptor implements HandlerInterceptor {

    @DubboReference
    private IUserService iUserService;
    @NacosValue(value = "${secret:cpq}",autoRefreshed = true)
    private String secret;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入拦截器");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        ApiPass apiPass = method.getAnnotation(ApiPass.class);
        if (Objects.isNull(apiPass)){
            String accessToken = request.getHeader("ch_access_token");
            log.warn("调用{}接口时被拦截",method.getName());
            if (StringUtils.hasText(accessToken)){
                Wrapper<String> wrap = iUserService.authVerify(secret,accessToken);
                if (wrap.success() && wrap.data().equals("true")){
                    return true;
                }
                response.setStatus(403);
                return false;
            }
            response.setStatus(403);
            return false;
        }
        return true;
    }
}
