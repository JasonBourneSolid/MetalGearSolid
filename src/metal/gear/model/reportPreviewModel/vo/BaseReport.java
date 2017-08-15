package metal.gear.model.reportPreviewModel.vo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import metal.gear.model.reportPreviewModel.mapper.ReportMapper;
@Component
public  class BaseReport implements Report {

	@Autowired
	ReportMapper reportMapper;
	private int id ;
	/**报告类型*/
	private int typeCode;
	
	/**系统生成报告流水号*/
	private String billNo;
	
	/**报告名称*/
	private String reportName;
	
	public int getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	
	
	
	@Override
	public  List<Report> getReports() {	
		return reportMapper.getReports();
	}
	@Override
	public  List<String> getReportType(){
		return reportMapper.getReportType();
	}
	@Override
	public   Report findReportByBillNo(String billNo){
		return reportMapper.findReportByBillNo(billNo);
		
	}


	
}
