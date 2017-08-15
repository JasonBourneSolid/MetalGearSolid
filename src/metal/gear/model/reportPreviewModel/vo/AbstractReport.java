package metal.gear.model.reportPreviewModel.vo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import metal.gear.model.reportPreviewModel.mapper.ReportMapper;

public abstract class AbstractReport implements Report {

	@Autowired
	ReportMapper reportMapper;
	
	@Override
	public List<Report> getReports() {
		
		return reportMapper.getReports();
	}

	@Override
	public abstract  Report findReportByBillNo(String billNo);
	
}
