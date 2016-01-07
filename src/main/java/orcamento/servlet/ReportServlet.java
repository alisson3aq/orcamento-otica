package orcamento.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import orcamento.bean.ItemBean;
import orcamento.bean.OrcamentoBean;
import orcamento.service.impl.OrcamentosService;

public class ReportServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String jasper_path = "/var/lib/openshift/56589fd589f5cfbf2e000042/app-root/repo/target/classes/jasper/orcamento1.jasper";
    //private final String jasper_path = "/home/mgustavocoder/dev/idea-workspace/orcamento/src/main/resources/jasper/orcamento1.jasper";
    //private final String jasper_path = "/home/mgustavo/dev/openshift-projects/orcamento/src/main/resources/jasper/orcamento.jasper";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Long codigo = Long.parseLong(req.getParameter("codigo"));
        OrcamentosService orcamentosService = new OrcamentosService();
        OrcamentoBean orcamentoBean = orcamentosService.getOrcamento(codigo);

        Double valorTotal = 0.0;
        for(ItemBean item : orcamentoBean.getItems()){
            valorTotal += item.getValorUnitario() * item.getQuantidade();
        }
        orcamentoBean.setValorTotal(valorTotal);

        Map paramMap = new HashMap();
        paramMap.put("orcamentoBean",orcamentoBean);
        paramMap.put("codigo",orcamentoBean.getCodigo());
        //Variaveis locais..
        JasperReport jasperReport = null;
        byte[] pdfSegundaVia = null;

        //Carrega o arquivo com o jasperReport
        try {
            jasperReport = (JasperReport) JRLoader.loadObject(jasper_path);
        } catch (JRException jre) {
            jre.printStackTrace();
        }

        //Gera o pdf para exibicao..
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/orcamento?useUnicode=true&characterEncoding=UTF-8","admine8eKGLZ","NZlq5Npa4umb");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.12.98.130:3306/orcamento?useUnicode=true&characterEncoding=UTF-8","admine8eKGLZ","NZlq5Npa4umb");
            pdfSegundaVia = JasperRunManager.runReportToPdf(jasperReport, paramMap,conn);
/*            String reportPath = JasperRunManager.runReportToHtmlFile(jasper_path, paramMap, conn);

            File reportHtmlFile = new File(reportPath);
            FileInputStream fis = new FileInputStream(reportHtmlFile);
            byte[] bytes =  new byte[(int)reportHtmlFile.length()];
            fis.read(bytes);
            resp.setHeader("Content-Disposition","inline; filename=myReport.html");
            resp.setContentType("text/html");
            resp.setContentLength(bytes.length);
            ServletOutputStream servletOutputStream = resp.getOutputStream();
            servletOutputStream.write(bytes, 0, bytes.length);
            servletOutputStream.flush();
            servletOutputStream.close();*/

        } catch (Exception jre) {
            jre.printStackTrace();
        }




        //Parametros para nao fazer cache e o que será exibido..
        resp.setContentType("application/pdf");
        resp.setHeader("Cache-Control", "no-store");
        resp.setHeader("Pragma", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setHeader("Content-disposition", "attachment; filename=\"orc-" + orcamentoBean.getCodigo() + ".pdf\"");

        //Envia para o navegador o pdf..
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        servletOutputStream.write(pdfSegundaVia);
        servletOutputStream.flush();
        servletOutputStream.close();

    }

}
