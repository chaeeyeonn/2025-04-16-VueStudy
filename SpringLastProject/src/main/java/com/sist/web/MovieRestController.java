package com.sist.web;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.vo.*;
import com.sist.manager.*;
/*
 *   1. JSON �Ľ� 
 *   2. XML �Ľ� 
 *   Open Api => JSON / XML => ���̽� 
 *   
 *   ������ 
 *     ������ 
 *      1) ����ȭ�� ������ : �����ͺ��̽� 
 *      2) ������ȭ ������ : ���� => JSON / XML / HTML
 *      3) ������ȭ ������ : Ʈ���� / ���̽��� 
 *         ---------- ����ȭ ������ ��ȯ 
 *                    --------- �ð�ȭ => ���� (�ӽŷ���,������)
 *                                     ----------------
 *                                     | AI
 *         ���� ���� / ����ö / ���� ���� = ���� ���� 
 *         ���̽� => ������ / �Ǵٽ� / MatPlotLib 
 *                              �ú� 
 *         --------------------------------
 */
@RestController
/*
 *   {  "kind": "youtube#searchListResponse",  
 *   "etag": "Ogeg0hutjXqNkqn2gp8PYksxXDQ",  
 *   "nextPageToken": "CBkQAA",  
 *   "regionCode": "KR",  
 *   "pageInfo": {    "totalResults": 1000000,    
 *   "resultsPerPage": 25  },  
 *   "items": [    
 *   {      "kind": "youtube#searchResult",      
 *   "etag": "aBLTYrW_Arrt54Xmig6jjAFaVog",      
 *   "id": {        "kind": "youtube#video",        
 *   "videoId": "H141xYAOZbQ"      },      
 *   "snippet": {        "publishedAt": 
 *   "2025-02-15T14:07:32Z",        
 *   "channelId": "UChtMCwrP0ClxDqMjQFjbH3A",       
 *    "title": "�λ� ����鸸 �ƴ� �λ꿩�� ����!",        
 *    "description": "",        
 *    "thumbnails": {          "default": { 
 *    
 *               "url": "https://i.ytimg.com/vi/H141xYAOZbQ/default.jpg",            "width": 120,            "height": 90          },          "medium": {            "url": "https://i.ytimg.com/vi/H141xYAOZbQ/mqdefault.jpg"
 */
public class MovieRestController {
   @Autowired
   private YoutubeManager ym;
   // http://localhost:8080/web/movie/find_vue.do?fd=%EB%B6%80%EC%82%B0%EC%97%AC%ED%96%89
   @GetMapping("movie/find_vue.do")
   public Map movie_find(String fd)
   {
	   Map map=new HashMap();
	   // ������ ���� / ������ Ű 
	   try
	   {
		   String json=ym.youtubeJsonData(fd);
		   //System.out.println(json);
		   JSONParser jp=new JSONParser();
		   // { => JSONObject , [ => JSONArray
		   JSONObject root=(JSONObject)jp.parse(json);
		   JSONArray items=(JSONArray)root.get("items");
		   List<MovieVO> list=
				     new ArrayList<MovieVO>();
		   for(int i=0;i<items.size();i++)
		   {
			   JSONObject obj=(JSONObject)items.get(i);
			   MovieVO vo=new MovieVO();
			   JSONObject id=(JSONObject)obj.get("id");
			   String key=(String)id.get("videoId");
			   JSONObject sni=(JSONObject)obj.get("snippet");
			   String title=(String)sni.get("title");
			   
			   vo.setTitle(title);
			   vo.setVideoId(key);
			   list.add(vo);
			   
		   }
		   map.put("list", list);
	   }catch(Exception ex){}
	   return map;
   }
}