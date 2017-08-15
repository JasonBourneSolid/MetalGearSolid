package metal.gear.model.reportPreviewModel.service;

import java.util.List;

import metal.gear.model.reportPreviewModel.vo.HTMLReport;
import metal.gear.model.reportPreviewModel.vo.Report;

public class ReportPreviewService {

	public List<Report> getshowInfo() {
		HTMLReport htmlReport = new HTMLReport();
		return 	htmlReport.getReports();
		
	}

}
