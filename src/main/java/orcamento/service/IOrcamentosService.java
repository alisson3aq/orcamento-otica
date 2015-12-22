package orcamento.service;

import orcamento.bean.OrcamentoBean;
import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
public interface IOrcamentosService {

    ArrayList<OrcamentoBean> listOrcamentos();

    OrcamentoBean getOrcamento(String chavePrimaria);

    void createOrcamento(OrcamentoBean orcamentoBean);

    Boolean updateOrcamento(OrcamentoBean orcamentoBean);

    Boolean deleteOrcamento(String chavePrimaria);

}
