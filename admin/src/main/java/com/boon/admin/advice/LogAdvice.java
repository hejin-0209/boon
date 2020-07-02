package com.boon.admin.advice;

import com.boon.admin.annotation.LogAnnotation;
import com.boon.admin.service.LogService;
import com.boon.pojo.Logs;
import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 统一日志处理
 *
 */
@Aspect
@Component
public class LogAdvice {

	@Autowired
	private LogService logService;

	@Around(value = "@annotation(com.boon.admin.annotation.LogAnnotation)")
	public Object logSave(ProceedingJoinPoint joinPoint) throws Throwable {
		Logs logs = new Logs();
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		String module = null;
		LogAnnotation logAnnotation = methodSignature.getMethod().getDeclaredAnnotation(LogAnnotation.class);
		module = logAnnotation.module();
		if (StringUtils.isEmpty(module)) {
			ApiOperation apiOperation = methodSignature.getMethod().getDeclaredAnnotation(ApiOperation.class);
			if (apiOperation != null) {
				module = apiOperation.value();
			}
		}

		if (StringUtils.isEmpty(module)) {
			throw new RuntimeException("没有指定日志module");
		}
		logs.setModule(module);

		try {
			Object object = joinPoint.proceed();

			logs.setFlag(true);
			logService.save(logs);

			return object;
		} catch (Exception e) {
			logs.setFlag(false);
			logs.setRemark(e.getMessage());
			logService.save(logs);
			throw e;
		}

	}
}
