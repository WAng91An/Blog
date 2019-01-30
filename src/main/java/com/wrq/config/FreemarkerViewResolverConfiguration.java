package com.wrq.config;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import freemarker.template.TemplateModel;

@Component
public class FreemarkerViewResolverConfiguration  implements  ApplicationContextAware, CommandLineRunner {
	
	private ApplicationContext context;

	@Autowired
	private FreeMarkerViewResolver resolver;

	//@PostConstruct
	public void init() {
		resolver.setViewClass(FreemarkerView.class);
		//freemarker的自定义标签标签注册，统一注册
		Map<String, TemplateModel> beans = (Map<String, TemplateModel>) context.getBeansOfType(TemplateModel.class);
		for (Entry<String, TemplateModel> entry : beans.entrySet()) {
			resolver.getAttributesMap().put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	@Override
	public void run(String... args) throws Exception {
		init();
	}
}