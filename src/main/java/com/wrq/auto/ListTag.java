package com.wrq.auto;

import java.util.List;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class ListTag implements TemplateMethodModelEx {
	// 这里的长度计算，以汉字为标准，两个字母作为一个字符
	@SuppressWarnings("rawtypes")
	public Object exec(List args) throws TemplateModelException {
		if (args.size() > 2)
			throw new TemplateModelException("Wrong arguments!");

		String model = String.valueOf(args.get(0));
		String template = String.valueOf(args.get(1));
		return  "<#list  pages.list as "+model+">\n" + 
				"<#if "+model+"??>\n" 
					+ template+
				"\n</#if>\n" + 
				"</#list>";
	}

}
