package orcamento.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import orcamento.bean.OrcamentoBean;
import orcamento.service.impl.OrcamentosService;

public class ReportServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String jasper_path = "/var/lib/openshift/56589fd589f5cfbf2e000042/app-root/repo/target/classes/jasper/orcamento.jasper";
    //private final String jasper_path = "/home/mgustavocoder/dev/idea-workspace/orcamento/src/main/resources/jasper/orcamento.jasper";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Long codigo = Long.parseLong(req.getParameter("codigo"));
        OrcamentosService orcamentosService = new OrcamentosService();
        OrcamentoBean orcamentoBean = orcamentosService.getOrcamento(codigo);

        Map paramMap = new HashMap();
        paramMap.put("orcamentoBean",orcamentoBean);
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
            pdfSegundaVia = JasperRunManager.runReportToPdf(jasperReport, paramMap, new JREmptyDataSource());
        } catch (JRException jre) {
            jre.printStackTrace();
        }

        //Parametros para nao fazer cache e o que será exibido..
        resp.setContentType("application/pdf");
        resp.setHeader("Cache-Control", "no-store");
        resp.setHeader("Pragma", "no-cache");
        resp.setDateHeader("Expires", 0);

        //Envia para o navegador o pdf..
        ServletOutputStream servletOutputStream = resp.getOutputStream();
        servletOutputStream.write(pdfSegundaVia);
        servletOutputStream.flush();
        servletOutputStream.close();

    }

}
