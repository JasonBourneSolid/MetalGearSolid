package metal.gear.model.reportPreviewModel.vo;

import java.util.List;

public interface Report {
	public List<Report> getReports();
	public Report findReportByBillNo(String billNo);
}
