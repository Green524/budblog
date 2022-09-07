package com.chenum.config.interceptor;

import com.chenum.annotation.ApiPass;
import com.chenum.response.WrapMapper;
import com.chenum.response.Wrapper;
import com.chenum.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
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

    private static final Wrapper error = WrapMapper.denied();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入拦截器");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        ApiPass apiPass = method.getAnnotation(ApiPass.class);
        if (Objects.isNull(apiPass)){
            String accessToken = request.getHeader("ch_access_token");
            log.info("调用{}接口时被拦截",method.getName());
            if (!StringUtils.hasText(accessToken)){
                response.setCharacterEncoding("UTF-8");
                response.setContentType("Content-Type:application/json");
                response.getWriter().println(JsonUtil.toJsonString(error,true));
                return false;
            }
        }
        return true;
    }
}
