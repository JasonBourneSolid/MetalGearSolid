package metal.gear.controller;


import java.util.List;
import java.util.Map;

import metal.gear.mapper.TorrentMapper;
import metal.gear.service.ScraptService;
import metal.gear.vo.LinkTypeData;
import metal.gear.vo.Rule;
import metal.gear.vo.Torrent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class SearchController {
	
	@Autowired
	TorrentMapper torrentMapper;
	
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
}
