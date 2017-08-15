package metal.gear.model.btScraptModel.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import metal.gear.model.btScraptModel.mapper.TorrentMapper;
import metal.gear.model.btScraptModel.service.SearchService;
import metal.gear.model.btScraptModel.vo.LinkTypeData;
import metal.gear.model.btScraptModel.vo.Rule;
import metal.gear.model.btScraptModel.vo.Torrent;
import metal.gear.service.ScraptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class SearchController {
	
	TorrentMapper torrentMapper;
	@Autowired
	SearchService searchService;
	
	
	@RequestMapping(value="search/toPage/{page}")
	public String toPage(@PathVariable("page") String page,HttpServletRequest request)
	{	
		switch (page) {
		case "main":
			return "btScrapt/main";
		case "show":
			this.loadShowPageData(request);
			return "btScrapt/showBT";
		case "search":
			return "btScrapt/btScrapt";
		case "keyWordSearch":
			return "btScrapt/keyWordSearch";
		default:
			return "btScrapt/main";
		}
		
	}
	
		private void loadShowPageData(HttpServletRequest request) 
		{
			Map<String,Object> hashMap = new  HashMap<String, Object>();
			Map<String,Object> result =  searchService.loadShowPageData();
			request.setAttribute("torrentInfo",result);
		}

		@ResponseBody
		@RequestMapping(value="search/scrapt")
		public  void  showEmp(Map<String,Object> map,String scraptKey){
		Rule rule = new Rule(
					"http://bt.askyaya.com/index.php?r=files/index&kw="+scraptKey,
			null,null,
			"col-xs-12", Rule.CLASS, Rule.GET);
		ScraptService ss = new ScraptService();
			List<LinkTypeData> extracts =ss .extractto(rule);
			

			for(int i=0;i<extracts.size();i++){
				String href = extracts.get(i).getLinkHref();
				
				
				Rule rule2 = new Rule(
						"http://bt.askyaya.com"+href,
				null,null,
						"h4 a", Rule.SELECTION, Rule.GET);
				List<LinkTypeData> finalHref= ss.extractto(rule2);
				String src =  finalHref.get(0).getLinkHref();
				String label =  finalHref.get(0).getLinkHref();
				
				torrentMapper.add(new Torrent(label,src));
				
			
			}

	}
		@RequestMapping(value="search/collectKeyWord")
		public void collectKeyWord(){
			Rule rule = new Rule();
			String[] companys = new String[]{"PRESTIGEp","IDEA%20POCKETp","kawaiip","E%20BODYp","MAXINGp","ALICE%20JAPANp","KMPp","SODp",};
			rule.setRequestMoethod(Rule.GET);
			rule.setType(Rule.CLASS);
			for(int i = 0;i<companys.length;i++){
				String url = "http://www.cckke.com/fanhao/liebiaocompany#.html".replaceAll("company", companys[i]);
				rule.setUrl(url);
				searchService.collectKeyWord(rule);
			}		
		}
}
