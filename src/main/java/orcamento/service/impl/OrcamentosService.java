package orcamento.service.impl;

import orcamento.bean.OrcamentoBean;
import orcamento.dao.OrcamentosDAO;
import orcamento.service.IOrcamentosService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
@Service
public class OrcamentosService implements IOrcamentosService {

    @Override
    public ArrayList<OrcamentoBean> listOrcamentos() {
        return null;
    }

    @Override
    public OrcamentoBean getOrcamento(String chavePrimaria) {
        return null;
    }

    @Override
    public void createOrcamento(OrcamentoBean orcamentoBean) {
        final OrcamentosDAO orcamentosDAO = new OrcamentosDAO();
        orcamentosDAO.createOrcamento(orcamentoBean);
    }

    @Override
    public Boolean updateOrcamento(OrcamentoBean orcamentoBean) {
        return true;
    }

    @Override
    public Boolean deleteOrcamento(String chavePrimaria) {
        return true;
    }
}
