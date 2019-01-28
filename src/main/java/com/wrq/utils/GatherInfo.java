/**
 * TODO濡沫系统平台<br/>
 * com.rumo.util<br/>
 * GatherInfo.java<br/>
 *  创建人:mofeng <br/>
 * 时间：2018年11月11日-下午8:39:00 <br/>
 * 2018濡沫公司-版权所有<br/>
 */
package com.wrq.utils;

import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GatherInfo {

	
	public static Set<String> getLinks(String link){
		try {
			Set<String> links = new HashSet<>();
			Document document = Jsoup.parse(new URL(link),10000);
			Elements elements = document.getElementById("posts").getElementsByTag("a");
			for (Element element : elements) {
				links.add(element.attr("href"));
			}
			return links;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void saveBlogs(String url) {
		try {
			Document document = Jsoup.parse(new URL(url), 3000);
			String img = document.getElementsByClass("post-cover").first().child(0).attr("src");
			String title = document.getElementsByClass("post-tit").eq(0).text();
			String content = document.getElementsByClass("post-content").eq(0).html();
			System.out.println(img);
			System.out.println(title);
			System.out.println(content);
			System.out.println("========================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Set<String> links = getLinks("https://aotu.io/index.html");
		for (String string : links) {
			saveBlogs("https://aotu.io"+string);
		}
		
	}
}
