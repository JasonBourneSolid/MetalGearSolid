package metal.gear.model.reportPreviewModel.vo;

import org.springframework.beans.factory.annotation.Autowired;

import metal.gear.model.reportPreviewModel.mapper.ReportMapper;

public class HTMLReport extends AbstractReport {
   @Autowired
	ReportMapper reportMapper ;
	
	private String billNo;
	
	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	
	@Override
	public Report findReportByBillNo(String billNo) {
		
		return reportMapper.findReportByBillNo(billNo);
	}



}
