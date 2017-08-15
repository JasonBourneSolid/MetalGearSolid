package metal.gear.model.reportPreviewModel.controller;

import java.util.List;

import metal.gear.model.reportPreviewModel.service.ReportPreviewService;
import metal.gear.model.reportPreviewModel.vo.Report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class ReportPreviewController {
	@Autowired
	ReportPreviewService reportPreviewService;
	public String toReportPreviewControllerPage(Model model){
		List<Report> htmlList =  reportPreviewService.getshowInfo();
		model.addAttribute("htmlReport", htmlList);
		
		return "reportManage"; 
	}
}
