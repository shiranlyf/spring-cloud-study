package com.shiran.cloud.fallback;

import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class MyFallbackProvider implements ZuulFallbackProvider {

	
	/**
	 * -------zuul代理的微服务  -----
	 * zuul:
     *   routes:
     *      customers: /customers/**   这里进行返回一定是这个application.yml中的customers
	 */
	@Override
	public String getRoute() {
		return "microservice-provider-user";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			
			
/**************begin   这三个方法一起使用***********************/
			
		   //这里返回http的状态码
			@Override
			public HttpStatus getStatusCode() throws IOException {
//				return HttpStatus.OK;    //返回时200的状态码
				return HttpStatus.BAD_REQUEST;    // 这个返回的是500的状态码
			}

			@Override
			public int getRawStatusCode() throws IOException {
//				return 200;    ok  对应
				String nodejs = getRoute().toString();  //得到路由信息
				return HttpStatus.BAD_REQUEST.value();
			}

			@Override
			public String getStatusText() throws IOException {
//				return "OK";
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}
 /**************begin   这三个方法一起使用***********************/

			@Override
			public void close() {

			}

			/**
			 * 这个就是进行返回的内容
			 */
			@Override
			public InputStream getBody() throws IOException {
				//打印fallback的微服务信息
				return new ByteArrayInputStream(("fallback" + MyFallbackProvider.this.getRoute()).getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}
		};
	}

}
