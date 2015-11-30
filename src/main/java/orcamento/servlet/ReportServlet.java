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

public class ReportServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


		try {
			System.out.println("Diretorio do jasper: " + getServletContext().getRealPath("../resources/jasper/orcamento.jrxml"));
			
			JasperReport report = JasperCompileManager.compileReport("/var/lib/openshift/56589fd589f5cfbf2e000042/app-root/repo/target/classes/jasperorcamento.jrxml");
			System.out.println("2");
			Collection<?> clientes = null;
			JasperPrint print = null;
			print = JasperFillManager.fillReport(report, null,new JRBeanCollectionDataSource(clientes));
			System.out.println("3");
			
			//JasperExportManager.exportReportToPdfFile(print,"/home/mgustavo/Relatorio_de_Clientes.pdf");
			
			
			resp.getOutputStream().write(JasperExportManager.exportReportToPdf(print));
			
			System.out.println("4");
		} catch (JRException e) {
			e.printStackTrace();
		}

	}

}
