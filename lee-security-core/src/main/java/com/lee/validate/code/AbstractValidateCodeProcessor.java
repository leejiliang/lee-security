package com.lee.validate.code;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * @program: lee-security
 * @description: 初步实现
 * @author: Jiliang.Lee
 * @create: 2018-10-26 20:41
 **/
public abstract class AbstractValidateCodeProcessor<T> implements ValidateCodeProcessor {

	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Map<String, ValidateCodeGenerate> validateCodeGenerateMap;

	private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
	@Override
	public void create(ServletWebRequest request) throws Exception {
		T generate = generate(request);
		save(request, generate);
		send(request, generate);
	}

	private T generate(ServletWebRequest request) {
		String type = getProcessorType(request);
		log.info("type: "+type);

		ValidateCodeGenerate validateCodeGenerate = validateCodeGenerateMap.get(type+"CodeGenerate");
		return (T)validateCodeGenerate.generate(request);
	}


	private String getProcessorType(ServletWebRequest request) {
		return StringUtils.substringAfter(request.getRequest().getRequestURI(), "/code/");
	}

	private void save(ServletWebRequest request, T validateCode) {
		sessionStrategy.setAttribute(request, SESSION_KEY_PREFIX + getProcessorType(request).toUpperCase(),validateCode);
	}

	public abstract void send(ServletWebRequest request, T validateCode) throws Exception;
}
