package com.wrq.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wrq.utils.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

/**
 * 在freemarker上通过 ${basePath}来获取： localhost:8080
 */
@Slf4j
public class FreemarkerView extends FreeMarkerView {

	@Override
	protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
		String base = RequestUtil.getBasePath(request);
		log.info("RequestUtil工具类获得的Path为：" +base );
		// 如果你要给freemarker的模板定义一些常量可以在这里来
		model.put("basePath", base);
		super.exposeHelpers(model, request);
	}
}
