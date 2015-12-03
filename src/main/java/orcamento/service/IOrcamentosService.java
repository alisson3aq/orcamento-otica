package orcamento.service;

import orcamento.bean.OrcamentoBean;

import java.util.ArrayList;

/**
 * Created by mgustavo on 03/12/15.
 */
public interface IOrcamentosService {

    ArrayList<OrcamentoBean> listOrcamento();

    OrcamentoBean getOrcamento(String chavePrimaria);

    Boolean createOrcamento(OrcamentoBean orcamentoBean);

    Boolean updateOrcamento(OrcamentoBean orcamentoBean);

    Boolean deleteOrcamento(String chavePrimaria);

}
