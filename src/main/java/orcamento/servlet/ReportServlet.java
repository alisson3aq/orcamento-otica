package orcamento.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JasperDesignFactory;

public class ReportServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//try {
			Map paramMap = new HashMap();
			/*	InputStream reportStream = ClassLoader.getSystemResourceAsStream("/home/mgustavocoder/dev/eclipse-workspace/orcamento/src/main/resources/jasper/orcamento.jasper");
			ServletOutputStream servletOutputStream = resp.getOutputStream();
			resp.setContentType("application/pdf");
			JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, parameterMap);
*/
			 //Variaveis locais..  
	        JasperReport jasperReport = null;  
	        byte[] pdfSegundaVia = null;  
			
			 //Carrega o arquivo com o jasperReport  
	        try {  
	            jasperReport = (JasperReport) JRLoader.loadObject( "/var/lib/openshift/56589fd589f5cfbf2e000042/app-root/repo/target/classes/jasper/orcamento.jasper");  
	        } catch (JRException jre) {  
	            jre.printStackTrace();  
	        }  
	        
	      //Gera o pdf para exibicao..  
	        try {  
	            pdfSegundaVia = JasperRunManager.runReportToPdf( jasperReport, paramMap , new JREmptyDataSource() );  
	        } catch (JRException jre) {  
	            jre.printStackTrace();  
	        }  
	          
	        //Parametros para nao fazer cache e o que será exibido..  
	        resp.setContentType( "application/pdf" );  
	        resp.setHeader( "Cache-Control", "no-store" );  
	        resp.setHeader( "Pragma", "no-cache" );  
	        resp.setDateHeader( "Expires", 0 );  
	          
	        //Envia para o navegador o pdf..  
	        ServletOutputStream servletOutputStream = resp.getOutputStream();  
	        servletOutputStream.write( pdfSegundaVia );  
	        servletOutputStream.flush();  
	        servletOutputStream.close();  
			


			//byte[] byteStream = JasperRunManager.runReportToPdf("/home/mgustavocoder/dev/eclipse-workspace/orcamento/src/main/resources/jasper/orcamento.jasper",paramMap);
		/*	byte[] byteStream = JasperRunManager.runReportToPdf("/var/lib/openshift/56589fd589f5cfbf2e000042/app-root/repo/target/classes/jasper/orcamento.jasper",paramMap);
		
			//resp.setHeader("Content-Disposition","inline, filename=myReport.pdf");
			resp.setContentType("application/pdf");
			resp.setContentLength(byteStream.length);
			resp.getOutputStream().write(byteStream,0,byteStream.length);
			resp.getOutputStream().flush();     
			resp.getOutputStream().close(); */
			
			// System.out.println("Diretorio do jasper: " +
			// getServletContext().getRealPath("../resources/jasper/orcamento.jrxml"));

			// JasperReport report =
			// JasperCompileManager.compileReport("/var/lib/openshift/56589fd589f5cfbf2e000042/app-root/repo/target/classes/jasper/orcamento.jrxml");
			// JasperReport report =
			// JasperCompileManager.compileReport(getServletContext().getRealPath("../resources/jasper/orcamento.jrxml"));

			/*
			 * System.out.println("2"); Collection<?> clientes = null;
			 * JasperPrint print = null; print =
			 * JasperFillManager.fillReport(report, null,new
			 * JRBeanCollectionDataSource(clientes)); System.out.println("3");
			 */
			// JasperExportManager.exportReportToPdfFile(print,"/home/mgustavo/Relatorio_de_Clientes.pdf");

			// resp.getOutputStream().write(JasperExportManager.exportReportToPdf(print));

			// JasperRunManager.runReportToPdfStream(print,
			// resp.getOutputStream(), null, new JREmptyDataSource());

			//System.out.println("4");
/*		} catch (JRException e) {
			e.printStackTrace();
		}*/

	}

}
