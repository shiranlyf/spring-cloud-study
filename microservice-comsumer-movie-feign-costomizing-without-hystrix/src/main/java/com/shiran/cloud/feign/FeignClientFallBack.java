package com.shiran.cloud.feign;

import org.springframework.stereotype.Component;

/**
 * FeignClient2 of FallBack
 * @author shiran
 *
 */
@Component
public class FeignClientFallBack implements FeignClient2{

	@Override
	public String findServiceInfoByServiceName(String serviceName) {
		// TODO Auto-generated method stub
		return "haha";
	}

}
