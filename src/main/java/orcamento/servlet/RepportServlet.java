package orcamento.servlet;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class RepportServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		JasperReport report = null;
		try {
			report = JasperCompileManager.compileReport("/home/mgustavo/dev/EclipseProjects/orcamento/src/main/resources/jasper/orcamento.jrxml");
		} catch (JRException e) {
			e.printStackTrace();
		}
		
		Collection<?> clientes = null;
		JasperPrint print = null;
		try {
			print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(clientes));
		} catch (JRException e) {
			e.printStackTrace();
		}
 
		try {
			JasperExportManager.exportReportToPdfFile(print, "/home/mgustavo/Relatorio_de_Clientes.pdf");
		} catch (JRException e) {
			e.printStackTrace();
		}		
	
	}
	
}
