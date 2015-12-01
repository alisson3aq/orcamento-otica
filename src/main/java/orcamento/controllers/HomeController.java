package orcamento.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
@RequestMapping("/export")
public class HomeController
{

   @RequestMapping(value="pdf", method=RequestMethod.GET)
   public void pdf(HttpServletResponse response) throws JRException, IOException
   {
	   System.out.println("export to pdf");
	   
	   
	   InputStream jasperStream = this.getClass().getResourceAsStream("/var/lib/openshift/56589fd589f5cfbf2e000042/app-root/repo/target/classes/jasper/orcamento.jasper");
	    Map<String,Object> params = new HashMap<String,Object>();
	    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
	    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());

	    response.setContentType("application/x-pdf");
	    response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");

	    final OutputStream outStream = response.getOutputStream();
	    JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	   
/*		//try {
		Map paramMap = new HashMap();
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
       servletOutputStream.close();  */
   }
}
