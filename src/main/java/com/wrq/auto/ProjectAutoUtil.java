package com.wrq.auto;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * generatConfig
 * 自动构建类
 * ProjectAutoUtil<br/>
 * 创建人:mofeng<br/>
 * 时间：2018年9月25日-下午10:21:55 <br/>
 * @version 1.0.0<br/>
 * 
 */
public class ProjectAutoUtil {

	
	//定义模块
	private static	String beanModel = "User";
	private static	String tablename = "user";
	private static	String model = beanModel.toLowerCase();
	private static String author = "王瑞乾";
	private static String description = "用户";
	private static String phone = "17854176692";
	private static String datetime = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
	//获取当前项目路径
	private static String projectPath = System.getProperty("user.dir");


	/**
	 * 读取数据的字段列，
	 * 方法名：loadTable<br/>
	 */
	public static List<Map<String,String>> loadTable() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/blog?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull", "root","admin");
			 Statement st = connection.createStatement();
			 String sql = "SELECT * FROM "+tablename;
			 ResultSet rs = st.executeQuery(sql);
			 ResultSetMetaData rsmd = rs.getMetaData();
			 List<Map<String,String>> maps = Lists.newArrayList();
			 for( int i=1; i<=rsmd.getColumnCount(); i++ ){
				 String field = rsmd.getColumnName(i);
				 int type =  rsmd.getColumnType(i) ;
				 String strtype = JDBCTypesUtils.jdbcTypeToJavaType(type).getName();
				 Map<String,String> map = new HashMap<>();
				 map.put("column", field);//数据库原有的名字
				 map.put("name", Tool.lineToHump(field));//小写名字，
				 map.put("hname", Tool.HlineToHump(field));//大写的名字，服务于set get
				 map.put("type", strtype);//字段对应的java类型
				 map.put("dtype", JDBCTypesUtils.getJdbcName(type));//字段对应的java类型
				 map.put("ctype", strtype.substring(strtype.lastIndexOf(".")+1));//没有包的类型名字
				 maps.add(map);
			 }
			 rs.close();
			 st.close();
			 connection.close();
			 return maps;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	public static void loadTemplate(List<Map<String,String>> maps,String packagename,String filename,String template)  {
		try {

			//判断你的模板是否已经生成，如果要做提示？
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
			// 指定模板文件从何处加载的数据源，这里设置成一个文件目录。
			cfg.setDirectoryForTemplateLoading(new File(projectPath+"/templates"));
			// 指定模板如何检索数据模型，这是一个高级的主题了… // 但先可以这么来用：
			cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_28));
			// 创建根哈希表
			Map root = new HashMap();
			// 在根中放入字符串"user"
			root.put("tablename", tablename);
			root.put("author", author);
			root.put("beanModel", beanModel);
			root.put("model", model);
			root.put("phone", phone);
			root.put("package","com.wrq");
			root.put("basePath", "${basePath}");
			root.put("datetime", datetime);
			root.put("description", description);
			root.put("fields",maps);
			root.put("kuohao", new AddKuohu());
			root.put("listtag", new ListTag());
			root.put("Include", new IncludeTagMethod());

			Template temp = cfg.getTemplate(template);
			File rootPath = new File(projectPath,packagename);
			if(!rootPath.exists())rootPath.mkdirs();
			File pojo = new File(rootPath,filename);
			Writer out = new OutputStreamWriter(new FileOutputStream(pojo),"utf-8"); 
			temp.process(root, out); 
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}
	
	public static void main(String[] args) throws IOException {
		List<Map<String, String>> maps = loadTable() ;
		
		String pojo = "src/main/java/com/wrq/pojo";
		loadTemplate(maps,pojo,beanModel+".java","pojo.tml");
		
		String mapper = "src/main/java/com/wrq/mapper";
		loadTemplate(maps,mapper,beanModel+"Mapper.java","mapper.tml");
		
		String mapperxml = "src/main/resources/mappers";
		loadTemplate(maps,mapperxml,beanModel+"Mapper.xml","mapperxml.tml");
		
		//service
		String service = "src/main/java/com/wrq/service/"+model;
		loadTemplate(maps,service,"I"+beanModel+"Service.java","service.tml");
		String serviceimpl = "src/main/java/com/wrq/service/"+model;
		loadTemplate(maps,serviceimpl,beanModel+"ServiceImpl.java","serviceImpl.tml");
		
		//vo
		String vo = "src/main/java/com/wrq/vo";
		loadTemplate(maps,vo,beanModel+"Vo.java","vo.tml");
		
		//controller
		String controller = "src/main/java/com/wrq/controller/"+model;
		loadTemplate(maps,controller,beanModel+"Controller.java","controller.tml");

//		//page
//		String pageindex = "src/main/resources/templates/"+model;
//		loadTemplate(maps,pageindex,"index.html","index.tml");
//
//		//template
//		String template = "src/main/resources/templates/"+model;
//		loadTemplate(maps,template,"template.html","template.tml");
//
//		//tempjslate
//		String tempjslate = "src/main/resources/static/js/main/";
//		loadTemplate(maps,tempjslate,model+".js","js.tml");
//
//		//listtag
//		String listtag = "src/main/java/com/wrq/tag/"+model;
//		loadTemplate(maps,listtag,beanModel+"ListTag.java","listtag.tml");
//
//		//benatag
//		String benatag = "src/main/java/com/wrq/tag/"+model;
//		loadTemplate(maps,benatag,beanModel+"BeanTag.java","beantag.tml");
		
	}
}

//统计项目有多少个java,有多少个资源文件，
//如何自己去写自动构建
//maven插件来完成



