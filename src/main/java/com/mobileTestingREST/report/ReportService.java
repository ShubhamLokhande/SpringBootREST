package com.mobileTestingREST.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.mobileTestingREST.entity.User;
import com.mobileTestingREST.repository.UserRepository;
import com.mobileTestingREST.service.UserService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportService {

	@Autowired
	private UserService userService;
	
	public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
		String path = "C:\\temp\\reports";
		List<User> users = userService.getAllUsers();
		
		File file = ResourceUtils.getFile("classpath:users.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(users);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "Shubham");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		
		if(reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\users.pdf");
		}
		if(reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path+"\\users.html");
		}
		return "Report Generated in path : " + path;
	}
}
