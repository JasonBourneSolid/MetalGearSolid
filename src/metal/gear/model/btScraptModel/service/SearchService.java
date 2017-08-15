package metal.gear.model.btScraptModel.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import metal.gear.model.btScraptModel.mapper.KeyWordMapper;
import metal.gear.model.btScraptModel.mapper.RubbishMapper;
import metal.gear.model.btScraptModel.mapper.TorrentMapper;
import metal.gear.model.btScraptModel.vo.KeyWord;
import metal.gear.model.btScraptModel.vo.LinkTypeData;
import metal.gear.model.btScraptModel.vo.Rule;
import metal.gear.util.TextUtil;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SearchService {
	
	@Autowired
	TorrentMapper torrent;
	@Autowired
	RubbishMapper rubbish;
	@Autowired
	KeyWordMapper keywordMapper;
	
	public Map<String, Object> loadShowPageData() 
	{
		Map<String,Object> resultMap  =new  HashMap<String, Object>();
		resultMap.put("torrents", torrent.list());
		return resultMap;
	}
	
	/**
	 * 获取HTML页面
	 * */
	public   Document extract(Rule rule)
	{
		Document doc = null;
		try
		{
			/**
			 * 解析rule
			 */
			String url = rule.getUrl();
			String[] params = rule.getParams();
			String[] values = rule.getValues();
			int requestType = rule.getRequestMoethod();

			Connection conn = Jsoup.connect(url);
			// 模仿浏览器请求
			conn.userAgent("Chrome");
			if (params != null)
			{
				for (int i = 0; i < params.length; i++)
				{
					conn.data(params[i], values[i]);
				}
			}
			// 设置请求类型
			switch (requestType)
			{
			case Rule.GET:
				doc = conn.timeout(100000).get();
				break;
			case Rule.POST:
				doc = conn.timeout(100000).post();
				break;
			}
		} catch (IOException e){
			e.printStackTrace();
		}

		return doc;
	}

	/**获取关键字*/
	public void collectKeyWord(Rule rule) {
		/**等待被爬去*/
		String scraptUrl = rule.getUrl();
		/**rubbishList是已经爬取过的url*/
		List<String>  rubbishList =  rubbish.rubbishUrl();
		for(int i = 1;i<=11;i++){
				String scraptUrlReal = scraptUrl.replaceAll("#", i+"");
				/**未爬取过着进行爬取*/
				if(!rubbishList.contains(scraptUrlReal)){
					rule.setUrl(scraptUrlReal);
					Document webHtml = extract(rule);
					if(webHtml==null){
						System.out.println("scraptUrlReal"+"链接失败");
						continue;
					}
					Elements movies =  webHtml.select(".movie_list li");
					for(Element movie: movies){
						String code =  movie.select(".name a").text();
						String actor  = 	movie.select(".detail a").text();
					    KeyWord keyword = new KeyWord();
						keyword.setCode(code);
						keyword.setActor(actor);	
						keywordMapper.addKeyWord(keyword);
						System.out.println("番号:"+code+"   演员:"+actor+"爬取完成");
					}
					rubbish.addRubbishUrl(scraptUrlReal);
				}else{
					System.out.println(scraptUrlReal+"以爬取过");
				}
		}
	}
}
