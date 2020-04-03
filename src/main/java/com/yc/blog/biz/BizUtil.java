package com.yc.blog.biz;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import com.yc.blog.bean.Article;

/**
 * @author Hooy 工具类
 */
@Component
public class BizUtil {
	/*
	 * 频道点击排行展示数量
	 */
	public static final int HOTRANKING = 5;
	/*
	 * 文章归档展示数量
	 */
	public static final int TIMECLASSIFICATION = 8;

	/*
	 * content文字内容html标签清洗方法 参数：需要被清洗文章(Article)组(List)
	 */
	// 控制显示content文本长度
	private static final int CONTENT = 200;

	public List<Article> cleanHTML(List<Article> originalList) {
		for (Article temp : originalList) {
			String tempStr = Jsoup.parse(temp.getContent()).text();
			// 过长的文本被省略
			int tempStrLen = tempStr.length();
			if (tempStrLen > CONTENT) {
				tempStr = tempStr.substring(0, CONTENT) + "...";
			}
			temp.setContent(tempStr);
		}
		return originalList;
	}

	/*
	 * 获取页码 参数：1.当前页码(currentPage) 2.记录总条数(cateid)
	 */
	// 每页多少条文章
	public static final int ART_NUMBER = 5;

	public Map<String, Integer> getPageNumber(int currentPage, int artcleSize) {
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		int allPage = 0;
		if ((artcleSize % ART_NUMBER) == 0) {
			if (artcleSize == 0) {
				allPage = 1;
			} else {
				allPage = artcleSize / ART_NUMBER;
			}
		} else {
			allPage = artcleSize / ART_NUMBER + 1;
		}
		currentPage = currentPage > 0 && currentPage < allPage + 1 ? currentPage : 1;
		int prevPage = currentPage - 1 <= 1 ? 1 : (currentPage > allPage ? 1 : currentPage - 1);
		int nextPage = currentPage + 1 >= allPage ? allPage : (currentPage < 1 ? 1 : currentPage + 1);
		pageMap.put("artcleSize", artcleSize);
		pageMap.put("allPage", allPage);
		pageMap.put("prevPage", prevPage);
		pageMap.put("nextPage", nextPage);
		pageMap.put("currentPage", currentPage);
		return pageMap;
	}

	/*
	 * 日期转换处理 String->Date,nextDate
	 */
	//时间跨越 默认24h
	public static final long LONGTIME = 24 * 60 * 60 * 1000;

	public List<Date> transTime(String time) {
		List<Date> timeDateList = new ArrayList<Date>();
		String[] timesplit = time.split("-");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Integer.parseInt(timesplit[0]), Integer.parseInt(timesplit[1]) - 1, Integer.parseInt(timesplit[2]),
				0, 0, 0);
		long nextDayTime = calendar.getTimeInMillis() + LONGTIME;
		timeDateList.add(calendar.getTime());
		timeDateList.add(new Date(nextDayTime));
		return timeDateList;
	}

}
