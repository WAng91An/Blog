package com.wrq.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JsonUtil {
	

	public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static ObjectMapper objectMapper = new ObjectMapper();
	private static Logger log = LoggerFactory.getLogger(JsonUtil.class);
	static {
		// 对象的所有字段全部列入--vuejs
		objectMapper.setSerializationInclusion(Inclusion.ALWAYS);

		// 取消默认转换timestamps形式
		objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);

		// 忽略空Bean转json的错误
		objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);

		// 所有的日期格式都统一为以下的样式，即yyyy-MM-dd HH:mm:ss
		objectMapper.setDateFormat(new SimpleDateFormat(STANDARD_FORMAT));
		
		// 忽略 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static <T> String obj2String(T obj) {
		if (obj == null) {
			return null;
		}
		try {
			return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			log.warn("Parse Object to String error", e);
			return null;
		}
	}

	public static <T> String obj2StringPretty(T obj) {
		if (obj == null) {
			return null;
		}
		try {
			return obj instanceof String ? (String) obj
					: objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (Exception e) {
			log.warn("Parse Object to String error", e);
			return null;
		}
	}

	public static <T> T string2Obj(String str, Class<T> clazz) {
		if (StringUtils.isEmpty(str) || clazz == null) {
			return null;
		}

		try {
			return clazz.equals(String.class) ? (T) str : objectMapper.readValue(str, clazz);
		} catch (Exception e) {
			log.warn("Parse String to Object error", e);
			return null;
		}
	}

	
	
	//List<Map<String,Object>> maps =  JSONUtils.string2Obj([{},{},{}]);
	//List<User> users =  JSONUtils.string2Obj([{},{},{}],User.class);

	public static <T> T string2Obj(String str, Class<?> collectionClass, Class<?>... elementClasses) {
		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
		try {
			return objectMapper.readValue(str, javaType);
		} catch (Exception e) {
			log.warn("Parse String to Object error", e);
			return null;
		}
	}
	
	//废弃
	private static <T> T string2Obj(String str, TypeReference<T> typeReference) {
		if (StringUtils.isEmpty(str) || typeReference == null) {
			return null;
		}
		try {
			return (T) (typeReference.getType().equals(String.class) ? str
					: objectMapper.readValue(str, typeReference));
		} catch (Exception e) {
			log.warn("Parse String to Object error", e);
			return null;
		}
	}

//	public static void main(String[] args) {
//
//		 User user = new User();
//		 user.setId(2L);
//		 user.setAccount("415454@qq.com");
//		 user.setCreateTime(new Date());
//		 String userJsonPretty = JsonUtil.obj2StringPretty(user);//A
//		 log.info("userJson:{}",userJsonPretty);
//		 String userJson= JsonUtil.obj2String(user);//B
//		 log.info("userJson:{}",userJson);
//
//
//		  //String json = "{\"name\":\"mofeng\",\"color\":\"blue\",\"id\":666}";
//		  //User user2 = JsonUtil.string2Obj(json, User.class);
//		  //System.out.println(user2.getId());
//
//
//	}

}