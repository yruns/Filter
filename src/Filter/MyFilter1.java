package Filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 *  自定义过滤器:
 *      完成请求的拦截以及资源的统一管理功能
 *      使用方式:
 *          定义普通java类实现Filter接口
 *          重写其中方法:
 *              init()  初始化
 *              doFilter  进行处理
 *              destroy  销毁
 *      多个过滤器同时起作用时, servlet会先依次经过所有过滤器.
 *      建议每个过滤器完成独立的功能, 不要将所有的逻辑处理放在一个过滤器中, 耦合性高, 不利于维护.
 *
 *      在过滤器的web.xml配置文件中, 可以指定过滤器过滤哪些请求:
 *          /* 匹配所有请求
 *          /*.do 匹配所有后缀为do的请求
 *          /filter.do 匹配请求为filter.do的请求
 *
 *     <filter>
 *         <filter-name>filter2</filter-name>   配置filter的别名
 *         <filter-class>Filter.MyFilter2</filter-class>    配置filter指定的类名
 *     </filter>
 *     <filter-mapping>
 *         <filter-name>filter2</filter-name>   配置filter的别名, 和name中的保持一致
 *         <url-pattern>/*.do</url-pattern>     表示要匹配的请求
 *     </filter-mapping>
 */

public class MyFilter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("第一个过滤器开始初始化...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("第一个过滤器初始化完成...");
        // 添加此语句后才能调用Servlet
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("第一个过滤器销毁...");
    }
}
