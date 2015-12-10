package orcamento.service.impl;

import orcamento.bean.ServicoBean;
import orcamento.dao.ServicosDAO;
import orcamento.service.IServicosService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
@Service
public class ServicoService implements IServicosService {

    @Override
    public ArrayList<ServicoBean> listServicos() {
        final ServicosDAO servicosDAO = new ServicosDAO();
        return servicosDAO.listServicos();
    }

    @Override
    public ServicoBean getServico(String chavePrimaria) {
        ServicoBean servicoBean = new ServicoBean();
        servicoBean.setCodigo("0521");
        servicoBean.setDescricao("Limpeza de lentes");
        servicoBean.setFornecedor("In House");
        servicoBean.setUnidade("par");
        servicoBean.setValorUnitario(new BigDecimal(113.90));

        return servicoBean;
    }

    @Override
    public Boolean createServico(ServicoBean servicoBean) {
        final ServicosDAO servicosDAO = new ServicosDAO();
        servicosDAO.createServico(servicoBean);
        return true;
    }

    @Override
    public Boolean updateServico(ServicoBean servicoBean) {
        return true;
    }

    @Override
    public Boolean deleteServico(String codigo) {
        final ServicosDAO servicosDAO = new ServicosDAO();
        servicosDAO.deleteServico(codigo);
        return true;
    }
}
