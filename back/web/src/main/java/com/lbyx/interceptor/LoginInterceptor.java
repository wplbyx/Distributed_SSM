package com.lbyx.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/12/12 0012.
 */
public class LoginInterceptor  implements HandlerInterceptor {

    /**
     * 在执行 Handler 之前执行该函数：
     * @param request
     * @param response
     * @param handler
     * @return: false: 不能通过拦截器，执行不了后面的 Handler
     *          true:  通过拦截器，放行，可以执行 Handler
     * @throws Exception
     *
     * 一般应用：
     *  1. 用户权限，身份验证
     *
     */
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
            throws Exception {
        // 1. 得到请求的 URL, 判断是否是公开地址（需要配置在配置文件了）
        // 2. 用户身份 是否存在于 session 里
        //     如果以上都没有通过，那就开始拦截
        // 3. 执行拦截，跳转到登录页面.

        return true;

    }

    /**
     * 在执行 Handler 返回 ModelAndView 之前执行该函数
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     *
     * 一般应用：
     *  1. 公用的信息的渲染
     *
     */
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView)
            throws Exception {

    }

    /**
     * 在 Handler 处理完成后执行该方法
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     *
     * 一般应用：
     *  1. 做系统的统一异常处理
     *  2. 方法执行的性能监控
     *  3. 统一记录系统的日志.
     *
     */
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex)
            throws Exception {

    }
}
