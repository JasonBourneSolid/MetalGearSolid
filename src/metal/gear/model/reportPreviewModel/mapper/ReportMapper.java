package metal.gear.model.reportPreviewModel.mapper;

import java.util.List;

import metal.gear.model.reportPreviewModel.vo.Report;

public interface ReportMapper {
	public List<Report> getReports();
	
	public Report findReportByBillNo(String billNo);
}
