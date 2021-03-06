package orcamento.service.impl;

import orcamento.bean.OrcamentoBean;
import orcamento.dao.OrcamentosDAO;
import orcamento.service.IOrcamentosService;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Date;

/**
 * Created by mgustavo on 03/12/15.
 */
@Service
public class OrcamentosService implements IOrcamentosService {

    @Override
    public Collection<OrcamentoBean> listOrcamentos(Date inicio, Date fim) {
        final OrcamentosDAO orcamentosDAO = new OrcamentosDAO();
        return orcamentosDAO.listOrcamentos(inicio,fim);
    }

    @Override
    public OrcamentoBean getOrcamento(Long chavePrimaria) {
        final OrcamentosDAO orcamentosDAO = new OrcamentosDAO();
        return orcamentosDAO.readOrcamento(chavePrimaria);
    }

    @Override
    public OrcamentoBean createOrcamento(OrcamentoBean orcamentoBean) {
        final OrcamentosDAO orcamentosDAO = new OrcamentosDAO();
        return orcamentosDAO.createOrcamento(orcamentoBean);
    }

    @Override
    public Boolean updateOrcamento(OrcamentoBean orcamentoBean) {
        return true;
    }

    @Override
    public Boolean deleteOrcamento(Long codigo) {
        final OrcamentosDAO orcamentosDAO = new OrcamentosDAO();
        orcamentosDAO.deleteOrcamento(codigo);
        return true;
    }
}
