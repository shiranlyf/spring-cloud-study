package com.shiran.cloud;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 编写zuul-filter过滤器的配置
 * 在application启动类中添加@Bean注解
 * 
 * Zull filter与DebugFilter过滤器的源码解析
 * @author shiran 
 */
public class PreZuulFilter extends ZuulFilter{
	
	//进行过滤器日志打印
    private static final Logger  LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);
	
	//进行逻辑代码
	@Override
	public Object run() {
		//1.get a servlet context
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		//2.get request 
		String host = request.getRemoteHost();
	    
		///日志部分
		PreZuulFilter.LOGGER.info("请求的host:{}", host);
		
		return null;
	}

	//表示是否使用这个filter 为false的时候就不会进行日志打印  不会进行过滤
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	//这个表示的执行的顺序   数字越大越靠后
	@Override
	public int filterOrder() {
		// TODO AutoWired
		
		return 1;
	}

	//过滤类型  pre
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
